package study.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import study.bean.DataAccessBean;

@SuppressWarnings("serial")
@WebServlet(name = "DeleteCountries", urlPatterns = "/delete")
public class DeleteCountries extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			String code = request.getParameter("code");
			DataAccessBean dab = new DataAccessBean();
			dab.deleteUserInfo(code);
			response.sendRedirect(request.getContextPath() + "/importdata");
		} catch (SQLException e) {
			e.printStackTrace();
			request.getRequestDispatcher("/WEB-INF/error.jsp").forward(request,
					response);
		}
	}
}
