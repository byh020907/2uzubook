package controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.JoinDAO;
import user.Account;

/**
 * Servlet implementation class JoinServlet
 */
@WebServlet("/JoinAction")
public class JoinServlet extends HttpServlet {
	
	private JoinDAO joinDAO;
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		joinDAO=JoinDAO.getInstance();

		Util.setCharset(request,response,"UTF-8");
		
//		int student_id = Integer.parseInt(request.getParameter("student_id"));
		int student_id=20110;
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String gender = "�궓�옄";
		String major = "�냼�봽�듃�썾�뼱 媛쒕컻怨�";
		String email = request.getParameter("email");
		
		int result=joinDAO.join(new Account(student_id,id,password,name,gender,major,email));
		
		if(result==0){
			response.sendRedirect("/index.jsp");
		}else{
			response.sendRedirect("/2uzubook/JSP/index.jsp");
		}
	}

}
