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

import org.json.simple.JSONObject;

import user.AuthenticationCode;
import user.UserDAO;

@WebServlet("/CreateAuthenticationCode")
public class CreateAuthenticationCode extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	private UserDAO database;
	
    public CreateAuthenticationCode() {
    	database=UserDAO.getInstance();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Util.setCharset(request,response,"UTF-8");
		
		String email=request.getParameter("email");
		int code=generateCode();
		
		PrintWriter out=response.getWriter();
		
		//성공여부
		JSONObject returnValue=new JSONObject();
		
		//디비 함수로 email과 코드 저장
		int result=database.insert_code(new AuthenticationCode(email,code));
		System.out.println(result);
		
		//저장 성공시
		if(result>=0){
			int result2=sendMail(email,"[2uzubook]인증번호 발급 완료","입력창에다 해당 번호를 입력하세요.<br><br>인증번호 : "+code);
			//잘못된 이메일 번호일시
			returnValue.put("status", result2);
		}else{
			returnValue.put("status", result);
		}
		
		out.print(returnValue);
		out.flush();
	}
	
	private static int generateCode(){
		int code=0;
		for(int i=0;i<6;i++){
			code+=(int)(Math.pow(10, i)*(int)(Math.random()*10));
		}
		return code;
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
