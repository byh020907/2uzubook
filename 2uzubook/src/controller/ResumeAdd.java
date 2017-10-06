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
import org.json.simple.JSONValue;

import resume.Cert;
import resume.ResumeDAO;

@WebServlet("/ResumeAdd")
public class ResumeAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ResumeDAO database;
	public ResumeAdd() {
		database=new ResumeDAO();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String userID=(String) session.getAttribute("id");
		
		int part=Integer.parseInt(request.getParameter("part"));
		
		JSONArray jsonArray = null;
		switch(part)
		{
			case 1:{
				String name=request.getParameter("name");
				String ins=request.getParameter("ins");
				String date=request.getParameter("date");
				int keyword=Integer.parseInt(request.getParameter("keyword"));
				
				Cert cert=new Cert(userID,name,ins,date,keyword);
				database.insert_cert(cert);
				jsonArray=database.select_resume(userID, part);
			}break;
			
		}
		
		PrintWriter out=response.getWriter();
		out.write(jsonArray.toString());
		out.flush();
	}

}
