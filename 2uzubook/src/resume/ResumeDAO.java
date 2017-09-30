package resume;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

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
	
	//select 할때
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

	
	//insert, update , delete
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
	
	public JSONArray select_major() {
		
		String SQL="select * from major";
		JSONArray results=new JSONArray();
		
		try {
			results=executeAndGet(SQL);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return results;
	}

	public JSONArray select_resume(String id, int position) {

		JSONArray jsonArray = new JSONArray();

		switch (position) {
		case 1:
			// 자격증
			String SQL_CERT = "select * from cert where user=?";
			jsonArray = executeAndGet(SQL_CERT, id);
			return jsonArray;
		case 2:
			// 수상경력
			String SQL_AWARD = "select * from award where user=?";
			jsonArray = executeAndGet(SQL_AWARD, id);
			return jsonArray;
		case 3:
			// 동아리
			String SQL_CLUB = "select * from club where user=?";
			jsonArray = executeAndGet(SQL_CLUB, id);
			return jsonArray;
		case 4:
			// 프로젝트
			String SQL_PROJECT = "select * from project where user=?";
			jsonArray = executeAndGet(SQL_PROJECT, id);
			return jsonArray;
		default:
			return jsonArray;
		}
	}

	public int insert_cert(Cert cert) {
		String SQL="insert into cert (user,name,ins,date,keyword) values (?,?,?,?,?)";
		
		try {
			return executeAndUpdate(SQL, cert.getUser(),cert.getName(),cert.getIns(),cert.getDate()
					,cert.getKeyword());
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return -1;
	}
	
	public int insert_award(Award award) {
		String SQL="insert into award (user,name,ins,date,keyword) values (?,?,?,?,?)";
				
		try {
			return executeAndUpdate(SQL, award.getUser(),award.getName(),award.getIns(),award.getDate()
					,award.getKeyword());
			// 성공이면 0 이상
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return -1;
	}
	
	
	//모든 컬럼을 다입력하는 클럽
	public int inert_club(Club club) {
		String SQL="insert into club (user,name,`desc`,startdate,enddate,keyword) values (?,?,?,?,?,?)";
		
		
	try {
		return executeAndUpdate(SQL, club.getUser(),club.getName(),club.getDesc(),club.getStartDate()
				,club.getEndDate(),club.getKeyword());
		// 성공이면 0 이상
		} catch (Exception e) {
			// TODO: handle exception
		}

		return -1;
	}

	// 끝나는 시간 입력안하는 함수
	public int inert_club_remove_enddate(Club club) {
		String SQL = "insert into club (user,name,`desc`,startdate,keyword) values (?,?,?,?,?)";

		try {
			return executeAndUpdate(SQL, club.getUser(), club.getName(), club.getDesc(), club.getStartDate(),
					club.getKeyword());
			// 성공이면 0 이상
		} catch (Exception e) {
			// TODO: handle exception
		}

		return -1;
	}

	// 모든 컬럼을 다입력하는 클럽
	public int inert_project(Project project) {
		String SQL = "insert into project (user,name,`desc`,startdate,enddate,keyword) values (?,?,?,?,?,?)";

		try {
			return executeAndUpdate(SQL, project.getUser(), project.getName(), project.getDesc(),
					project.getStartDate(), project.getEndDate(), project.getKeyword());
			// 성공이면 0 이상
		} catch (Exception e) {
			// TODO: handle exception
		}

		return -1;
	}

	// 끝나는 시간 입력안하는 함수
	public int inert_project_remove_enddate(Project project) {
		String SQL = "insert into project (user,name,`desc`,startdate,keyword) values (?,?,?,?,?)";

		try {
			return executeAndUpdate(SQL, project.getUser(), project.getName(), project.getDesc(), project.getStartDate(),
					project.getKeyword());
			// 성공이면 0 이상
		} catch (Exception e) {
			// TODO: handle exception
		}

		return -1;
	}
			
	
}
