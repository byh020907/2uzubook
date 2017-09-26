package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import dao.Database;

@WebServlet("/searchAction")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Database database;
	
	public SearchServlet(){
		database=Database.getInstance();
	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Util.setCharset(request, response, "utf-8");

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
