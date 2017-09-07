package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Database;
import user.Account;

/**
 * Servlet implementation class JoinServlet
 */
@WebServlet("/joinAction")
public class JoinServlet extends HttpServlet {
	
	private Database database;
	
	private static final long serialVersionUID = 1L;
	
	public JoinServlet(){
		database=Database.getInstance();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Util.setCharset(request,response,"UTF-8");
		
		int student_id = Integer.parseInt(request.getParameter("student_id"));
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String major = request.getParameter("major");
		String email = request.getParameter("email");
		
		PrintWriter out=response.getWriter();
		
		int result=database.join(new Account(student_id,id,password,name,gender,major,email));

		if(result>=0){
			response.sendRedirect("/2uzubook/JSP/login.jsp");
			return;
		}else{
			out.print("<script> history.back() </script>");
			return;
		}
	}

}
