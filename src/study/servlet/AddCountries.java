package study.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import study.bean.DataAccessBean;
import study.bean.ImportInfo;

@SuppressWarnings("serial")
@WebServlet(name = "AddCountries", urlPatterns = "/add")
public class AddCountries extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			String code = request.getParameter("code");
			String countries = request.getParameter("countries");
			String symbol = request.getParameter("symbol");

			if (code == null || code.length() < 1) {
				request.setAttribute("message", "please input [code]");
				RequestDispatcher rd = request
						.getRequestDispatcher("/addcountries.jsp");
				rd.forward(request, response);
				return;
			}
			if (countries == null || countries.length() < 1) {
				request.setAttribute("message", "please input [countries]");
				RequestDispatcher rd = request
						.getRequestDispatcher("/addcountries.jsp");
				rd.forward(request, response);
				return;
			}
			ImportInfo importInfo = new ImportInfo();
			importInfo.setCode(code);
			importInfo.setCountries(countries);
			importInfo.setSymbol(symbol);

			DataAccessBean dab = new DataAccessBean();
			dab.registImportInfo(importInfo);
			response.sendRedirect(request.getContextPath() + "/importdata");
		} catch (SQLException e) {
			e.printStackTrace();
			request.getRequestDispatcher("/WEB-INF/error.jsp").forward(request,
					response);
		}
	}
}
