package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import resume.ResumeDAO;

/**
 * Servlet implementation class OneInputStore
 */
@WebServlet("/OneInputStore")
public class OneInputStore extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ResumeDAO database;
    public OneInputStore() {
    	database=ResumeDAO.getInstance();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Util.setCharset(request, response, "utf-8");
		BufferedReader br=request.getReader();
		Object obj=JSONValue.parse(br);
		if(obj==null)
		{
			System.out.println("jsonobject null");
		}
		else
		{
			JSONObject real_obj=(JSONObject)obj;
			try {
				database.All_insert(real_obj);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		PrintWriter out=response.getWriter();
		out.write(1);
		out.flush();
	}

}
