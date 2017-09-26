package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import resume.ResumeDAO;

/**
 * Servlet implementation class SearchAction
 */

@WebServlet("/loginAction")
public class SearchAction extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ResumeDAO resumeDAO = new ResumeDAO();
		Util.setCharset(request, response, "utf-8");

		String query = request.getParameter("q");
		int result = resumeDAO.search(query);

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
		JSONObject data1 = new JSONObject();
		data1.put("name", "김소연");
		data1.put("major", "sw개발과");

		JSONObject data2 = new JSONObject();
		data2.put("name", "배용호");
		data2.put("major", "sw개발과");

		JSONObject data3 = new JSONObject();
		data3.put("name", "박규리");
		data3.put("major", "sw개발과");

		JSONObject data4 = new JSONObject();
		data4.put("name", "윤정현");
		data4.put("major", "sw개발과");

		JSONArray arr = new JSONArray();
		arr.add(data1);
		arr.add(data2);
		arr.add(data3);
		arr.add(data4);

		request.setAttribute("JSONArray", arr);
		request.getRequestDispatcher("/JSP/search2.jsp").forward(request, response);
	}

}
