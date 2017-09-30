package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import resume.Award;
import resume.ResumeDAO;

/**
 * Servlet implementation class ResumeInputServlet
 */
@WebServlet("/resumeInputAction")
public class ResumeInputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ResumeDAO database;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResumeInputServlet() {
    	database=ResumeDAO.getInstance();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Util.setCharset(request, response, "utf-8");
		
		int type=Integer.parseInt(request.getParameter("type"));
		
		HttpSession session=request.getSession();
		PrintWriter out=response.getWriter();

		if(session.getAttribute("id")==null){
			response.sendRedirect("/2uzubook/JSP/login.jsp");
			return;
		}
		
		//세션 아이디를 통해 학번을 얻는 과정
		JSONArray ja=database.executeAndGet("SELECT student_id from account where id=?", session.getAttribute("id"));
		int student_id=(int) ((JSONObject)ja.get(0)).get("student_id");
		//
		
		int result=-100;
		
		switch(type){
			case 1:{
				String own=request.getParameter("one");
				String two=request.getParameter("two");
				String three=request.getParameter("three");
				
				database.i
				
				System.out.println(own+two+three);
			}break;
			
			case 2:{
				String[] licenseName=request.getParameterValues("licenseName");
				String[] licenseDate=request.getParameterValues("licenseDate");
				String[] jumsu=request.getParameterValues("jumsu");
			}break;
					
			case 3:{
				String[] conference=request.getParameterValues("conference");
				String[] conferenceDate=request.getParameterValues("conferenceDate");
			}break;
			
			case 4:{
				String[] awardName=request.getParameterValues("awardName");
				String[] award=request.getParameterValues("award");
				String[] awardDate=request.getParameterValues("awardDate");
				
				System.out.println(awardName+","+award+","+awardDate);
				ArrayList<Award> awards=new ArrayList<>();
				for(int i=0;i<awardName.length;i++){
					Award Award=new Award(student_id,awardName[i],award[i],awardDate[i]);
					awards.add(Award);
				}
				
				result=database.inputCareer_award(awards, student_id);
			}break;
			
			case 5:{
				
			}break;
			
			case 6:{
				
			}break;
		}
		
		out.print("<script> history.back() </script>");
		System.out.println(result);
		return;
	}

}
