package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import resume.ResumeDAO;

@WebServlet("/ResumeShow")
public class ResumeShow extends HttpServlet {
	private static final long serialVersionUID = 1L;
   ResumeDAO database;
    public ResumeShow() {
    	database=ResumeDAO.getInstance();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String userID=(String) session.getAttribute("id");
		
		Object obj=JSONValue.parse(request.getParameter("str"));
		JSONObject jobj=(JSONObject)obj;
		switch((Integer)jobj.get("data"))
		{
		case 1:
			JSONArray jsonArray=database.select_resume(userID, 1);
			break;
		}
	}

}
