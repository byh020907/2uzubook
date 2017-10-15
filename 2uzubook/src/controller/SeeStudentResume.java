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

import etc.EtcDAO;
import resume.ResumeDAO;
import user.UserDAO;

/**
 * Servlet implementation class myresume
 */
@WebServlet("/SeeStudentResume")
public class SeeStudentResume extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ResumeDAO database;
	EtcDAO database2;
	UserDAO database3;
	
    public SeeStudentResume() {
    	database=ResumeDAO.getInstance();
    	database2=EtcDAO.getInstance();
    	database3=UserDAO.getInstance();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Util.setCharset(request, response, "utf-8");
		
		HttpSession session=request.getSession();
		
		String companySerial=(String) session.getAttribute("serialKey");
		if(session.getAttribute("serialKey")==null){
			response.sendRedirect("/2uzubook/login.jsp");
			return;
		}
		
		String userID=request.getParameter("id");
		
		JSONArray licenses=database.select_resume(userID, 1);
		JSONArray awds=database.select_resume(userID, 2);
		JSONArray clubs=database.select_resume(userID, 3);
		JSONArray projects=database.select_resume(userID, 4);
		JSONArray tests=database.select_resume(userID, 5);
		JSONArray conferences=database.select_resume(userID, 6);
		JSONArray volunteers=database2.select_resume(userID, 1);
		JSONArray readings=database2.select_resume(userID, 2);
		JSONArray interests=database2.select_resume(userID, 3);
		
		//유저 정보 받아오기
		JSONArray ja=database3.executeAndGet("SELECT * FROM USER WHERE id=?", userID);

		JSONObject userData=(JSONObject)ja.get(0);
		
		int major=(Integer)userData.get("major");
		
		userData.put("majorName", database3.majorToString(major));
		
		userData.put("licenses", licenses);
		userData.put("awards",awds);
		userData.put("clubs",clubs);
		userData.put("projects",projects);
		userData.put("tests",tests);
		userData.put("conferences",conferences);
		userData.put("volunteers",volunteers);
		userData.put("readings",readings);
		userData.put("interests",interests);
		request.setAttribute("JSONObject", userData);
		request.getRequestDispatcher("/myresume.jsp").forward(request, response);
	}

}
