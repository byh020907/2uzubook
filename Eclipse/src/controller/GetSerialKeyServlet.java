package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Database;

/**
 * Servlet implementation class GetSerialKeyServlet
 */
@WebServlet("/GetSerialKeyServlet")
public class GetSerialKeyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private Database database;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetSerialKeyServlet() {
    	database=Database.getInstance();
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Util.setCharset(request, response, "utf-8");
		
		String id=request.getParameter("id");
		String password=request.getParameter("password");
		int result=database.login(id, password);
		
		PrintWriter out=response.getWriter();
		
		if(result==1){
			HttpSession session = request.getSession();
			session.setAttribute("id",id);
			response.sendRedirect("/2uzubook/JSP/index.jsp");
			System.out.println(session.getAttribute("id"));
			return;
		}else{
			out.print("<script> history.back() </script>");
			return;
		}
	}
	
	private void generateSerialKey(){
		StringBuffer serialKey=new StringBuffer("");
		DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, Locale.KOREA);
		Calendar cal = Calendar.getInstance(Locale.KOREA);
		String s = df.format(cal.getTime());
		for(){
			
		}
		serialKey.append(b);
	}

}
