package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
	}

}
