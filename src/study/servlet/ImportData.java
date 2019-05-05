package study.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import study.bean.DataAccessBean;
import study.bean.ImportInfo;

@SuppressWarnings("serial")
@WebServlet(name = "ImportData", urlPatterns = "/importdata")
public class ImportData extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
			DataAccessBean dab = new DataAccessBean();
			Collection<ImportInfo> importInfoList = dab.findAllUserInfo();
			request.setAttribute("InfoList", importInfoList);
			RequestDispatcher rd = request
					.getRequestDispatcher("/WEB-INF/importdata.jsp");
			rd.forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
			request.getRequestDispatcher("/WEB-INF/error.jsp").forward(request,
					response);
		}
	}

}
