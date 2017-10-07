package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Locale;

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
		String key = incoding(makeRawCode());
		int keyword = 1/*Integer.parseInt(request.getParameter("keyword"))*/;
		

		PrintWriter out = response.getWriter();
		if (name == null || email == null || key == null || keyword == 0) {
			out.print("<script>alert('정보를 모두 입력하세요.');history.back();</script>");
			return;
		}
		
		Company company=new Company(name, email, key, keyword);

		int result = companyDAO.join(company);

		if (result >= 0) {
			out.print("<script>alert('회원가입을 성공했습니다.');location.href='../login.html';</script>");
			return;
		} else {
			out.print("<script>alert('회원가입을 실패했습니다.');history.back();</script>");
			return;
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
		
		int todayNum=13;
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

}