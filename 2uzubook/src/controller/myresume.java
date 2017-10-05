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

import resume.ResumeDAO;
import user.UserDAO;

/**
 * Servlet implementation class myresume
 */
@WebServlet("/myresume")
public class myresume extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ResumeDAO database;
    public myresume() {
    	database=ResumeDAO.getInstance();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Util.setCharset(request, response, "utf-8");
		
		HttpSession session=request.getSession();
		
		String userID=(String) session.getAttribute("id");
		if(session.getAttribute("id")==null){
			response.sendRedirect("/2uzubook/login.html");
			return;
		}
		
		JSONArray licenses=database.select_resume(userID, 1);
		JSONArray awds=database.select_resume(userID, 2);
		JSONArray clubs=database.select_resume(userID, 3);
		JSONArray projects=database.select_resume(userID, 4);
		
		JSONObject basic_obj=new JSONObject();
		
		//유저 정보 받아오기
		JSONArray ja=UserDAO.getInstance().executeAndGet("SELECT * FROM USER WHERE id=?", userID);
		JSONObject userData=(JSONObject) ja.get(0);
		
		basic_obj.put("name", userData.get("name"));
		basic_obj.put("major", userData.get("major"));
		basic_obj.put("student_id", userData.get("stu_id"));
		basic_obj.put("gender", userData.get("gender"));
		basic_obj.put("email", userData.get("email"));
		basic_obj.put("licenses", licenses);
		basic_obj.put("awards",awds);
		basic_obj.put("clubs", clubs);
		basic_obj.put("projects", projects);
		
		request.setAttribute("JSONObject", basic_obj);
		request.getRequestDispatcher("/myresume.jsp").forward(request, response);
	}

}
