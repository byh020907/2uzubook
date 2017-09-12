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
 * Servlet implementation class ResumeInputServlet
 */
@WebServlet("/resumeInputAction")
public class ResumeInputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Database database;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResumeInputServlet() {
    	database=Database.getInstance();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Util.setCharset(request, response, "utf-8");
		
		int type=Integer.parseInt(request.getParameter("type"));
		
		switch(type){
			case 1:{
				String own=request.getParameter("one");
				String two=request.getParameter("two");
				String three=request.getParameter("three");
				System.out.println(own+two+three);
			}break;
			
			case 2:{
						
			}break;
					
			case 3:{
				
			}break;
			
			case 4:{
				
			}break;
			
			case 5:{
				
			}break;
			
			case 6:{
				
			}break;
		}
		
		PrintWriter out=response.getWriter();
		
		int result=1;
		
		out.print("<script> history.back() </script>");
		System.out.println(type);
		return;
	}

}
