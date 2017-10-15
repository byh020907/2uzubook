package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import resume.ResumeDAO;

@WebServlet("/search_test") //keyword 중간에 목록 받아오기
public class search_test extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ResumeDAO database;
    public search_test() {
    	database=ResumeDAO.getInstance();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Util.setCharset(request, response, "UTF-8");
		JSONArray jsonArray=database.select_keyword(); //실제 db에서 긁어오는 것.
		PrintWriter out=response.getWriter();
		out.write(jsonArray.toString());
		out.flush();
	}

}
