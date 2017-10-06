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

@WebServlet("/loginAction/company")
public class LoginAction_Company extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		CompanyDAO companyDAO = CompanyDAO.getInstance();
		Util.setCharset(request, response, "utf-8");

		String serialKey = request.getParameter("serialKey");
		int result = companyDAO.login(serialKey);

		PrintWriter out = response.getWriter();

		if (result == 1) {
			HttpSession session = request.getSession();
			session.setAttribute("serialKey", serialKey);
			response.sendRedirect("../index.jsp");
			System.out.println(session.getAttribute("serialKey"));
			return;
		} else if (result == 0) {
			out.println("<script>alert('존재하지 않는 아이디입니다.'); history.back();</script>");
			System.out.println("로그인 실패");
			return;
		} else if (result == -1) {
			out.println("<script>alert('디비오류'); history.back();</script>");
			System.out.println("로그인 실패");
			return;
		}
	}

}
