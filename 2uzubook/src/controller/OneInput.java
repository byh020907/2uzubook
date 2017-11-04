package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;

import resume.ResumeDAO;


@WebServlet("/OneInput")
public class OneInput extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ResumeDAO database;
    public OneInput() {
    	database=ResumeDAO.getInstance();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JSONArray jarr=database.select_keyword();
		
		request.setAttribute("KeywordArray", jarr);
		request.getRequestDispatcher("/oneinput.jsp").forward(request, response);
	}

}
