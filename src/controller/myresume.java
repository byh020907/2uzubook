package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Servlet implementation class myresume
 */
@WebServlet("/myresume")
public class myresume extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public myresume() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Util.setCharset(request, response, "utf-8");
		String str;
		
		JSONArray licenses=new JSONArray();
		JSONArray awds=new JSONArray();
		JSONArray contests=new JSONArray();
		JSONArray projects=new JSONArray();

		JSONObject basic_obj=new JSONObject();
		
		for(int i=0;i<5;i++)
		{
			JSONObject licen=new JSONObject();
			str = Integer.toString(i);
			licen.put("licenseName", "전기기능사"+str);
			licen.put("licenseDate", "2017.5.1");
			licenses.add(licen);
		}
		for(int i=0;i<3;i++)
		{
			JSONObject awd=new JSONObject();
			str = Integer.toString(i);
			awd.put("awardName", "stack"+str);
			awd.put("award", "대상");
			awd.put("awardDate", "2017.5.1");
			awds.add(awd);
		}
		for(int i=0;i<4;i++)
		{
			JSONObject contest=new JSONObject();
			str = Integer.toString(i);
			contest.put("contestName", "하늘나라"+str);
			contest.put("contestDate", "2017.5.22");
			contests.add(contest);
		}
		for(int i=0;i<3;i++)
		{
			JSONObject project=new JSONObject();
			str = Integer.toString(i);
			project.put("projectName", "stack"+str);
			project.put("projectStartDate", "2017.1.1");
			project.put("projectfinishDate", "2017.5.1");
			projects.add(project);
		}
		
		
		
		
		basic_obj.put("name", "김소연");
		basic_obj.put("major", "소프트웨어 개발과");
		basic_obj.put("student_id", 20106);
		basic_obj.put("gender", "여자");
		basic_obj.put("email", "qazxc5735@gmail.com");
		basic_obj.put("licenses", licenses);
		basic_obj.put("awards",awds);
		basic_obj.put("contests", contests);
		basic_obj.put("projects", projects);
		request.setAttribute("JSONObject", basic_obj);
		request.getRequestDispatcher("/myresume.jsp").forward(request, response);
		
	}

}
