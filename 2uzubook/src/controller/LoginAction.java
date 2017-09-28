package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.UserDAO;

/**
 * Servlet implementation class LoginAction
 */

@WebServlet("/loginAction")
public class LoginAction extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserDAO userDAO = new UserDAO();
		Util.setCharset(request, response, "utf-8");

		String id = request.getParameter("id");
		String password = request.getParameter("password");
		int result = userDAO.login(id, password);

		PrintWriter out = response.getWriter();

		if (result == 1) {
			HttpSession session = request.getSession();
			session.setAttribute("id", id);
			response.sendRedirect("index.jsp");
			System.out.println(session.getAttribute("id"));
			return;
		} else if (result == 0) {
			out.println("<script>alert('비밀번호가 틀렸습니다.'); history.back();</script>");
			System.out.println("로그인 실패");
			return;
		} else if (result == -1) {
			out.println("<script>alert('존재하지 않는 아이디입니다.'); history.back();</script>");
			System.out.println("로그인 실패");
			return;
		}
	}

}
