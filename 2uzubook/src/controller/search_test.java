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
import org.json.simple.JSONValue;

import resume.ResumeDAO;

@WebServlet("/search_test") //keyword 중간에 목록 받아오기
public class search_test extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ResumeDAO database;
    public search_test() {
    	database=ResumeDAO.getInstance();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Object obj=JSONValue.parse(request.getParameter("str"));
		JSONObject jobj=(JSONObject)obj;
		JSONArray jsonArray=database.search_keyword((String)jobj.get("data")); //실제 db에서 긁어오는 것.
//		JSONArray jsonArray=new JSONArray(); //test 용
//		for(int i=0;i<3;i++)
//		{
//			JSONObject data1=new JSONObject();
//			data1.put("id",i);
//			data1.put("name", "hello"+i);
//			jsonArray.add(data1);
//		}
		PrintWriter out=response.getWriter();
		out.write(jsonArray.toString());
		out.flush();
	}

}
