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

@WebServlet("/searchAction")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static String json;

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Util.setCharset(request, response, "utf-8");

		JSONObject data1 = new JSONObject();
		data1.put("name", "kimsoyeon");
		data1.put("major", "sw");

		JSONObject data2 = new JSONObject();
		data2.put("name", "bae");
		data2.put("major", "dkdk");

		JSONObject data3 = new JSONObject();
		data3.put("name", "prk");
		data3.put("major", "ssss");

		JSONObject data4 = new JSONObject();
		data4.put("name", "dddd");
		data4.put("major", "be");

		JSONArray arr = new JSONArray();
		arr.add(data1);
		arr.add(data2);
		arr.add(data3);
		arr.add(data4);
		
		request.setAttribute("JSONArray", arr);
		request.getRequestDispatcher("/JSP/search2.jsp").forward(request, response);
	}

}
