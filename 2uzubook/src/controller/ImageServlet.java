package controller;

import java.io.BufferedInputStream;
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
		
		Util.setCharset(request, response, "UTF-8");
		
		String imageUrl=request.getParameter("imageUrl");
		
		//이미지 출력용
		response.setContentType("image/gif");

		byte[] by = new byte[1024]; //한번에 읽어올 파일크기 1024 바이트

		//출력을위한 OutputStream 객체
		ServletOutputStream out = response.getOutputStream();

		try {

			//이미지 주소 저장

			String imagePath = getServletContext().getRealPath("")+"\\images\\"+imageUrl;
			//String imagePath = "C://sou/006_jspServlet/001_servlet/WebContent/images/aa.jpg";

			BufferedInputStream in = new BufferedInputStream(new FileInputStream(imagePath));

			//버퍼(in)에 있는 데이터를 1024바이트(by) 만큼 읽어오고 데이터가 없을경우 반복문 종료
			while(in.read(by) != 0) {
				out.write(by); //1024바이트씩 출력
			}

			in.close();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
