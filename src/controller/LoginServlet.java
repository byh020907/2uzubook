package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Database;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginAction")
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private Database database;
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		database=Database.getInstance();
		
		Util.setCharset(request, response, "utf-8");
		String id=request.getParameter("id");
		String password=request.getParameter("password");
		int result=database.login(id, password);
		
		
		if(result==1){
			HttpSession session = request.getSession(false);
			session.setAttribute("id",id);
			response.sendRedirect("/2uzubook/JSP/index.jsp");
			System.out.println(session.getAttribute("id"));
		}else{
			HttpSession session = request.getSession(true);
			response.sendRedirect("/2uzubook/JSP/login.jsp");
			System.out.println(session.getAttribute("id"));
		}
	}

}
