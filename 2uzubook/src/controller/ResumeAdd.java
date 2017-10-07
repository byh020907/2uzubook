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
import etc.Reading;
import etc.Volunteer;
import resume.Award;
import resume.Cert;
import resume.Club;
import resume.Conference;
import resume.Project;
import resume.ResumeDAO;

@WebServlet("/ResumeAdd")
public class ResumeAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ResumeDAO database;
	EtcDAO database2;
	public ResumeAdd() {
		database=ResumeDAO.getInstance();
		database2=EtcDAO.getInstance();
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
				System.out.println(part+name+ins+date+keyword);
				Cert cert=new Cert(userID,name,ins,date,keyword);
				database.insert_cert(cert);
				jsonArray=database.select_resume(userID, part);
			}break;
			case 2:{
				String name=request.getParameter("name");
				String ins=request.getParameter("ins");
				String date=request.getParameter("date");
				String grade=request.getParameter("grade");
				int keyword=Integer.parseInt(request.getParameter("keyword"));
				
				System.out.println(part+name+ins+date+grade+keyword);
				Award awd=new Award(userID,name,ins,grade,date,keyword);
				database.insert_award(awd);
				jsonArray=database.select_resume(userID, part);
			}break;
			case 4:{
				String name=request.getParameter("name");
				String desc=request.getParameter("desc");
				String startdate=request.getParameter("startdate");
				String enddate=request.getParameter("enddate");
				int keyword=Integer.parseInt(request.getParameter("keyword"));
				System.out.println(part+name+startdate+enddate+keyword);
				Project pro=new Project(userID,name,desc,startdate,enddate,keyword);
				database.insert_project(pro);
				jsonArray=database.select_resume(userID, part);
			}break;
			case 3:{
				String name=request.getParameter("name");
				String desc=request.getParameter("desc");
				String startdate=request.getParameter("startdate");
				String enddate=request.getParameter("enddate");
				int keyword=Integer.parseInt(request.getParameter("keyword"));
				System.out.println(part+name+startdate+enddate+keyword);
				Club club=new Club(userID,name,desc,startdate,enddate,keyword);
				database.insert_club(club);
				jsonArray=database.select_resume(userID, part);
			}break;
			case 5:{
				String name=request.getParameter("name");
				String date=request.getParameter("date");
				int keyword=Integer.parseInt(request.getParameter("keyword"));
				System.out.println(part+name+date+keyword);
				Conference con=new Conference(userID,name,date,keyword);
				database.insert_conference(con);
				jsonArray=database.select_resume(userID, part);
			}break;
			case 6:{
				String name=request.getParameter("name");
				String date=request.getParameter("date");
				int keyword=Integer.parseInt(request.getParameter("keyword"));
				System.out.println(part+name+date+keyword);
				Reading reading=new Reading(userID,name,date,keyword);
				database2.insert_reading(reading);
				jsonArray=database2.select_resume(userID,2);
			}break;
			case 7:{
				String name=request.getParameter("name");
				String ins=request.getParameter("ins");
				String startdate=request.getParameter("startdate");
				String enddate=request.getParameter("enddate");
				int keyword=Integer.parseInt(request.getParameter("keyword"));
				
				System.out.println(part+name+ins+startdate+enddate+keyword);
				Volunteer volunteer=new Volunteer(userID,name,ins,startdate,enddate,keyword);
				database2.insert_volunteer(volunteer);
				jsonArray=database2.select_resume(userID,1);
			}break;
		}
		
		PrintWriter out=response.getWriter();
		out.write(jsonArray.toString());
		out.flush();
	}

}
