package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;

import resume.ResumeDAO;

@WebServlet("/indexAction")
public class indexAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ResumeDAO database;
    public indexAction()
    {
    	database=ResumeDAO.getInstance();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Util.setCharset(request, response, "utf-8");
		
		JSONArray arr =new JSONArray();
		arr=database.random_student();
		
		PrintWriter out=response.getWriter();
		out.write(arr.toString());
		out.flush();
	}

}
