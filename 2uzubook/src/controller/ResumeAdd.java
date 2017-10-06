package controller;

import java.io.BufferedReader;
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
import org.json.simple.JSONValue;

import resume.Cert;
import resume.ResumeDAO;

@WebServlet("/ResumeAdd")
public class ResumeAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ResumeDAO database;
	public ResumeAdd() {
		database=new ResumeDAO();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String userID=(String) session.getAttribute("id");
		BufferedReader bf = request.getReader();

		Object obj=JSONValue.parse(bf);
		JSONObject jobj=(JSONObject)obj;
		System.out.println("hello");
		System.out.println(jobj);
		JSONArray jsonArray = null;
		int part = Integer.parseInt((String)jobj.get("part"));
		
		switch(part)
		{
		case 1:
			Cert cert=new Cert(userID,(String)jobj.get("name"),(String)jobj.get("ins"),(String)jobj.get("date"),Integer.parseInt((String)jobj.get("keyword")));
			database.insert_cert(cert);
			jsonArray=database.select_resume(userID, part);

			System.out.println("hello2");
			break;
		}
		PrintWriter out=response.getWriter();
		out.write(jsonArray.toString());
		out.flush();
	}

}
