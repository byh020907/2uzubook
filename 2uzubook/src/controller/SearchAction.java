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

@WebServlet("/searchAction")
public class SearchAction extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ResumeDAO resumeDAO = new ResumeDAO();
		Util.setCharset(request, response, "utf-8");

		//String query = request.getParameter("q");
		//int result = resumeDAO.search(query);
		
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
		request.getRequestDispatcher("/JSP/search_result.jsp").forward(request, response);
	}

}
