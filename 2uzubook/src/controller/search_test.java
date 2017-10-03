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

import resume.ResumeDAO;

@WebServlet("/search_test") //keyword 중간에 목록 받아오기
public class search_test extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ResumeDAO database;
    public search_test() {
    	database=new ResumeDAO();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String str = request.getParameter("str");
		
		JSONArray jsonArray=database.search_keyword(str); //실제 db에서 긁어오는 것.
//		JSONArray jsonArray=new JSONArray(); //test 용
//		JSONObject data1=new JSONObject();
//		for(int i=0;i<3;i++)
//		{
//			data1.put("id",i);
//			data1.put("text", "hello"+i);
//			jsonArray.add(data1);
//		}
		PrintWriter out=response.getWriter();
		out.write(jsonArray.toString());
		out.flush();
	}

}
