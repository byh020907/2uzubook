package resume;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import dao.Database;
import etc.Reading;
import etc.Volunteer;


public class Parser extends Database implements SQL_Command {

	public Cert certJsonObjectParser(JSONObject jsonObject) {
		String user = (String) jsonObject.get("user");
		String name = (String) jsonObject.get("name");
		String ins = (String) jsonObject.get("ins"); // 주최측 정보
		String date = (String) jsonObject.get("date");
		int keyword = Integer.parseInt((String)jsonObject.get("keyword"));
		return new Cert(user, name, ins, date, keyword);
	}

	public Award awardJsonObjectParser(JSONObject jsonObject) {
		String user = (String) jsonObject.get("user");
		String name = (String) jsonObject.get("name");
		String ins = (String) jsonObject.get("ins");
		String grade = (String) jsonObject.get("grade");
		String date = (String) jsonObject.get("date");
		int keyword = Integer.parseInt((String)jsonObject.get("keyword"));

		return new Award(user, name, ins, grade, date, keyword);
	}
	
	public Club clubJsonObjectParser(JSONObject jsonObject) {
		String user = (String) jsonObject.get("user");
		String name = (String) jsonObject.get("name");
		String desc = (String) jsonObject.get("desc");
		String startDate = (String) jsonObject.get("startDate");
		String endDate = (String) jsonObject.get("endDate");
		int keyword = Integer.parseInt((String)jsonObject.get("keyword"));

		return new Club(user, name, desc, startDate, endDate, keyword);
	}
	
	public Reading readingJsonObjectparser(JSONObject jsonObject) {
		String user = (String) jsonObject.get("user");
		String name = (String) jsonObject.get("name");
		String date = (String) jsonObject.get("date");
		int keyword = Integer.parseInt((String)jsonObject.get("keyword"));
		return new Reading(user, name, date, keyword);
	}
	
	public Conference conferenceJsonObjectparser(JSONObject jsonObject) {
		String user = (String) jsonObject.get("user");
		String name = (String) jsonObject.get("name");
		String date = (String) jsonObject.get("date");
		int keyword = Integer.parseInt((String)jsonObject.get("keyword"));
		return new Conference(user, name, date, keyword);	
	}
	

	public Volunteer volunteerJsonObjectParser(JSONObject jsonObject) {
		String user = (String) jsonObject.get("user");
		String name = (String) jsonObject.get("name");
		String ins = (String) jsonObject.get("ins");
		String startTime = (String) jsonObject.get("startTime");
		String endTime = (String) jsonObject.get("endTime");
		int keyword = Integer.parseInt((String)jsonObject.get("keyword"));

		return new Volunteer(user, name, ins, startTime, endTime, keyword);
	}
	
	public Test testJsonObjectParser(JSONObject jsonObject) {
		String user = (String) jsonObject.get("user");
		String name = (String) jsonObject.get("name");
		int score = Integer.parseInt((String)jsonObject.get("score"));
		String date = (String) jsonObject.get("date");
		int keyword = Integer.parseInt((String)jsonObject.get("keyword"));

		return new Test(user, name, score, date, keyword);
	}
	
	public Project projectJsonObjectParser(JSONObject jsonObject) {
		String user = (String) jsonObject.get("user");
		String name = (String) jsonObject.get("name");
		String desc = (String) jsonObject.get("desc");
		String startDate = (String) jsonObject.get("startDate");
		String endDate = (String) jsonObject.get("endDate");
		int keyword = Integer.parseInt((String)jsonObject.get("keyword"));

		return new Project(user, name, desc, startDate, endDate, keyword);
	}
	
	public ArrayList<Cert> certsJsonArrayParser(JSONArray jsonArray){
		ArrayList<Cert> certs=new ArrayList<>();
		
		for(int i=0;i<jsonArray.size();i++) {
			JSONObject jsonObject;
			jsonObject=(JSONObject)jsonArray.get(i);
			certs.add(certJsonObjectParser(jsonObject));
		}
		return certs;
	}
	
	public ArrayList<Award> awardsJsonArrayParser(JSONArray jsonArray){
		ArrayList<Award> awards=new ArrayList<>();
		
		for(int i=0;i<jsonArray.size();i++) {
			JSONObject jsonObject;
			jsonObject=(JSONObject)jsonArray.get(i);
			awards.add(awardJsonObjectParser(jsonObject));
		}
		return awards;
	}
	
	public ArrayList<Club> clubsJsonArrayParser(JSONArray jsonArray){
		ArrayList<Club> clubs=new ArrayList<>();
		
		for(int i=0;i<jsonArray.size();i++) {
			JSONObject jsonObject;
			jsonObject=(JSONObject)jsonArray.get(i);
			clubs.add(clubJsonObjectParser(jsonObject));
		}
		return clubs;
	}
	
	public ArrayList<Reading> readingsJsonArrayParser(JSONArray jsonArray){
		ArrayList<Reading> readings=new ArrayList<>();
		
		for(int i=0;i<jsonArray.size();i++) {
			JSONObject jsonObject;
			jsonObject=(JSONObject)jsonArray.get(i);
			readings.add(readingJsonObjectparser(jsonObject));
		}
		return readings;
	}
	
	public ArrayList<Conference> conferencesJsonArrayParser(JSONArray jsonArray){
		ArrayList<Conference> conferences=new ArrayList<>();
		
		for(int i=0;i<jsonArray.size();i++) {
			JSONObject jsonObject;
			jsonObject=(JSONObject)jsonArray.get(i);
			conferences.add(conferenceJsonObjectparser(jsonObject));
		}
		return conferences;
	}
	
	public ArrayList<Volunteer> volunteersJsonArrayParser(JSONArray jsonArray){
		ArrayList<Volunteer> volunteers=new ArrayList<>();
		
		for(int i=0;i<jsonArray.size();i++) {
			JSONObject jsonObject;
			jsonObject=(JSONObject)jsonArray.get(i);
			volunteers.add(volunteerJsonObjectParser(jsonObject));
		}
		return volunteers;
	}
	
	public ArrayList<Test> testsJsonArrayParser(JSONArray jsonArray){
		ArrayList<Test> tests=new ArrayList<>();
		
		for(int i=0;i<jsonArray.size();i++) {
			JSONObject jsonObject;
			jsonObject=(JSONObject)jsonArray.get(i);
			tests.add(testJsonObjectParser(jsonObject));
		}
		return tests;
	}
	
	public ArrayList<Project> projectsJsonArrayParser(JSONArray jsonArray){
		ArrayList<Project> certs=new ArrayList<>();
		
		for(int i=0;i<jsonArray.size();i++) {
			JSONObject jsonObject;
			jsonObject=(JSONObject)jsonArray.get(i);
			certs.add(projectJsonObjectParser(jsonObject));
		}
		return certs;
	}
	
	public void inputCareer_cert(ArrayList<Cert> arrayList) throws SQLException {
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
	
	public void inputCareer_award(ArrayList<Award> arrayList) throws SQLException {
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
	
	public void inputCareer_club(ArrayList<Club> arrayList) throws SQLException {
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

	public void inputCareer_reading(ArrayList<Reading> arrayList) throws SQLException {
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

	public void inputCareer_conference(ArrayList<Conference> arrayList) throws SQLException {
		String sql = INSERT_CONFERENCE_SQL;

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			conn.setAutoCommit(false);

			for (int i = 0; i < arrayList.size(); i++) {
				pstmt.setString(1, arrayList.get(i).getUser());
				pstmt.setString(2, arrayList.get(i).getName());
				pstmt.setString(3, arrayList.get(i).getDate());
				pstmt.setInt(4, arrayList.get(i).getKeyword());
				pstmt.addBatch();
			}
			pstmt.executeBatch();
			conn.commit();

		} catch (Exception e) {
			if (conn != null) {
				conn.rollback();
			}
			e.printStackTrace();
		}
		conn.setAutoCommit(true);                        

	}
	
	public void inputCareer_volunteer(ArrayList<Volunteer> arrayList) throws SQLException {
		String sql =INSERT_VOLUNTEER_SQL;

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			conn.setAutoCommit(false);                       

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
	
	public void inputCareer_test(ArrayList<Test> arrayList) throws SQLException {
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
	
	public void inputCareer_project(ArrayList<Project> arrayList) throws SQLException {
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
	
	public int inputWithTransaction(ArrayList<Cert> certs,ArrayList<Award> awards
			,ArrayList<Club> clubs,ArrayList<Reading> readings,ArrayList<Conference> conferences
			,ArrayList<Volunteer> volunteers,ArrayList<Test> tests,ArrayList<Project> projects) throws SQLException {
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return 0;
	}
}
