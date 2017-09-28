package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

@WebServlet("/indexAction")
public class index_test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Util.setCharset(request, response, "utf-8");
		String str;
		
		JSONArray arr =new JSONArray();
		
		for(int i=1;i<10;i++)
		{
			JSONObject data1 = new JSONObject();
			str = Integer.toString(i);
			data1.put("name", "kimsoyeon"+str);
			data1.put("major", "소프트웨어 개발과"+str);
			data1.put("student_img", "/2uzubook/images/student/stu"+str+".jpg");
			data1.put("student_id",20106);
			arr.add(data1);
		}
		System.out.println("hello");
		
		PrintWriter out=response.getWriter();
		
		out.write(arr.toString());
		out.flush();
	}

}
