package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import company.CompanyDAO;
import user.UserDAO;

/**
 * Servlet implementation class LoginAction
 */

@WebServlet("/logoutAction")
public class LoginOutAction extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Util.setCharset(request, response, "utf-8");
		
		HttpSession session = request.getSession();
		session.setAttribute("id", null);
		session.setAttribute("serialKey", null);

		PrintWriter out = response.getWriter();

		response.sendRedirect("index.jsp");
		return;

	}

}
