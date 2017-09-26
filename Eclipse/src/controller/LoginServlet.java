package controller;

import java.io.IOException;
import java.io.PrintWriter;

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
	
	public LoginServlet(){
		database=Database.getInstance();
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Util.setCharset(request, response, "utf-8");
		
		String id=request.getParameter("id");
		String password=request.getParameter("password");
		int result=database.login(id, password);
		
		PrintWriter out=response.getWriter();
		
		if(result==1){
			HttpSession session = request.getSession();
			session.setAttribute("id",id);
			response.sendRedirect("/2uzubook/index.jsp");
			System.out.println(session.getAttribute("id"));
			return;
		}else{
			out.print("<script> history.back() </script>");
			System.out.println("로그인 실패");
			return;
		}
	}

}
