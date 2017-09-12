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
 * Servlet implementation class OneSee
 */
@WebServlet("/OneSeeAction")
public class OneSee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public OneSee() {
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Util.setCharset(request, response, "utf-8");
		
		JSONObject licen=new JSONObject();
		licen.put("licence1","li1");
		licen.put("licence2","li2");
		licen.put("licence3","li3");
		licen.put("licence4","li4");
		
		JSONObject data1 = new JSONObject();
		data1.put("name", "김소연");
		data1.put("major", "sw개발과");
		data1.put("licences", licen);
		request.setAttribute("JSONObject", data1);
		request.getRequestDispatcher("/JSP/OneSee.jsp").forward(request, response);
	}

}
