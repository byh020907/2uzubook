package controller;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

@WebServlet("/search_test")
public class search_test extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public search_test() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String str = request.getParameter("str");
		JSONParser parser =new JSONParser();
		Object obj = null;
		try {
			obj = parser.parse(new FileReader("\\2uzubook\\WebContent\\search.json"));
		} catch (ParseException e) {
			System.out.println("errorsss\n");
			e.printStackTrace();
		}
		JSONArray jsonArray=(JSONArray)obj;
		JSONArray result_array=new JSONArray();
		for(int i=0;i<jsonArray.size();i++)
		{
			JSONObject jobj=(JSONObject) jsonArray.get(i);
			String in=(String)jobj.get("text");
			if(in.indexOf(str)==-1)
			{}
			 else {
				result_array.add(jobj);
			}
		}
		PrintWriter out=response.getWriter();
		out.write(result_array.toString());
		out.flush();
	}

}
