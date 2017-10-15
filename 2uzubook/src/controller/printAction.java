package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


@WebServlet("/printAction")
public class printAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public printAction() {
        super();
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Util.setCharset(request, response, "utf-8");
		String jsonstring=request.getParameter("jsonArray");
		JSONParser parser=new JSONParser();
		try {
			JSONArray ja=(JSONArray) parser.parse(jsonstring);
			System.out.println(ja);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

}
