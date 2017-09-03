package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


@WebServlet("/searchAction")
public class searchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static String json;
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Util.setCharset(request, response, "utf-8");
		
		JSONObject data1=new JSONObject();
		data1.put("name", "kimsoyeon");
		data1.put("major", "sw");
		
		JSONObject data2=new JSONObject();
		data1.put("name", "bae");
		data1.put("major", "dkdk");
		
		JSONObject data3=new JSONObject();
		data1.put("name", "prk");
		data1.put("major", "ssss");
		
		JSONObject data4=new JSONObject();
		data1.put("name", "dddd");
		data1.put("major", "be");
		
		JSONArray arr =new JSONArray();
		arr.add(data1);
		arr.add(data2);
		arr.add(data3);
		arr.add(data4);
		System.out.println(arr);
		request.setAttribute("json",arr);
		request.getRequestDispatcher("/2uzubook/search2.jsp").forward(request,response);
	}

}
