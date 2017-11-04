package resume;

import java.sql.PreparedStatement;
import java.util.ArrayList;

import dao.Database;


public class Parser extends Database {
	
	
	public void inputCareer_license(ArrayList<Award> arrayList, int student_id) {
		String sql = "insert into license values(?,?,?,?)";

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);

			for (int i = 0; i < arrayList.size(); i++) {
			}	
			 pstmt.executeBatch();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	public void inputCareer_award(ArrayList<Award> arrayList, int student_id) {
		String sql = "insert into award values(?,?,?,?)";

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);

			for (int i = 0; i < arrayList.size(); i++) {
			}	
			 pstmt.executeBatch();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	public void inputCareer_club(ArrayList<Award> arrayList, int student_id) {
		String sql = "insert into career_award values(?,?,?,?)";

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);

			for (int i = 0; i < arrayList.size(); i++) {
			}	
			 pstmt.executeBatch();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	public void inputCareer_reading(ArrayList<Award> arrayList, int student_id) {
		String sql = "insert into career_award values(?,?,?,?)";

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);

			for (int i = 0; i < arrayList.size(); i++) {
			}	
			 pstmt.executeBatch();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	public void inputCareer_conference(ArrayList<Award> arrayList, int student_id) {
		String sql = "insert into career_award values(?,?,?,?)";

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);

			for (int i = 0; i < arrayList.size(); i++) {
			}	
			 pstmt.executeBatch();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	public void inputCareer_volunteer(ArrayList<Award> arrayList, int student_id) {
		String sql = "insert into career_award values(?,?,?,?)";

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);

			for (int i = 0; i < arrayList.size(); i++) {
			}	
			 pstmt.executeBatch();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	public void inputCareer_test(ArrayList<Award> arrayList, int student_id) {
		String sql = "insert into career_award values(?,?,?,?)";

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);

			for (int i = 0; i < arrayList.size(); i++) {
			}	
			 pstmt.executeBatch();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	public void inputCareer_project(ArrayList<Award> arrayList, int student_id) {
		String sql = "insert into career_award values(?,?,?,?)";

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);

			for (int i = 0; i < arrayList.size(); i++) {
			}	
			 pstmt.executeBatch();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
