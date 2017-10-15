package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Database;
import user.User;
import user.UserDAO;

/**
 * Servlet implementation class JoinAction
 */

@WebServlet("/joinAction/student")
public class JoinAction_Student extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserDAO userDAO = UserDAO.getInstance();
		Util.setCharset(request, response, "UTF-8");

		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String adm_year = request.getParameter("adm_year");
		String stu_id = request.getParameter("stu_id");
		String intro = request.getParameter("intro");
		String major = request.getParameter("major");

		PrintWriter out = response.getWriter();
		if (name == null || gender == null || email == null || id == null || password == null || adm_year == null
				|| stu_id == null || intro == null || major == null) {
			out.print("<script>alert('정보를 모두 입력하세요.');history.back();</script>");
			return;
		}

		int result = userDAO.join(name, gender, email, id, password, Integer.parseInt(adm_year),
				Integer.parseInt(stu_id), intro, Integer.parseInt(major));

		if (result >= 0) {
			out.print("<script>alert('회원가입을 성공했습니다.');location.href='../login.jsp';</script>");
			return;
		} else {
			out.print("<script>alert('회원가입을 실패했습니다.');history.back();</script>");
			return;
		}
	}
	
	private static int sendMail(String mail_to,String title,String contents){
		try {
			String mail_from =	"dragonlake.bae@gmail.com";//원래 보내는 사람 정할수 있는거 같은데 gmail설정으로 하니 설정한 계정 이메일 밖에 안된다.

//			mail_from = new String(mail_from.getBytes("UTF-8"), "UTF-8");//굳이 할필요 없다 (아래에서 처리해줌)
			mail_to = new String(mail_to.getBytes("UTF-8"), "UTF-8");

			Properties props = new Properties();
			props.put("mail.transport.protocol", "smtp");
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.port", "465");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.socketFactory.port", "465");
			props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			props.put("mail.smtp.socketFactory.fallback", "false");
			props.put("mail.smtp.auth", "true");

			Authenticator auth = new SMTPAuthenticator();

			Session sess = Session.getDefaultInstance(props, auth);

			MimeMessage msg = new MimeMessage(sess);

			msg.setFrom(new InternetAddress(mail_from,"2uzubook관리자","UTF-8"));
			msg.setRecipient(Message.RecipientType.TO, new InternetAddress(mail_to));
			msg.setSubject(title, "UTF-8");
			msg.setContent(contents, "text/html; charset=UTF-8");
			msg.setHeader("Content-type", "text/html; charset=UTF-8");

			Transport.send(msg);
			return 0;
		}catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

}
