package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import resume.Resume;
import user.Account;

public class Database {

	private Connection conn;
	private static Database instance;

	private Database() {
		try {
			String dbURL = "jdbc:mysql://localhost:3306/2uzubook";
			String dbID = "root";
			String dbPW = "root0209";
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, dbID, dbPW);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public static Database getInstance() {
		if (instance == null)
			instance = new Database();
		return instance;
	}

	public JSONArray executeAndGet(String sql, Object... objects) {
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			if (objects.length > 0) {
				int index = 1;
				for (Object object : objects) {
					statement.setObject(index++, object);
				}
				return filterData(statement.executeQuery());
			} else {
				return filterData(statement.executeQuery());
			}
		} catch (SQLException sqlE) {
			sqlE.printStackTrace();
			return null;
		}
	}

	public int executeAndUpdate(String sql, Object... objects) {
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			if (objects.length > 0) {
				int index = 1;
				for (Object object : objects) {
					statement.setObject(index++, object);
				}
				return statement.executeUpdate();
			} else {
				return statement.executeUpdate();
			}
		} catch (SQLException sqlE) {
			sqlE.printStackTrace();
			return -1;
		}
	}

	private static JSONArray filterData(ResultSet resultSet) throws SQLException {
		JSONArray results = new JSONArray();

		while (resultSet.next()) {
			JSONObject result = new JSONObject();
			ResultSetMetaData metaData = resultSet.getMetaData();
			for (int i = 1; i <= metaData.getColumnCount(); i++) {
				String label = metaData.getColumnLabel(i);
				Object value = resultSet.getObject(i);
				result.put(label, value);
			}
			results.add(result);
		}

		return results;
	}

	public int registerStudent(Account account) {
		String SQL = "insert into account values(?,?,?,?,?,?,?,?)";

		try {
			int num = executeAndUpdate(SQL, account.getStudent_id(), account.getId(), account.getPassword(),
					account.getIntro(), account.getName(), account.getGender(), account.getMajor(), account.getEmail());
			return num;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return -1;
	}

	public int registerCompany(String companyName,String companyEmail,int keyword_category) {
    	String SQL = "insert into serial values(?,?,?)";
    	
    	try {		
    		int num = executeAndUpdate(SQL, );
    		return num;
    	}catch (Exception e) {
			e.printStackTrace();
		}
    	
    	return -1;
    }

	public int insert_resume(Resume resume, int check) {
		String SQL = "insert into resume (student_id,name,content,startDate,finishDate,resume_num,keyword_num)"
				+ "values(?,?,?,?,?,?,?)";
		String NULL_FINISHDATE_SQL = "insert into resume"
				+ "(student_id,name,content,startDate,resume_num,keyword_num) " + "values(?,?,?,?,?,?)";
		try {
			if (check == 0) {
				// 프로젝트 같은경우는 시작점과 끝나는 시점을 넣어야하기때매 flag 값 0 을 전달해줘야됌
				PreparedStatement pstmt = conn.prepareStatement(SQL);
				pstmt.setInt(1, resume.getStudent_id());
				pstmt.setString(2, resume.getResumeName());
				pstmt.setString(3, resume.getResumeContent());
				pstmt.setString(4, resume.getResumeStartDate());
				pstmt.setString(5, resume.getResumeFinishDate());
				pstmt.setInt(6, resume.getResume_category());
				pstmt.setInt(7, resume.getKeyword_category());
				return pstmt.executeUpdate();
			} else if (check == 1) {
				// 자격증 같은거는 취득한날만 있어도 되기 떄매 startDate 넣어줌 flag 값은 1
				PreparedStatement pstmt = conn.prepareStatement(NULL_FINISHDATE_SQL);
				pstmt.setInt(1, resume.getStudent_id());
				pstmt.setString(2, resume.getResumeName());
				pstmt.setString(3, resume.getResumeContent());
				pstmt.setString(4, resume.getResumeStartDate());
				pstmt.setInt(5, resume.getResume_category());
				pstmt.setInt(6, resume.getKeyword_category());
				return pstmt.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public JSONArray select_intro_resume(Resume resume) {
		String INTRO_SQL = "select intro from account where student_id=?";

		JSONArray jsonArray = new JSONArray();

		try {
			jsonArray = executeAndGet(INTRO_SQL, resume.getStudent_id());

		} catch (Exception e) {
			// TODO: handle exception
		}
		return jsonArray;
	}

	public JSONArray select_license_resume(Resume resume) {
		String LICENSE_SQL = "select name,title from resume where student_id=? and resume_num=1";

		JSONArray jsonArray = new JSONArray();

		try {
			/*
			 * PreparedStatement pstmt = conn.prepareStatement(AWARD_SQL); ResultSet
			 * rs=pstmt.executeQuery();
			 */
			jsonArray = executeAndGet(LICENSE_SQL, resume.getStudent_id());
		} catch (Exception e) {
			// TODO: handle exception
		}

		return jsonArray;
	}

	public JSONArray select_award_resume(Resume resume) {
		String AWARD_SQL = "select name,title from resume where student_id=? and resume_num=2";

		JSONArray jsonArray = new JSONArray();

		try {
			/*
			 * PreparedStatement pstmt = conn.prepareStatement(AWARD_SQL); ResultSet
			 * rs=pstmt.executeQuery();
			 */
			jsonArray = executeAndGet(AWARD_SQL, resume.getStudent_id());
		} catch (Exception e) {
			// TODO: handle exception
		}

		return jsonArray;
	}

	public JSONArray select_contest_resume(Resume resume) {
		String CONTEST_SQL = "select name,title from resume where student_id=? and resume_num=3";

		JSONArray jsonArray = new JSONArray();

		try {
			/*
			 * PreparedStatement pstmt = conn.prepareStatement(CONTEST_SQL); pstmt.setInt(1,
			 * resume.getStudent_id()); ResultSet rs=pstmt.executeQuery();
			 */
			jsonArray = executeAndGet(CONTEST_SQL, resume.getStudent_id());
		} catch (Exception e) {
			// TODO: handle exception
		}

		return jsonArray;
	}

	public JSONArray select_intern_resume(Resume resume) {
		String INTERN_SQL = "select name,title from resume where student_id=? and resume_num=4";

		JSONArray jsonArray = new JSONArray();

		try {
			/*
			 * PreparedStatement pstmt = conn.prepareStatement(CONTEST_SQL); pstmt.setInt(1,
			 * resume.getStudent_id()); ResultSet rs=pstmt.executeQuery();
			 */
			jsonArray = executeAndGet(INTERN_SQL, resume.getStudent_id());
		} catch (Exception e) {
			// TODO: handle exception
		}

		return jsonArray;
	}

	public JSONArray select_project_resume(Resume resume) {
		String PROJECT_SQL = "select name,title from resume where student_id=? and resume_num=5";

		JSONArray jsonArray = new JSONArray();

		try {
			/*
			 * PreparedStatement pstmt = conn.prepareStatement(CONTEST_SQL); pstmt.setInt(1,
			 * resume.getStudent_id()); ResultSet rs=pstmt.executeQuery();
			 */
			jsonArray = executeAndGet(PROJECT_SQL, resume.getStudent_id());
		} catch (Exception e) {
			// TODO: handle exception
		}

		return jsonArray;
	}

	public int getNextNum() {
		String SQL = "SELECT USERNO FROM serial ORDER BY USERNO DESC limit 1";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getInt(1) + 1;
			}
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;

	}

	public int createSerialKey() {
		String sql = "INSULT INTO serial VALUES(?,?,?)";

		int num = 0;
		String serialKey = "";
		String content = "";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, serialKey);
			pstmt.setString(3, content);

			return pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return -1;
	}

	public JSONArray keyword_search(String keyword) {
		String SQL = "select * from resume where keyword_num = (select num from keyword_category where name like %?%)";

		JSONArray jsonArray = new JSONArray();
		try {
			jsonArray = executeAndGet(SQL, keyword);
			return jsonArray;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public int check_id(String id) {
		String sql = "select id from account where id= ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				if (rs.getString(1).equals(id)) {
					return 1;
				} else {
					return 0;
				}
			}
			return -1;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return 0;

	}

}
