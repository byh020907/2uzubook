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

@WebServlet("/CheckAuthenticationCod")
public class CheckAuthenticationCode extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	private ResumeDAO database;
	
    public CheckAuthenticationCode() {
    	database=ResumeDAO.getInstance();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Util.setCharset(request,response,"UTF-8");
		
		String email=request.getParameter("code");
		
		//디비 함수로 code에 해당하는 email이 존재하는지 확인
		
		//위의 값을 토대로 리턴 값 조정
		JSONObject returnValue=new JSONObject();
		
		PrintWriter out=response.getWriter();
		
		out.print(returnValue);
		out.flush();
		
	}

}
