package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import company.Company;
import company.CompanyDAO;

/**
 * Servlet implementation class JoinAction
 */

@WebServlet("/joinAction/company")
public class JoinAction_Company extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CompanyDAO companyDAO = CompanyDAO.getInstance();
		Util.setCharset(request, response, "UTF-8");

		String name = request.getParameter("CompanyName");
		String email = request.getParameter("CompanyEmail");
		String key = makeCode();//16자리 코드생성(12자리 랜덤+4자리 체크섬)
		int keyword = 1/*Integer.parseInt(request.getParameter("keyword"))*/;
		

		PrintWriter out = response.getWriter();
		if (name == null || email == null || key == null || keyword == 0) {
			out.print("<script>alert('정보를 모두 입력하세요.');history.back();</script>");
			return;
		}
		
		Company company=new Company(name, email, key, keyword);
		
		int result2=sendMail(email,"[2uzubook]시리얼키 발급 완료","앞으로는 아래 시리얼키를 이용하여 로그인 하시면 됩니다.<br><br>시리얼키번호 : "+key);
		if(result2!=0){				
			out.print("<script>alert('회원가입을 실패했습니다.');history.back();</script>");
			return;
		}

		int result = companyDAO.join(company);

		if (result >= 0) {
			out.print("<script>alert('회원가입을 성공했습니다.');location.href='../login.html';</script>");
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
	
	private static String makeRawCode(){
		DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, Locale.KOREA);
		Calendar cal = Calendar.getInstance(Locale.KOREA);
		int year = cal.get ( Calendar.YEAR );
		int month = cal.get ( Calendar.MONTH );
		int day = cal.get ( Calendar.DAY_OF_MONTH );
		
		String mon="";
		String d="";
		if(month+1<10)
			mon+="0";
		mon+=String.valueOf(month+1);
		
		if(day<10)
			d+="0";
		
		d+=String.valueOf(day);
		
		int todayNum=(int)(Math.random()*1000);
		String todayString=addZero(todayNum,4);
		
		if(todayString.length()>4)
			return null;//오류 최대 4자리수를 넘을수 없음
		
		return year+mon+d+todayString;
	}
	
	private static int getCheckSum(String s){
		int checkSum=0;
		String checkString=s;
		//체크섬 계산
		for(int i=0;i<checkString.length()-4;i++){
			if(checkString.charAt(i)>=65){				
				checkSum+=(checkString.charAt(i)-65)+10;
			}else{
				checkSum+=Integer.parseInt(String.valueOf(checkString.charAt(i)));
			}
		}
		
		return checkSum;
	}
	
	private static boolean checkAvailableKey(String code){
		return Integer.parseInt(code.substring(12))==getCheckSum(code);
	}
	
	private static String addZero(int num,int totalLength){
		String checkSumString=String.valueOf(num);
		
		while(checkSumString.length()<totalLength){
			checkSumString="0"+checkSumString;
		}
		
		return checkSumString;
	}
	
	private static String incoding(String s){
		//숫자 배열 생성//인풋으로 들어오는 문자열 s의 길이는 12로 고정
		int[] numArr=new int[s.length()];
		
		//숫자 변환
		for(int i=0;i<s.length();i++){
			int num=Integer.parseInt(String.valueOf(s.charAt(i)));
			num+=(i*2);
			numArr[i]=(int) Math.pow(num, 5)%36;
		}
		
		//체크섬 4자리
		int sum=0;
		for(int i=0;i<numArr.length;i++){
			sum+=numArr[i];
		}
		
		StringBuffer st=new StringBuffer();
		for(int i=0;i<numArr.length;i++){
			String data=String.valueOf(numArr[i]);
			if(numArr[i]>=10)
				data=String.valueOf((char)(65+numArr[i]-10));
			st.append(data);
		}
		
		return st.toString()+addZero(sum,4);
	}
	
	private static String makeCode(){
		//숫자 배열 생성//인풋으로 들어오는 문자열 s의 길이는 12로 고정
		int[] numArr=new int[12];
		
		//숫자 변환
		for(int i=0;i<numArr.length;i++){
			numArr[i]=(int)(Math.random()*36);
		}
		
		//체크섬 4자리
		int sum=0;
		for(int i=0;i<numArr.length;i++){
			sum+=numArr[i];
		}
		
		StringBuffer st=new StringBuffer();
		for(int i=0;i<numArr.length;i++){
			String data=String.valueOf(numArr[i]);
			if(numArr[i]>=10)
				data=String.valueOf((char)(65+numArr[i]-10));
			st.append(data);
		}
		
		return st.toString()+addZero(sum,4);
	}

}