package controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ImageServlet
 */
@WebServlet("/ImageServlet")
public class ImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		아직 디폴트 이미지와 성별 여부 적용x
		Util.setCharset(request, response, "UTF-8");
		String imageUrl=null;
		String failImageUrl=null;
		String extension=".png";
		if(request.getParameter("imageUrl")!=null)
			imageUrl=request.getParameter("imageUrl");
		else if(request.getParameter("studentID")!=null)
			imageUrl="student_ID_Photo\\"+request.getParameter("studentID")+extension;
		
		String gender=request.getParameter("gender");
		if(gender.equals("남"))
			failImageUrl="student_ID_Photo\\student_boy"+extension;
		else if(gender.equals("여"))
			failImageUrl="student_ID_Photo\\student_girl"+extension;
		
		//이미지 출력용
		response.setContentType("image/gif");

		//출력을위한 OutputStream 객체
		ServletOutputStream out = response.getOutputStream();

		try {
			File file=new File(getServletContext().getRealPath("")+"\\images\\"+imageUrl);
			if(file.exists()){				
				printImage(out,getServletContext().getRealPath("")+"\\images\\"+imageUrl);
			}else{
				printImage(out,getServletContext().getRealPath("")+"\\images\\"+failImageUrl);
			}
			
			//String imagePath = "C://sou/006_jspServlet/001_servlet/WebContent/images/aa.jpg";
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return;

	}
	
	private void printImage(ServletOutputStream out,String imagePath) throws IOException{
		byte[] by = new byte[1024]; //한번에 읽어올 파일크기 1024 바이트

		BufferedInputStream in = new BufferedInputStream(new FileInputStream(imagePath));

		//버퍼(in)에 있는 데이터를 1024바이트(by) 만큼 읽어오고 데이터가 없을경우 반복문 종료
		int i=0;
		while(in.read(by) != -1) {
			out.write(by); //1024바이트씩 출력
		}

		in.close();
		out.close();
	}
}
