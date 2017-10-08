package resume;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import dao.Database;

public class ResumeDAO extends Database{
	
	private static ResumeDAO instance;
	
	private ResumeDAO(){}
	
	public static ResumeDAO getInstance(){
		if(instance==null)
			instance=new ResumeDAO();
		return instance;
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
	
	public JSONArray select_keyword() {
		String SQL="select * from keyword"; 
		JSONArray results=new JSONArray();
		try {
			results=executeAndGet(SQL);
		} catch (Exception e) {
			// TODO: handle exception
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
		case 5:
			//대외 활동
			String SQL_CONFERENCE="select * from conference where user=?";
			jsonArray = executeAndGet(SQL_CONFERENCE, id);
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
		String SQL="insert into award (user,name,ins,grade,date,keyword) values (?,?,?,?,?,?)";
				
		try {
			return executeAndUpdate(SQL, award.getUser(),award.getName(),award.getIns(),award.getGrade(),award.getDate()
					, award.getKeyword());
			// 성공이면 0 이상
		} catch (Exception e) {
			// TODO: handle exception
		}

		return -1;
	}

	// 모든 컬럼을 다입력하는 클럽
	public int insert_club(Club club) {
		String SQL = "insert into club (user,name,`desc`,startdate,enddate,keyword) values (?,?,?,?,?,?)";

		try {
			return executeAndUpdate(SQL, club.getUser(), club.getName(), club.getDesc(), club.getStartDate(),
					club.getEndDate(), club.getKeyword());
			// 성공이면 0 이상
		} catch (Exception e) {
			// TODO: handle exception
		}

		return -1;
	}

	// 끝나는 시간 입력안하는 함수
	public int insert_club_remove_enddate(Club club) {
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
	public int insert_project(Project project) {
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
	public int insert_project_remove_enddate(Project project) {
		String SQL = "insert into project (user,name,`desc`,startdate,keyword) values (?,?,?,?,?)";

		try {
			return executeAndUpdate(SQL, project.getUser(), project.getName(), project.getDesc(),
					project.getStartDate(), project.getKeyword());
			// 성공이면 0 이상
		} catch (Exception e) {
			// TODO: handle exception
		}

		return -1;
	}

	//토익같은 시험 
	public int insert_test(Test test) {
		String SQL = "insert into test (user,name,score,keyword) values (?,?,?,?)";

		try {
			return executeAndUpdate(SQL,test.getUser(),test.getName(),test.getScore(),test.getKeyword());
			// 성공이면 0 이상
		} catch (Exception e) {
			// TODO: handle exception
		}

		return -1;
	}
	
	public int insert_conference(Conference conference) {
		String SQL="insert into conference (user,name,date,keyword) values (?,?,?,?)";
		try {
			return executeAndUpdate(SQL, conference.getUser(),conference.getName(),conference.getDate(),conference.getKeyword());
		}catch (Exception e) {
			// TODO: handle exception
		}
		return -1;
	}
	
	
	public int update_cert(String name, String ins, String date, int keyword) {
		String SQL = "update cert set name=?,ins=?,date=?,keyword=?";

		try {
			return executeAndUpdate(SQL, name, ins, date, keyword);
			// 성공이면 0 이상
		} catch (Exception e) {
			// TODO: handle exception
		}

		return -1;
	}

	public int update_award(String name, String ins, String grade,String date, int keyword) {
		String SQL = "update awawrd set name=?,ins=?,grade=?,date=?,keyword=?";

		try {
			return executeAndUpdate(SQL, name, ins,grade, date, keyword);
			// 성공이면 0 이상
		} catch (Exception e) {
			// TODO: handle exception
		}

		return -1;
	}

	public int update_club(String name, String desc, String startDate, String endDate, int keyword) {
		String SQL = "update club set name=?,`desc`=?,startdate=?,endDate=?, keyword=?";
		try {
			return executeAndUpdate(SQL, name, desc, startDate, endDate, keyword);
			// 성공이면 0 이상
		} catch (Exception e) {
			// TODO: handle exception
		}

		return -1;
	}

	public int update_project(String name, String desc, String startDate, String endDate, int keyword) {
		String SQL = "update project set name=?,`desc`=?,startdate=?,endDate=?, keyword=?";
		try {
			return executeAndUpdate(SQL, name, desc, startDate, endDate, keyword);
			// 성공이면 0 이상
		} catch (Exception e) {
			// TODO: handle exception
		}
		return -1;
	}

	public int update_test(String name, int score, int keyword) {
		String SQL = "update test set name=?, score=? , keyword=?";
		try {
			return executeAndUpdate(SQL, name, score, keyword);
			// 성공이면 0 이상
		} catch (Exception e) {
			// TODO: handle exception
		}
		return -1;
	}
	
	public int update_conference(String name,String date,int keyword) {
		String SQL = "update conference set name=?, score=? , keyword=?";
		try {
			return executeAndUpdate(SQL, name, date, keyword);
			// 성공이면 0 이상
		} catch (Exception e) {
			// TODO: handle exception
		}
		return -1;
	}
	
	public JSONArray search_keyword(String name) {
		String SQL="select * from keyword where name like %?%";
		
		JSONArray jsonArray=new JSONArray();
		
		try {
			
			jsonArray=executeAndGet(SQL, name);
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return jsonArray;

	}

	//단일 값 일때
	public JSONArray search(int keyword) {
		String SQL = "SELECT DISTINCT user.name, user.stu_id, major.name AS major FROM user"
				+ "LEFT JOIN award ON user.id=award.user" 
				+ "LEFT JOIN cert ON user.id=cert.user"
				+ "LEFT JOIN project ON user.id=project.user" 
				+ "LEFT JOIN club ON user.id=club.user"
				+ "LEFT JOIN major ON user.major=major.id"
				+ "WHERE (award.keyword=? OR cert.keyword=? OR project.keyword=? OR club.keyword=?)";
		JSONArray jsonArray = new JSONArray();
		try {
			jsonArray = executeAndGet(SQL, keyword, keyword, keyword, keyword);
			return jsonArray;
			// 성공이면 0 이상
		} catch (Exception e) {
			// TODO: handle exception
		}

		return jsonArray;

	}
	

	public int delete_resume(String user,String name, int position) {
		switch (position) {
		case 1:
			String SQL_DELETE_AWARD = "delete from award where user=?";

			try {
				pstmt = conn.prepareStatement(SQL_DELETE_AWARD);
				pstmt.setString(1, user);
				rs = pstmt.executeQuery();
				
				while (rs.next()) {
					if (rs.getString("name").equals(name)) {
						return pstmt.executeUpdate(); // 0이상 
					}
				}
				return -1;
			} catch (Exception e) {
				// TODO: handle exception
			}
			return -2; //데이터 베이스 오류
		case 2:
			String SQL_DELETE_CERT = "delete from cert where user=?";
			
			try {
				pstmt = conn.prepareStatement(SQL_DELETE_CERT);
				pstmt.setString(1, user);
				rs = pstmt.executeQuery();
				
				while (rs.next()) {
					if (rs.getString("name").equals(name)) {
						return pstmt.executeUpdate(); // 0이상 
					}
				}
				return -1;
			} catch (Exception e) {
				// TODO: handle exception
			}
			return -2; //데이터 베이스 오류
		case 3:
			String SQL_DELETE_CLUB = "delete from club where user=?";

			try {
				pstmt = conn.prepareStatement(SQL_DELETE_CLUB);
				pstmt.setString(1, user);
				rs = pstmt.executeQuery();
				
				while (rs.next()) {
					if (rs.getString("name").equals(name)) {
						return pstmt.executeUpdate(); // 0이상 
					}
				}
				return -1;
			} catch (Exception e) {
				// TODO: handle exception
			}
			return -2; //데이터 베이스 오류
		case 4:
			String SQL_DELETE_PROJECT = "delete from project where user=?";

			try {
				pstmt = conn.prepareStatement(SQL_DELETE_PROJECT);
				pstmt.setString(1, user);
				rs = pstmt.executeQuery();
				
				while (rs.next()) {
					if (rs.getString("name").equals(name)) {
						return pstmt.executeUpdate(); // 0이상 
					}
				}
				return -1;
			} catch (Exception e) {
				// TODO: handle exception
			}
			return -2; //데이터 베이스 오류
		case 5:
			String SQL_DELETE_TEST = "delete from test where user=?";
			
			try {
				pstmt = conn.prepareStatement(SQL_DELETE_TEST);
				pstmt.setString(1, user);
				rs = pstmt.executeQuery();
				
				while (rs.next()) {
					if (rs.getString("name").equals(name)) {
						return pstmt.executeUpdate(); // 0이상 
					}
				}
				return -1;
			} catch (Exception e) {
				// TODO: handle exception
			}
			return -2; //데이터 베이스 오류
		case 6:
			String SQL_DELETE_CONFERENCE="delete from conference where user=?";
			try {
				pstmt = conn.prepareStatement(SQL_DELETE_CONFERENCE);
				pstmt.setString(1, user);
				rs = pstmt.executeQuery();
				
				while (rs.next()) {
					if (rs.getString("name").equals(name)) {
						return pstmt.executeUpdate(); // 0이상 
					}
				}
				return -1;
			} catch (Exception e) {
				// TODO: handle exception
			}
			return -2; //데이터 베이스 오류
		default:
			return -3; // 누구 잘못..?
		}
	}

	// 중복체크
	public int duplicate_check(String user, String name, int position) {

		// 1.award 2.cert 3.club 4.project 5.test 6. conference

		switch (position) {
		case 1:
			String SQL_AWARD = "select name from award where user=?";

			try {
				pstmt = conn.prepareStatement(SQL_AWARD);
				pstmt.setString(1, user);
				rs = pstmt.executeQuery();
				
				while (rs.next()) {
					if (rs.getString("name").equals(name)) {
						return 0; // 0이면 중복
					}
				}
				return 1; // 1이면 중복아님
			} catch (Exception e) {
				e.printStackTrace();
			}
			return -2; // 데이터베이스 오류
		case 2:
			String SQL_CERT = "select name from cert where user=?";
			try {
				pstmt = conn.prepareStatement(SQL_CERT);
				pstmt.setString(1, user);
				rs = pstmt.executeQuery();
				
				while (rs.next()) {
					if (rs.getString("name").equals(name)) {
						return 0; // 0이면 중복
					}
				}
				return 1; // 1이면 중복아님
			} catch (Exception e) {
				e.printStackTrace();
			}
		case 3:
			String SQL_CLUB = "select name from club where user=?";
			try {
				pstmt = conn.prepareStatement(SQL_CLUB);
				pstmt.setString(1, user);
				rs = pstmt.executeQuery();
				
				while (rs.next()) {
					if (rs.getString("name").equals(name)) {
						return 0; // 0이면 중복
					}
				}
				return 1; // 1이면 중복아님
			} catch (Exception e) {
				e.printStackTrace();
			}
		case 4:
			String SQL_PROJECT = "select name from project where user=?";
			try {
				pstmt = conn.prepareStatement(SQL_PROJECT);
				pstmt.setString(1, user);
				rs = pstmt.executeQuery();
				
				while (rs.next()) {
					if (rs.getString("name").equals(name)) {
						return 0; // 0이면 중복
					}
				}
				return 1; // 1이면 중복아님
			} catch (Exception e) {
				e.printStackTrace();
			}
		case 5:
			String SQL_TEST = "select name from test where user=?";
			try {
				pstmt = conn.prepareStatement(SQL_TEST);
				pstmt.setString(1, user);
				rs = pstmt.executeQuery();
				
				while (rs.next()) {
					if (rs.getString("name").equals(name)) {
						return 0; // 0이면 중복
					}
				}
				return 1; // 1이면 중복아님
			} catch (Exception e) {
				e.printStackTrace();
			}
		case 6:
			String SQL_conference = "select name from conference where user=?";
			try {
				pstmt = conn.prepareStatement(SQL_conference);
				pstmt.setString(1, user);
				rs = pstmt.executeQuery();
				
				while (rs.next()) {
					if (rs.getString("name").equals(name)) {
						return 0; // 0이면 중복
					}
				}
				return 1; // 1이면 중복아님
			} catch (Exception e) {
				e.printStackTrace();
			}
		default:
			return -1; // 조회할 컬럼이 없음
		}
	}
}
