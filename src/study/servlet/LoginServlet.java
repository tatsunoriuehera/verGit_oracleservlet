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

@SuppressWarnings("serial")
@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			String userName = request.getParameter("userName");
			String password = request.getParameter("password");
			DataAccessBean dab = new DataAccessBean();
			if (dab.authentication(userName, password)) {
				request.setAttribute("userName", userName);
				RequestDispatcher rd = request
						.getRequestDispatcher("/WEB-INF/welcome.jsp");
				rd.forward(request, response);
			} else {
				request.setAttribute("message", "error!");
				RequestDispatcher rd = request
						.getRequestDispatcher("/login.jsp");
				rd.forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}
}
