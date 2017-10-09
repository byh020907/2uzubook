package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import etc.EtcDAO;
import resume.ResumeDAO;

@WebServlet("/ResumeRemove")
public class ResumeRemove extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ResumeDAO database;
    EtcDAO database2;
	public ResumeRemove() {
        database=ResumeDAO.getInstance();
        database2=EtcDAO.getInstance();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String userID=(String) session.getAttribute("id");
		int part=Integer.parseInt((String)request.getParameter("part"));
		int returnValue=-100;
		switch(part)
		{
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
			case 6:{
				returnValue=database.delete_resume(userID, request.getParameter("name"), part);
			}break;
			case 7:{
				returnValue=database2.delete_etc(userID, request.getParameter("name"), 1);
			}break;
			case 8:{
				returnValue=database2.delete_etc(userID, request.getParameter("name"), 2);
			}break;
		}
		JSONObject returnJson=new JSONObject();
		returnJson.put("status", returnValue);
		PrintWriter out=response.getWriter();
		out.write(returnJson.toString());
		out.flush();
	}
	

}
