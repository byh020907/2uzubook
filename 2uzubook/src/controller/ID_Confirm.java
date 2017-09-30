package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import dao.Database;
import resume.ResumeDAO;

@WebServlet("/ID_Confirm")
public class ID_Confirm extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	private ResumeDAO database;
	
    public ID_Confirm() {
    	database=Resume.getInstance();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Util.setCharset(request,response,"UTF-8");
		
		String input_id=request.getParameter("param");
		System.out.println(input_id+"dd");
		
		int checkNum=database.check_id(input_id);
	
		JSONObject obj =new JSONObject();
		
		if(checkNum == 1) {
			// 중복
			obj.put("status","이미 존재하는 아이디 입니다.");
		}else if (checkNum == 0) {
			// 중복아님
			obj.put("status","사용가능한 아이디 입니다.");
		}else {
			// db오류
			obj.put("status","[DATABASE 에러] 값을 불러오는데 실패하였습니다.");
		}
		PrintWriter out=response.getWriter();
		
		out.print(obj);
		out.flush();
	}

}
