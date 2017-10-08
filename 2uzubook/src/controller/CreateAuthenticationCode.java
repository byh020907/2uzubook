package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import dao.Database;
import resume.ResumeDAO;

@WebServlet("/CreateAuthenticationCode")
public class CreateAuthenticationCode extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	private ResumeDAO database;
	
    public CreateAuthenticationCode() {
    	database=ResumeDAO.getInstance();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Util.setCharset(request,response,"UTF-8");
		
		String email=request.getParameter("email");
		
		//디비 함수로 email과 코드 저장
		
	}

}
