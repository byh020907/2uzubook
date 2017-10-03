package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		int part=Integer.parseInt(request.getParameter("part"));
		switch(part)
		{
		case 1:
			Cert cert=new Cert(userID,request.getParameter("name"),request.getParameter("ins"),request.getParameter("date"),1);
			database.insert_cert(cert);
			
		}
	}

}
