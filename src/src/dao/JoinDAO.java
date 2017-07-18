package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import user.Account;

public class JoinDAO {
	private static JoinDAO joinDAO;
	private static Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public static final String JDBC_DRIVER="com.mysql.jdbc.Driver";
	public static final String url="jdbc:mysql://localhost:3306/2uzubook";
	public static final String id="root";
	public static final String password="root0209";

	private JoinDAO() {
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(url, id, password);
		} catch (Exception e) {
			System.out.println("로그인실패");
			e.printStackTrace();
		}
	}
	
	public static JoinDAO getInstance(){
		if(joinDAO==null)
			joinDAO=new JoinDAO();
		return joinDAO;
	}
	
	public int Join(Account account){
		
		String sql="insert into account values(?,?,?,?,?,?,?)";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, account.getStudent_id());
			pstmt.setString(2, account.getId());
			pstmt.setString(3, account.getPassword());
			pstmt.setString(4, account.getName());
			pstmt.setString(5, account.getGender());
			pstmt.setString(6, account.getMajor());
			pstmt.setString(7, account.getEmail());
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;//데이터베이스 오류
	}
}
