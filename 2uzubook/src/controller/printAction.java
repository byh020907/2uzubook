package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import etc.EtcDAO;
import resume.ResumeDAO;
import user.UserDAO;


@WebServlet("/printAction")
public class printAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ResumeDAO database;
    EtcDAO database2;
    UserDAO database3;
	public printAction() {
        database=ResumeDAO.getInstance();
        database2=EtcDAO.getInstance();
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Util.setCharset(request, response, "utf-8");
		String jsonstring=request.getParameter("jsonArray");
		JSONParser parser=new JSONParser();
		try {
			JSONArray ja=(JSONArray) parser.parse(jsonstring);
			JSONArray go_ja=new JSONArray();
			System.out.println(ja);
			for(int i=0;i<ja.size();i++)
			{
				JSONObject obj=(JSONObject)ja.get(i); 
				JSONArray licenses=database.select_resume((String)obj.get("id"), 1);
				JSONArray awds=database.select_resume((String)obj.get("id"), 2);
				JSONArray clubs=database.select_resume((String)obj.get("id"), 3);
				JSONArray projects=database.select_resume((String)obj.get("id"), 4);
				JSONArray tests=database.select_resume((String)obj.get("id"), 5);
				JSONArray conferences=database.select_resume((String)obj.get("id"), 6);
				JSONArray volunteers=database2.select_resume((String)obj.get("id"), 1);
				JSONArray readings=database2.select_resume((String)obj.get("id"), 2);
				JSONArray interests=database2.select_resume((String)obj.get("id"), 3);
				System.out.println((String)obj.get("id"));
				//유저 정보 받아오기
				JSONArray json=database3.executeAndGet("SELECT * FROM USER WHERE id=?", (String)obj.get("id"));

				JSONObject userData=(JSONObject)json.get(0);
				
				int major=(Integer)userData.get("major");
				
				userData.put("majorName", database3.majorToString(major));
				
				userData.put("licenses", licenses);
				userData.put("awards",awds);
				userData.put("clubs",clubs);
				userData.put("projects",projects);
				userData.put("tests",tests);
				userData.put("conferences",conferences);
				userData.put("volunteers",volunteers);
				userData.put("readings",readings);
				userData.put("interests",interests);
				go_ja.add(userData);
			}
			request.setAttribute("JSONArray",go_ja);
			request.getRequestDispatcher("/myresume.jsp").forward(request, response);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

}
