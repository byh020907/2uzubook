package user;

import java.sql.DriverManager;
import java.sql.SQLException;

import dao.Database;
import resume.ResumeDAO;

public class UserDAO extends Database{

	private static UserDAO instance;
	
	public static UserDAO getInstance(){
		if(instance==null)
			instance=new UserDAO();
		return instance;
	}

	public int login(String id, String pw) {
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

	public int join(String name, String gender, String email, String id, String password, int adm_year, int stu_id,
			String intro, int major) {
		String sql = "INSERT INTO user (name, gender, email, id, password, adm_year, stu_id, intro, major) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, gender);
			pstmt.setString(3, email);
			pstmt.setString(4, id);
			pstmt.setString(5, password);
			pstmt.setInt(6, adm_year);
			pstmt.setInt(7, stu_id);
			pstmt.setString(8, intro);
			pstmt.setInt(9, major);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
}
