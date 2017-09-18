package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


@WebServlet("/classroom")
public class classroom extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
Util.setCharset(request, response, "utf-8");
		
		String str;
		
		JSONArray arr =new JSONArray();
		
		for(int i=1;i<21;i++)
		{
			JSONObject data1 = new JSONObject();
			str = Integer.toString(i);
			data1.put("name", "±è¼Ò¿¬");
			data1.put("oneline", "hello world!");
			data1.put("StuImg", "/2uzubook/CSS/Image/student/stu"+str+".jpg");
			arr.add(data1);
		}
		
		
		request.setAttribute("JSONArray", arr);
		request.getRequestDispatcher("/JSP/first-first-class.jsp").forward(request, response);
	}

}
