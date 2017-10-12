package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import resume.ResumeDAO;

/**
 * Servlet implementation class SearchAction
 */

@WebServlet("/searchAction")
public class SearchAction extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	ResumeDAO resumeDAO;
	
	public SearchAction(){
		resumeDAO=ResumeDAO.getInstance();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Util.setCharset(request, response, "utf-8");

		String[] keywordStrings =request.getParameterValues("keyword");
		int[] keywords=new int[keywordStrings.length];
		JSONArray keyword=new JSONArray();
		
		for(int i=0;i<keywords.length;i++){
			keywords[i]=Integer.parseInt(keywordStrings[i]);
			keyword.add(keywords[i]);
		}
		
		
		
		JSONArray result = resumeDAO.search(keywords);

		request.setAttribute("JSONArray", result);
		request.setAttribute("keyword", keyword);
		request.getRequestDispatcher("/search_result.jsp").forward(request, response);
	}

}
