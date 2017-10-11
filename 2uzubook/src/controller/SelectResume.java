package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;

import etc.EtcDAO;
import etc.Reading;
import etc.Volunteer;
import resume.Award;
import resume.Cert;
import resume.Club;
import resume.Conference;
import resume.Project;
import resume.ResumeDAO;

@WebServlet("/SelectResume")
public class SelectResume extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ResumeDAO database;
	EtcDAO database2;
    public SelectResume() {
    	database=ResumeDAO.getInstance();
		database2=EtcDAO.getInstance();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String userID=(String) session.getAttribute("id");
		
		int part=Integer.parseInt(request.getParameter("part"));
		JSONArray jsonArray = null;
		JSONArray keywordArray = null;
		switch(part)
		{
			case 1:{
				jsonArray=database.select_resume(userID, part);//license
				request.setAttribute("JSONArray", jsonArray);
				keywordArray=database.select_keyword();
				request.setAttribute("KeywordArray", keywordArray);
				request.getRequestDispatcher("/license.jsp").forward(request, response);
			}break;
			case 2:{
				jsonArray=database.select_resume(userID, part);//award
				request.setAttribute("JSONArray", jsonArray);
				keywordArray=database.select_keyword();
				request.setAttribute("KeywordArray", keywordArray);
				request.getRequestDispatcher("/award.jsp").forward(request, response);
			}break;
			case 3:{
				jsonArray=database.select_resume(userID, part); //club
				request.setAttribute("JSONArray", jsonArray);
				keywordArray=database.select_keyword();
				request.setAttribute("KeywordArray", keywordArray);
				request.getRequestDispatcher("/club.jsp").forward(request, response);
			}break;
			case 4:{
				jsonArray=database.select_resume(userID, part);//project
				request.setAttribute("JSONArray", jsonArray);
				keywordArray=database.select_keyword();
				request.setAttribute("KeywordArray", keywordArray);
				request.getRequestDispatcher("/project.jsp").forward(request, response);
			}break;
			case 5:{
				jsonArray=database.select_resume(userID,part);//test
				request.setAttribute("JSONArray", jsonArray);
				keywordArray=database.select_keyword();
				request.setAttribute("KeywordArray", keywordArray);
				request.getRequestDispatcher("/test.jsp").forward(request, response);
			}
			case 6:{
				jsonArray=database.select_resume(userID, part);//conference
				request.setAttribute("JSONArray", jsonArray);
				keywordArray=database.select_keyword();
				request.setAttribute("KeywordArray", keywordArray);
				request.getRequestDispatcher("/conference.jsp").forward(request, response);
			}break;
			case 7:{
				jsonArray=database2.select_resume(userID,2);//reading
				request.setAttribute("JSONArray", jsonArray);
				keywordArray=database.select_keyword();
				request.setAttribute("KeywordArray", keywordArray);
				request.getRequestDispatcher("/reading.jsp").forward(request, response);
			}break;
			case 8:{
				jsonArray=database2.select_resume(userID,1);//volunteer
				request.setAttribute("JSONArray", jsonArray);
				keywordArray=database.select_keyword();
				request.setAttribute("KeywordArray", keywordArray);
				request.getRequestDispatcher("/volunteer.jsp").forward(request, response);
			}break;
			case 9:{
				jsonArray=database2.select_resume(userID,3);//interest
				request.setAttribute("JSONArray", jsonArray);
				keywordArray=database.select_keyword();
				request.setAttribute("KeywordArray", keywordArray);
				request.getRequestDispatcher("/interest.jsp").forward(request, response);
			}
			
		}

		
	}

}
