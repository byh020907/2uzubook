package Example;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalServlet extends HttpServlet {
	/**
	 * 
	 */
	/*private static final long serialVersionUID = 1L;
	public CalServlet(){}
	
	public void init(){}
	*/
	public void doPost(HttpServletRequest requset,HttpServletResponse response) throws IOException ,ServletException{
		String num1=requset.getParameter("num1");
		String num2=requset.getParameter("num2");
		
		try{
			int su1=Integer.parseInt(num1);
			int su2=Integer.parseInt(num2);
			
			int result=su1+su2;
			
			System.out.println(result);
			
			
		}catch (NumberFormatException e) {
			response.sendError(599,"숫자가 아닙니다!!");
			// TODO: handle exception
		}
		//response.sendRedirect("successPage.jsp");
	}
	
	/*public void Serive(HttpServletRequest request,HttpServletResponse response){
		
	}
	public void destory(){}*/
}
