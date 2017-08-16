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

	private JoinDAO() {
		try {
			Class.forName(LoginDAO.JDBC_DRIVER);
			conn = DriverManager.getConnection(LoginDAO.url, LoginDAO.id, LoginDAO.password);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static JoinDAO getInstance(){
		if(joinDAO==null)
			joinDAO=new JoinDAO();
		return joinDAO;
	}
	
	public int join(Account account){
		String sql="insert into account values(?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement pstmt=conn.prepareStatement(sql);
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
