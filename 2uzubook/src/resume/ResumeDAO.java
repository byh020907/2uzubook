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
			//test
			String SQL_TEST="select * from test where user=?";
			jsonArray = executeAndGet(SQL_TEST, id);
			return jsonArray;
		case 6:
			//컴퍼런ㅅ그
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
				+" "
				+ "LEFT JOIN award ON user.id=award.user "
				+ "LEFT JOIN cert ON user.id=cert.user "
				+ "LEFT JOIN project ON user.id=project.user " 
				+ "LEFT JOIN club ON user.id=club.user "
				+ "LEFT JOIN major ON user.major=major.id "
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
	
	public JSONArray serach(int ...keyword) {
		
		int TURNSIZE=4;
		JSONArray jsonArray = new JSONArray();
		int[] keywordList=new int[keyword.length*4];

		
		StringBuilder sb = new StringBuilder( "SELECT DISTINCT user.name, user.stu_id, major.name AS major FROM user "
				+ "LEFT JOIN award ON user.id=award.user " 
				+ "LEFT JOIN cert ON user.id=cert.user "
				+ "LEFT JOIN project ON user.id=project.user " 
				+ "LEFT JOIN club ON user.id=club.user "
				+ "LEFT JOIN major ON user.major=major.id "
				+ "WHERE ");


		
		String sub="(award.keyword=? OR cert.keyword=? OR project.keyword=? OR club.keyword=?)";
		String and=" and ";
		
		for(int i:keyword) {
			if(i==keyword.length) {
				sb.append(sub);
			}else {
				sb.append(sub).append(and);
			}			
		}
		
	
		String totalSQL=sb.toString();

		if(keyword.length==1) {
			return jsonArray=executeAndGet(totalSQL, keyword[0],keyword[0],keyword[0],keyword[0]);
		}else if(keyword.length == 2) {
			return jsonArray = executeAndGet(totalSQL, keyword[0], keyword[0], keyword[0], keyword[0], keyword[1], keyword[1], keyword[1], keyword[1]);
		}else if(keyword.length==3) {
			return jsonArray = executeAndGet(totalSQL, keyword[0], keyword[0], keyword[0], keyword[0], keyword[1], keyword[1], keyword[1], keyword[1],keyword[2],keyword[2],keyword[2],keyword[2]);
		}else if(keyword.length ==4 ) {
			return jsonArray = executeAndGet(totalSQL, keyword[0], keyword[0], keyword[0], keyword[0], keyword[1], keyword[1], keyword[1], keyword[1],keyword[2],keyword[2],keyword[2],keyword[2]
					,keyword[3],keyword[3],keyword[3],keyword[3]);
		}else if(keyword.length==5) {
			return jsonArray = executeAndGet(totalSQL, keyword[0], keyword[0], keyword[0], keyword[0], keyword[1], keyword[1], keyword[1], keyword[1],keyword[2],keyword[2],keyword[2],keyword[2]
					,keyword[3],keyword[3],keyword[3],keyword[3],keyword[4],keyword[4],keyword[4],keyword[4]);
		}
		
		return jsonArray;
				
	}
	
	@SuppressWarnings("unchecked")
	public JSONArray totalSerach(JSONArray...jsonArraysjson) {
		JSONArray totalJsonArray = new JSONArray();
		
		for(JSONArray i:jsonArraysjson) {
			totalJsonArray.addAll(i);
		}
		
		return totalJsonArray;
	}
	

	public int delete_resume(String user,String name, int position) {
		switch (position) {
			case 1:{
				String SQL_DELETE_AWARD = "delete from award where user=? and name=?";
				return executeAndUpdate(SQL_DELETE_AWARD, user,name);
			}
				
			case 2:{
				String SQL_DELETE_CERT = "delete from cert where user=? and name=?";
				return executeAndUpdate(SQL_DELETE_CERT, user,name);
			}
			case 3:{
				String SQL_DELETE_CLUB = "delete from club where user=? and name=?";
				return executeAndUpdate(SQL_DELETE_CLUB, user,name);
			}
			case 4:{				
				String SQL_DELETE_PROJECT = "delete from project where user=? and name=?";
				return executeAndUpdate(SQL_DELETE_PROJECT, user,name);
			}
			case 5:{				
				String SQL_DELETE_TEST = "delete from test where user=? and name=?";
				return executeAndUpdate(SQL_DELETE_TEST, user,name);
			}
			case 6:{				
				String SQL_DELETE_CONFERENCE="delete from conference where user=? and name=?";
				return executeAndUpdate(SQL_DELETE_CONFERENCE, user,name);
			}
			default:
				return -2;
		}
	}

	// 중복체크
	public int duplicate_check(String user, String name, int position) {

		// 1.award 2.cert 3.club 4.project 5.test 6. conference
		
		
		//리턴값이 ㅣ0이상이면 중복된거임
		switch (position) {
		case 1:
			String SQL_AWARD = "select name from award where user=? and name=?";

			try {
				pstmt = conn.prepareStatement(SQL_AWARD);
				pstmt.setString(1, user);
				pstmt.setString(2, name);
				return pstmt.executeUpdate(); 
			} catch (Exception e) {
				e.printStackTrace();
			}
		case 2:
			String SQL_CERT = "select name from cert where user=? and name=?";
			try {
				pstmt = conn.prepareStatement(SQL_CERT);
				pstmt.setString(1, user);
				pstmt.setString(2, name);
				return pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
		case 3:
			String SQL_CLUB = "select name from club where user=? and name=?";
			try {
				pstmt = conn.prepareStatement(SQL_CLUB);
				pstmt.setString(1, user);
				pstmt.setString(2, name);
				return pstmt.executeUpdate(); 
			} catch (Exception e) {
				e.printStackTrace();
			}
		case 4:
			String SQL_PROJECT = "select name from project where user=? and name=?";
			try {
				pstmt = conn.prepareStatement(SQL_PROJECT);
				pstmt.setString(1, user);
				pstmt.setString(2, name);
				return pstmt.executeUpdate(); 
			} catch (Exception e) {
				e.printStackTrace();
			}
		case 5:
			String SQL_TEST = "select name from test where user=? and name=?";
			try {
				pstmt = conn.prepareStatement(SQL_TEST);
				pstmt.setString(1, user);
				pstmt.setString(2, name);
				return pstmt.executeUpdate(); // 1이면 중복아님
			} catch (Exception e) {
				e.printStackTrace();
			}
		case 6:
			String SQL_conference = "select name from conference where user=? and name=?";
			try {
				pstmt = conn.prepareStatement(SQL_conference);
				pstmt.setString(1, user);
				pstmt.setString(2, name);
				return pstmt.executeUpdate(); // 0이상 이면 중복
			} catch (Exception e) {
				e.printStackTrace();
			}
		default:
			return -2; // 조회할 컬럼이 없음
		}
	}
	
	public JSONArray random_student() {
		String SQL="select * from user ORDER BY RAND() limit 10";
		
		JSONArray jsonArray=new JSONArray();
		try {
			jsonArray=executeAndGet(SQL);
			return jsonArray;
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return jsonArray;
	}
}
