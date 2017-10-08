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
		switch(part)
		{
		case 1:{
			database.delete_resume(userID, request.getParameter("name"), part);
		}break;
		case 2:{
			database.delete_resume(userID, request.getParameter("name"), part);
		}break;
		case 3:{

			database.delete_resume(userID, request.getParameter("name"), part);
		}break;
		case 4:{

			database.delete_resume(userID, request.getParameter("name"), part);
		}break;
		case 5:{

			database.delete_resume(userID, request.getParameter("name"), part);
		}break;
		case 6:{

			database.delete_resume(userID, request.getParameter("name"), part);
		}break;
		case 7:{

			database2.delete_etc(userID, request.getParameter("name"), part);
		}break;
		case 8:{

			database2.delete_etc(userID, request.getParameter("name"), part);
		}break;
		case 9:{
			
		}break;
		}
		JSONArray jsonArray=new JSONArray();
		PrintWriter out=response.getWriter();
		out.write(jsonArray.toString());
		out.flush();
	}
	

}
