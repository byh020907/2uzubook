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
		String id = request.getParameter("ID");
		String password = request.getParameter("Password");
		String name = request.getParameter("Name");
		String gender = request.getParameter("Gender");
		String intro = request.getParameter("Introduce");
		String major = request.getParameter("Major");
		String email = request.getParameter("Email");
		
		PrintWriter out=response.getWriter();
		
		int result=database.register(new Account(student_id,id,password,intro,name,gender,major,email));

		if(result>=0){
			response.sendRedirect("/2uzubook/login.html");
			return;
		}else{
			out.print("<script> history.back() </script>");
			return;
		}
	}

}
