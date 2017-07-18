package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import user.Account;

public class JoinDAO {
	private static JoinDAO joinDAO = new JoinDAO();
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
	
	public int Join(Account account){
		return 0;
	}
}
