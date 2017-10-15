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
import etc.Interest;
import etc.Reading;
import etc.Volunteer;
import resume.Award;
import resume.Cert;
import resume.Club;
import resume.Conference;
import resume.Project;
import resume.ResumeDAO;
import resume.Test;

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
		int ret=-1;
		
		switch(part)
		{
			case 1:{
				String name=request.getParameter("name");
				String ins=request.getParameter("ins");
				String date=request.getParameter("date");
				int keyword=Integer.parseInt(request.getParameter("keyword"));
				System.out.println(part+name+ins+date+keyword);
				Cert cert=new Cert(userID,name,ins,date,keyword);
				ret=database.insert_cert(cert);
			}break;
			case 2:{
				String name=request.getParameter("name");
				String ins=request.getParameter("ins");
				String date=request.getParameter("date");
				String grade=request.getParameter("grade");
				int keyword=Integer.parseInt(request.getParameter("keyword"));
				System.out.println(part+name+ins+date+grade+keyword);
				Award awd=new Award(userID,name,ins,grade,date,keyword);
				ret=database.insert_award(awd);
			}break;
			case 4:{
				String name=request.getParameter("name");
				String desc=request.getParameter("desc");
				String startdate=request.getParameter("startdate");
				String enddate=request.getParameter("enddate");
				int keyword=Integer.parseInt(request.getParameter("keyword"));
				System.out.println(part+name+startdate+enddate+keyword);
				Project pro=new Project(userID,name,desc,startdate,enddate,keyword);
				ret=database.insert_project(pro);
			}break;
			case 3:{
				String name=request.getParameter("name");
				String desc=request.getParameter("desc");
				String startdate=request.getParameter("startdate");
				String enddate=request.getParameter("enddate");
				int keyword=Integer.parseInt(request.getParameter("keyword"));
				System.out.println(part+name+startdate+enddate+keyword);
				Club club=new Club(userID,name,desc,startdate,enddate,keyword);
				ret=database.insert_club(club);
			}break;
			case 5:{
				String name=request.getParameter("name");
				String date=request.getParameter("date");
				int keyword=Integer.parseInt(request.getParameter("keyword"));
				System.out.println(part+name+date+keyword);
				Conference con=new Conference(userID,name,date,keyword);
				ret=database.insert_conference(con);
			}break;
			case 6:{
				String name=request.getParameter("name");
				String date=request.getParameter("date");
				int keyword=Integer.parseInt(request.getParameter("keyword"));
				System.out.println(part+name+date+keyword);
				Reading reading=new Reading(userID,name,date,keyword);
				ret=database2.insert_reading(reading);
			}break;
			case 7:{
				String name=request.getParameter("name");
				String ins=request.getParameter("ins");
				String startdate=request.getParameter("startdate");
				String enddate=request.getParameter("enddate");
				int keyword=Integer.parseInt(request.getParameter("keyword"));
				
				System.out.println(part+name+ins+startdate+enddate+keyword);
				Volunteer volunteer=new Volunteer(userID,name,ins,startdate,enddate,keyword);
				ret=database2.insert_volunteer(volunteer);
			}break;
			case 8:{
				String name=request.getParameter("name");
				int score=Integer.parseInt(request.getParameter("score"));
				String date=request.getParameter("date");
				int keyword=Integer.parseInt(request.getParameter("keyword"));
				System.out.println(part+name+score+keyword);
				Test test=new Test(userID,name,score,date,keyword);
				ret=database.insert_test(test);
			}break;
			case 9:{
				String name=request.getParameter("name");
				int keyword=database.getKeywordNum(name);
				System.out.println(part+name+keyword);
				Interest interest=new Interest(userID,name,keyword);
				ret=database2.insert_interest(interest);
			}break;
		}
		JSONObject data1=new JSONObject();
		data1.put("ret", ret);
		System.out.println(data1.toString());
		PrintWriter out=response.getWriter();
		out.write(data1.toString());
		out.flush();
	}

}
