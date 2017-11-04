package resume;

import java.sql.PreparedStatement;
import java.util.ArrayList;

import dao.Database;
import etc.Reading;
import etc.Volunteer;


public class Parser extends Database implements SQL_Command {
	

	public void inputCareer_license(ArrayList<Cert> arrayList, int student_id) {
		String sql =INSERT_CERT_SQL;

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);

			for (int i = 0; i < arrayList.size(); i++) {
				pstmt.setString(1, arrayList.get(i).getUser());
				pstmt.setString(2, arrayList.get(i).getName());
				pstmt.setString(3, arrayList.get(i).getIns());
				pstmt.setString(4, arrayList.get(i).getDate());
				pstmt.setInt(5, arrayList.get(i).getKeyword());
				pstmt.addBatch();
				System.out.println("성공");
			}	
			 pstmt.executeBatch();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	public void inputCareer_award(ArrayList<Award> arrayList, int student_id) {
		String sql = INSERT_AWARD_SQL;

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);

			for (int i = 0; i < arrayList.size(); i++) {
				pstmt.setString(1, arrayList.get(i).getUser());
				pstmt.setString(2, arrayList.get(i).getName());
				pstmt.setString(3, arrayList.get(i).getIns());
				pstmt.setString(4, arrayList.get(i).getGrade());
				pstmt.setString(5, arrayList.get(i).getDate());
				pstmt.setInt(6, arrayList.get(i).getKeyword());
				pstmt.addBatch();
				System.out.println("성공");
			}	
			 pstmt.executeBatch();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	public void inputCareer_club(ArrayList<Club> arrayList, int student_id) {
		String sql = INSERT_CLUB_SQL;

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);

			for (int i = 0; i < arrayList.size(); i++) {
				pstmt.setString(1, arrayList.get(i).getUser());
				pstmt.setString(2, arrayList.get(i).getName());
				pstmt.setString(3, arrayList.get(i).getDesc());
				pstmt.setString(4, arrayList.get(i).getStartDate());
				pstmt.setString(5, arrayList.get(i).getEndDate());
				pstmt.setInt(6, arrayList.get(i).getKeyword());
				pstmt.addBatch();
				System.out.println("성공");
			}	
			 pstmt.executeBatch();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	public void inputCareer_reading(ArrayList<Reading> arrayList, int student_id) {
		String sql = INSERT_READINF_SQL;

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);

			for (int i = 0; i < arrayList.size(); i++) {
				pstmt.setString(1, arrayList.get(i).getUser());
				pstmt.setString(2, arrayList.get(i).getName());
				pstmt.setString(3, arrayList.get(i).getDate());
				pstmt.setInt(4, arrayList.get(i).getKeyword());
				pstmt.addBatch();
			}	
			 pstmt.executeBatch();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	public void inputCareer_conference(ArrayList<Conference> arrayList, int student_id) {
		String sql =INSERT_CONFERENCE_SQL;

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);

			for (int i = 0; i < arrayList.size(); i++) {
				pstmt.setString(1, arrayList.get(i).getUser());
				pstmt.setString(2, arrayList.get(i).getName());
				pstmt.setString(3, arrayList.get(i).getDate());
				pstmt.setInt(4, arrayList.get(i).getKeyword());		
				pstmt.addBatch();
			}	
			 pstmt.executeBatch();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	public void inputCareer_volunteer(ArrayList<Volunteer> arrayList, int student_id) {
		String sql =INSERT_VOLUNTEER_SQL;

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);

			for (int i = 0; i < arrayList.size(); i++) {
				pstmt.setString(1, arrayList.get(i).getUser());
				pstmt.setString(2, arrayList.get(i).getName());
				pstmt.setString(3, arrayList.get(i).getIns());
				pstmt.setString(4, arrayList.get(i).getStartTime());
				pstmt.setString(5, arrayList.get(i).getEndTime());
				pstmt.setInt(6, arrayList.get(i).getKeyword());
				pstmt.addBatch();
			}	
			 pstmt.executeBatch();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	public void inputCareer_test(ArrayList<Test> arrayList, int student_id) {
		String sql =INSERT_TEST_SQL;

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);

			for (int i = 0; i < arrayList.size(); i++) {
				pstmt.setString(1, arrayList.get(i).getUser());
				pstmt.setString(2, arrayList.get(i).getName());
				pstmt.setInt(3, arrayList.get(i).getScore());
				pstmt.setString(4, arrayList.get(i).getDate());
				pstmt.setInt(5, arrayList.get(i).getKeyword());
				pstmt.addBatch();
			}	
			 pstmt.executeBatch();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	public void inputCareer_project(ArrayList<Project> arrayList, int student_id) {
		String sql = INSERT_PROJECT_SQL;

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);

			for (int i = 0; i < arrayList.size(); i++) {
				pstmt.setString(1, arrayList.get(i).getUser());
				pstmt.setString(2, arrayList.get(i).getName());
				pstmt.setString(3, arrayList.get(i).getDesc());
				pstmt.setString(4, arrayList.get(i).getStartDate());
				pstmt.setString(5, arrayList.get(i).getEndDate());
				pstmt.setInt(6, arrayList.get(i).getKeyword());
				pstmt.addBatch();
				System.out.println("성공");
			}	
			 pstmt.executeBatch();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
