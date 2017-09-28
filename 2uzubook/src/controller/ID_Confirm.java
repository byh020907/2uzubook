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

@WebServlet("/ID_Confirm")
public class ID_Confirm extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public ID_Confirm() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Util.setCharset(request,response,"UTF-8");
		//String id="hello";//db에서 긁어온 값
		String input_id=(String)request.getParameter("param");
		System.out.println(input_id+"dd");
		
		Database dao=Database.getInstance();

		
		
		int checkNum=dao.check_id(input_id);
	
		if(checkNum == 1) {
			// 중복
		}else if (checkNum == 0) {
			// 중복아님
		}else {
			// db오류
		}
		JSONObject obj =new JSONObject();
		obj.put("flag",flag);
		PrintWriter out=response.getWriter();
		
		out.print(obj);
		out.flush();
	}

}
