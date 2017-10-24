package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;

import resume.ResumeDAO;

@WebServlet("/ResumeUpdate")
public class ResumeUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ResumeDAO database;
    public ResumeUpdate() {
    	database=ResumeDAO.getInstance();
       
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Util.setCharset(request, response, "utf-8");
		
		HttpSession session=request.getSession();
		
		int position=Integer.parseInt(request.getParameter("position"));
		int select_func=Integer.parseInt(request.getParameter("select_func"));
		String userID=(String) session.getAttribute("id");
		
		if(session.getAttribute("id")==null){
			response.sendRedirect("/2uzubook/login.jsp");
			return;
		}
		switch(select_func)
		{
		case 1:{			
			JSONArray result=database.select_resume(userID, position); //조회
		}break;
		
		case 2:{
			
		}break;
			
		}
	}

}
