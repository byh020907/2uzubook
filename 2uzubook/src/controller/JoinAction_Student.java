package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Database;
import user.User;
import user.UserDAO;

/**
 * Servlet implementation class JoinAction
 */

@WebServlet("/joinAction/student")
public class JoinAction_Student extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserDAO userDAO = new UserDAO();
		Util.setCharset(request, response, "UTF-8");

		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String adm_year = request.getParameter("adm_year");
		String stu_id = request.getParameter("stu_id");
		String intro = request.getParameter("intro");
		String major = request.getParameter("major");

		PrintWriter out = response.getWriter();
		if (name == null || gender == null || email == null || id == null || password == null || adm_year == null
				|| stu_id == null || intro == null || major == null) {
			out.print("<script>alert('정보를 모두 입력하세요.');history.back();</script>");
			return;
		}

		int result = userDAO.join(name, gender, email, id, password, Integer.parseInt(adm_year),
				Integer.parseInt(stu_id), intro, Integer.parseInt(major));

		if (result >= 0) {
			out.print("<script>alert('회원가입을 성공했습니다.');location.href='../index.jsp';</script>");
			return;
		} else {
			out.print("<script>alert('회원가입을 실패했습니다.');history.back();</script>");
			return;
		}
	}

}
