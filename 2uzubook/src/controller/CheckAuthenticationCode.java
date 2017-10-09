package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import user.AuthenticationCode;
import user.UserDAO;

@WebServlet("/CheckAuthenticationCode")
public class CheckAuthenticationCode extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	private UserDAO database;
	
    public CheckAuthenticationCode() {
    	database=UserDAO.getInstance();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Util.setCharset(request,response,"UTF-8");
		
		String email=request.getParameter("email");
		int code=Integer.parseInt(request.getParameter("code"));
		
		//디비 함수로 code에 해당하는 email이 존재하는지 확인
		int result=database.check_code(new AuthenticationCode(email,code));
		
		System.out.println(result);
		//위의 값을 토대로 성공여부 보냄
		
		JSONObject returnValue=new JSONObject();
		returnValue.put("status", result);
		PrintWriter out=response.getWriter();
		
		out.print(returnValue);
		out.flush();
		
	}

}
