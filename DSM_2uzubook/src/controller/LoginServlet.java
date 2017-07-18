package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LoginDAO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("http://localhost:9080/DSM_2uzubook/JSP/loginAction")//페이지에서 액션을 보낼 url 주소
public class LoginServlet extends HttpServlet {
	
	private LoginDAO loginDAO;
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		loginDAO=LoginDAO.getInstance();

		request.setCharacterEncoding("euc-kr");
		String id=request.getParameter("id");
		String password=request.getParameter("password");

		int result=loginDAO.login(id, password);
		
		if(result==1){
			response.sendRedirect("/main.jsp");
		}else{
			response.sendRedirect("/back.jsp");

		}
	}

}
