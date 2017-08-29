package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDAO {
	private static LoginDAO loginDAO;
	
	public static final String JDBC_DRIVER="com.mysql.jdbc.Driver";
	public static final String url="jdbc:mysql://10.156.145.110:3306/2uzubook";
	public static final String id="root";
	public static final String password="root0209";//1022//root0209
	
	private static Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private LoginDAO() {
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(url, id, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static LoginDAO getInstance(){
		if(loginDAO==null)
			loginDAO=new LoginDAO();
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
					return 1; //성공
				}else{
					return 0; //로그인 실패(비밀 번호가 다름)
				}
			}
			return -1; //로그인 실패(해당 id 가없음)
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return 0;
	}
	
}
