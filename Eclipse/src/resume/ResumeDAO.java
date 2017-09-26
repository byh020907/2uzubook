package resume;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ResumeDAO {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public ResumeDAO() {
		try {
			String dbURL = "jdbc:mysql://localhost:3306/2uzubook";
			String dbID = "root";
			String dbPW = "12341234";
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, dbID, dbPW);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public int search(String query) {
		String sql = "SELECT password FROM user WHERE id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				if (rs.getString(1).equals(pw)) {
					return 1;
				} else {
					return 0;
				}
			}
			return -1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -2;
	}
}
