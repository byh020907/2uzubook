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
@WebServlet(urlPatterns="/loginAction")//�럹�씠吏��뿉�꽌 �븸�뀡�쓣 蹂대궪 url 二쇱냼
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
			request.setAttribute("login_result", result);
			response.sendRedirect("/2uzubook/JSP/index.jsp");
		}
	}

}
