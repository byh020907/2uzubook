package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import etc.EtcDAO;
import resume.ResumeDAO;


@WebServlet("/ResumeUpdate")
public class ResumeUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ResumeDAO database1;
    EtcDAO database2;
  
    public ResumeUpdate() {
        database1=ResumeDAO.getInstance();
        database2=EtcDAO.getInstance();
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String userID=(String) session.getAttribute("id");
		Util.setCharset(request, response, "utf-8");
		int position=Integer.parseInt(request.getParameter("position"));
		String name=request.getParameter("name");
		System.out.println("good");
		JSONObject data=null;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		switch(position)
		{
		case 1:
		case 2:{
			data=database1.select_resume_single(userID, name, position);
			data.put("date", dateFormat.format(data.get("date")));
		}break;
		case 3:
		case 4:{
			data=database1.select_resume_single(userID, name, position);
			data.put("startdate", dateFormat.format(data.get("startdate")));
			data.put("enddate", dateFormat.format(data.get("enddate")));
		}break;
		case 5:
		case 6:{
			data=database1.select_resume_single(userID, name, position);
			data.put("date", dateFormat.format(data.get("date")));
		}break;
		case 7:{
			data=database2.select_resume_single(userID, name,1);//봉사
			data.put("startdate", dateFormat.format(data.get("startTime")));
			data.put("enddate", dateFormat.format(data.get("endTime")));
		}break;
		case 8:{
			data=database2.select_resume_single(userID, name,2);//독서
			data.put("date", dateFormat.format(data.get("date")));
		}break;
		case 9:{
			data=database2.select_resume_single(userID, name,3);//관심분야
		}break;
		}
		PrintWriter out=response.getWriter();
		System.out.println(data.toString());
		out.write(data.toString());
		out.flush();
	}

}
