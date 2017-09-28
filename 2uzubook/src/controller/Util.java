package controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Util {
	public static void setCharset(HttpServletRequest request, HttpServletResponse response, String charset){
		try {
			request.setCharacterEncoding(charset);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		//printwriter 객체를 얻기전에 먼저 해주지않으면 한글이 깨진다
		response.setCharacterEncoding(charset);
		//순서가 참중요합니다. 그죠?
		response.setContentType("text/html;charset="+charset);
	}
	
	public static String unicodeConvert(String str) {
	    StringBuilder sb = new StringBuilder();
	    char ch;
	    int len = str.length();
	    for (int i = 0; i < len; i++) {
	        ch = str.charAt(i);
	        if (ch == '\\' && str.charAt(i+1) == 'u') {
	            sb.append((char) Integer.parseInt(str.substring(i+2, i+6), 16));
	            i+=5;
	            continue;
	        }
	        sb.append(ch);
	    }
	    return sb.toString();
	}
}
