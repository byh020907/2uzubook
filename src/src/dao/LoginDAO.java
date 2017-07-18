package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import sun.security.jca.GetInstance;

public class LoginDAO {
	private static LoginDAO loginDAO=new LoginDAO();
	
	public static final String JDBC_DRIVER="com.mysql.jdbc.Driver";
	public static final String url="jdbc:mysql://localhost:3306/2uzubook";
	public static final String id="root";
	public static final String password="root0209";
	
	private static Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private LoginDAO() {
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(url, id, password);
		} catch (Exception e) {
			System.out.println("로그인실패");
			e.printStackTrace();
		}
	}
	
	public static LoginDAO getInstance(){
		return loginDAO;
	}
	
	public int login(String id,String password){
		String sql="select password from account where id= ?";
		
		try{
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			if(rs.next()){
				if(rs.getString(1).equals(password)){
					return 1; //아이디 , 패스워드 일치 
				}else{
					return 0; //비밀번호 불일치
				}
			}
			return -1; //데이터 베이스 오류
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
}
