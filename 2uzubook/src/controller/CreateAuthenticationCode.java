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

@WebServlet("/CreateAuthenticationCode")
public class CreateAuthenticationCode extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	private UserDAO database;
	
    public CreateAuthenticationCode() {
    	database=UserDAO.getInstance();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Util.setCharset(request,response,"UTF-8");
		
		String email=request.getParameter("email");
		
		//디비 함수로 email과 코드 저장
		int result=database.insert_code(new AuthenticationCode(email,generateCode()));
		
		//성공여부 보냄
		JSONObject returnValue=new JSONObject();
		returnValue.put("status", result);
		
		PrintWriter out=response.getWriter();
		
		out.print(returnValue);
		out.flush();
	}
	
	private static int generateCode(){
		int code=0;
		for(int i=0;i<6;i++){
			code+=(int)(Math.pow(10, i)*(int)(Math.random()*10));
		}
		return code;
	}

}
