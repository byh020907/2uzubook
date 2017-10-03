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
		JSONArray contests=database.select_resume(userID, 3);
		JSONArray projects=database.select_resume(userID, 4);

		JSONObject basic_obj=new JSONObject();
		
		basic_obj.put("name", "김소연");
		basic_obj.put("major", "소프트웨어 개발과");
		basic_obj.put("student_id", 20106);
		basic_obj.put("gender", "여자");
		basic_obj.put("email", "qazxc5735@gmail.com");
		basic_obj.put("licenses", licenses);
		basic_obj.put("awards",awds);
		basic_obj.put("contests", contests);
		basic_obj.put("projects", projects);
		
		request.setAttribute("JSONObject", basic_obj);
		request.getRequestDispatcher("/myresume.jsp").forward(request, response);
	}

}
