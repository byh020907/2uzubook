package resume;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.sun.org.apache.regexp.internal.recompile;

import dao.Database;
import etc.Reading;
import etc.Volunteer;

public class ResumeDAO extends Parser{
	
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
	
/*	public String majorToString(int majorNum) {
		String SQL = "select name from major where id=?";
		String major = null;
		try {

			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, majorNum);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				major = rs.getString("name");
			}

			return major;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return major;
	}*/
	
	public int getKeywordNum(String name) {
		String SQL = "select id from keyword where name=?";
		int keyword = 0;
		try {

			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				keyword = rs.getInt("id");
			}

			return keyword;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return keyword;
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
	
	public JSONObject select_resume_single(String id,String name,int position) {
		JSONObject jsonObject=new JSONObject();
		
		switch (position) {
		case 1:
			// 자격증
			String SQL_CERT = "select * from cert where user=? and name=?";
			jsonObject = executeAndGet_single(SQL_CERT, id,name);
			return jsonObject;
		case 2:
			// 수상경력
			String SQL_AWARD = "select * from award where user=? and name=?";
			jsonObject = executeAndGet_single(SQL_AWARD, id,name);
			return jsonObject;
		case 3:
			// 동아리
			String SQL_CLUB = "select * from club where user=? and name=?";
			jsonObject = executeAndGet_single(SQL_CLUB, id,name);
			return jsonObject;
		case 4:
			// 프로젝트
			String SQL_PROJECT = "select * from project where user=? and name=?";
			jsonObject = executeAndGet_single(SQL_PROJECT, id,name);
			return jsonObject;
		case 5:
			//test
			String SQL_TEST="select * from test where user=? and name=?";
			jsonObject = executeAndGet_single(SQL_TEST, id,name);
			return jsonObject;
		case 6:
			//컴퍼런스
			String SQL_CONFERENCE="select * from conference where user=? and name=?";
			jsonObject = executeAndGet_single(SQL_CONFERENCE, id,name);
			return jsonObject;
		default:
			return jsonObject;
		}
	}

	public JSONArray select_resume(String id, int position) {

		JSONArray jsonArray = new JSONArray();
		
		JSONArray test=new JSONArray();

		String SQL="select * from keyword where name=?";

		switch (position) {
		case 1:
			// 자격증 SELECT DISTINCT user.id, user.name, user.stu_id, user.gender, major.name AS major FROM user
			String SQL_CERT = "SELECT cert.name, cert.ins, cert.keyword, keyword.name as keyword FROM cert LEFT JOIN keyword ON cert.keyword=keyword.id where user=?";	
			jsonArray = executeAndGet(SQL_CERT, id);
			
			if(jsonArray!=null) {
				if(jsonArray.toString()=="")
				{
					return jsonArray;
				}else {
					for(int i=0;i<jsonArray.size();i++)                                                                                                                                 
					{
						JSONObject jsonObject_2 = (JSONObject) jsonArray.get(i);
						String name_2 = (String) jsonObject_2.get("keyword");

						test = executeAndGet(SQL, name_2);
						JSONObject object_2 = (JSONObject) test.get(0);
						int keyword_id_2 = (Integer) object_2.get("id");
						jsonObject_2.put("keyword_id", keyword_id_2);
						
					}
				}
			}
			
			
			return jsonArray;
			
		case 2:
			// 수상경력
			String SQL_AWARD = "SELECT award.name, award.ins, award.keyword, keyword.name as keyword FROM award LEFT JOIN keyword ON award.keyword=keyword.id where user=?";
			jsonArray = executeAndGet(SQL_AWARD, id);
			
			if(jsonArray!=null) {
				if(jsonArray.toString()=="")
				{
					return jsonArray;
				}else {
					for(int i=0;i<jsonArray.size();i++)                                                                                                                                 
					{
						JSONObject jsonObject_2 = (JSONObject) jsonArray.get(i);
						String name_2 = (String) jsonObject_2.get("keyword");

						test = executeAndGet(SQL, name_2);
						JSONObject object_2 = (JSONObject) test.get(0);
						int keyword_id_2 = (Integer) object_2.get("id");
						jsonObject_2.put("keyword_id", keyword_id_2);
						
					}
				}
			}
			
			
			return jsonArray;
		case 3:
			// 동아리
			String SQL_CLUB = "select club.name, club.desc, club.startDate, club.endDate, club.keyword, keyword.name as keyword FROM club LEFT JOIN keyword ON club.keyword=keyword.id where user=?";
			jsonArray = executeAndGet(SQL_CLUB, id);
			
			
			if(jsonArray!=null) {
				if(jsonArray.toString()=="")
				{
					return jsonArray;
				}else {
					for(int i=0;i<jsonArray.size();i++)                                                                                                                                 
					{
						JSONObject jsonObject_2 = (JSONObject) jsonArray.get(i);
						String name_2 = (String) jsonObject_2.get("keyword");

						test = executeAndGet(SQL, name_2);
						JSONObject object_2 = (JSONObject) test.get(0);
						int keyword_id_2 = (Integer) object_2.get("id");
						jsonObject_2.put("keyword_id", keyword_id_2);
						
					}
				}
			}
			
			
			return jsonArray;

		case 4:
			// 프로젝트
			String SQL_PROJECT = "select project.name, project.desc, project.startDate, project.endDate, project.keyword, keyword.name as keyword FROM project LEFT JOIN keyword ON project.keyword=keyword.id where user=?";
			jsonArray = executeAndGet(SQL_PROJECT, id);
			
			
			if(jsonArray!=null) {
				if(jsonArray.toString()=="")
				{
					return jsonArray;
				}else {
					for(int i=0;i<jsonArray.size();i++)                                                                                                                                 
					{
						JSONObject jsonObject_2 = (JSONObject) jsonArray.get(i);
						String name_2 = (String) jsonObject_2.get("keyword");

						test = executeAndGet(SQL, name_2);
						JSONObject object_2 = (JSONObject) test.get(0);
						int keyword_id_2 = (Integer) object_2.get("id");
						jsonObject_2.put("keyword_id", keyword_id_2);
						
					}
				}
			}
			
			
			return jsonArray;
		case 5:
			//test
			String SQL_TEST="select test.name, test.score, test.date, test.keyword,  keyword.name as keyword FROM test LEFT JOIN keyword ON test.keyword=keyword.id where user=?";
			jsonArray = executeAndGet(SQL_TEST, id);
			
			
			if(jsonArray!=null) {
				if(jsonArray.toString()=="")
				{
					return jsonArray;
				}else {
					for(int i=0;i<jsonArray.size();i++)                                                                                                                                 
					{
						JSONObject jsonObject_2 = (JSONObject) jsonArray.get(i);
						String name_2 = (String) jsonObject_2.get("keyword");

						test = executeAndGet(SQL, name_2);
						JSONObject object_2 = (JSONObject) test.get(0);
						int keyword_id_2 = (Integer) object_2.get("id");
						jsonObject_2.put("keyword_id", keyword_id_2);
						
					}
				}
			}
			
			
			return jsonArray;
		case 6:
			// 컴퍼런ㅅ그
			String SQL_CONFERENCE = "select conference.name, conference.date, conference.keyword, keyword.name as keyword FROM conference LEFT JOIN keyword ON conference.keyword=keyword.id where user=?";
			jsonArray = executeAndGet(SQL_CONFERENCE, id);

			
			if(jsonArray!=null) {
				if(jsonArray.toString()=="")
				{
					return jsonArray;
				}else {
					for(int i=0;i<jsonArray.size();i++)                                                                                                                                 
					{
						JSONObject jsonObject_2 = (JSONObject) jsonArray.get(i);
						String name_2 = (String) jsonObject_2.get("keyword");

						test = executeAndGet(SQL, name_2);
						JSONObject object_2 = (JSONObject) test.get(0);
						int keyword_id_2 = (Integer) object_2.get("id");
						jsonObject_2.put("keyword_id", keyword_id_2);
						
					}
				}
			}
			
			
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
		String SQL = "insert into test (user,name,score,date,keyword) values (?,?,?,?,?)";

		try {
			return executeAndUpdate(SQL,test.getUser(),test.getName(),test.getScore(),test.getDate(),test.getKeyword());
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

	public int update_test(String name, int score, String date,int keyword) {
		String SQL = "update test set name=?, score=? ,date=?, keyword=?";
		try {
			return executeAndUpdate(SQL, name, score, keyword);
			// 성공이면 0 이상
		} catch (Exception e) {
			// TODO: handle exception
		}
		return -1;
	}
	
	public int update_conference(String name,String date,int keyword) {
		String SQL = "update conference set name=?, date=? , keyword=?";
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
	
	public String getKeywordName(int keyword) {
		JSONArray jsonArray=new JSONArray();
		
		String sql="select name from keyword where id=?";
		
		jsonArray=executeAndGet(sql, keyword);
		
		return (String) ((JSONObject)jsonArray.get(0)).get("name");
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
	
public JSONArray search(int ...keyword) {
		
		int TURNSIZE=4;
		JSONArray jsonArray = new JSONArray();
		int[] keywordList=new int[keyword.length*4];

		
		StringBuilder sb = new StringBuilder( "SELECT DISTINCT user.id, user.name, user.stu_id, user.gender, major.name AS major FROM user "
				+ "LEFT JOIN award ON user.id=award.user " 
				+ "LEFT JOIN cert ON user.id=cert.user "
				+ "LEFT JOIN project ON user.id=project.user " 
				+ "LEFT JOIN club ON user.id=club.user "
				+ "LEFT JOIN major ON user.major=major.id "
                + "LEFT JOIN reading ON user.id=reading.user "
                + "LEFT JOIN volunteer ON user.id=volunteer.user "
                + "LEFT JOIN test ON user.id=test.user "
                + "LEFT JOIN conference ON user.id=conference.user "
                + "LEFT JOIN interests ON user.id=interests.user "
				+ "WHERE ");


		String sub="(award.keyword=? OR cert.keyword=? OR project.keyword=? OR club.keyword=? OR reading.keyword=? OR volunteer.keyword=? OR test.keyword=? OR conference.keyword=? OR interests.keyword=?)";
		String and=" and ";
		
		for(int i=0;i<keyword.length;i++) {
			if(i == keyword.length-1) {
				sb.append(sub);
			}else {
				sb.append(sub).append(and);							
			}
			
		}
		
		
		String totalSQL=sb.toString();
		System.out.println(totalSQL);

		if(keyword.length==1) {
			return jsonArray=executeAndGet(totalSQL, keyword[0],keyword[0],keyword[0],keyword[0],keyword[0],keyword[0],keyword[0],keyword[0],keyword[0]);
		}else if(keyword.length == 2) {
			return jsonArray = executeAndGet(totalSQL, keyword[0], keyword[0], keyword[0], keyword[0],keyword[0],keyword[0],keyword[0],keyword[0],keyword[0]
					,keyword[1], keyword[1], keyword[1], keyword[1],keyword[1],keyword[1],keyword[1],keyword[1],keyword[1]);
		}else if(keyword.length==3) {
			return jsonArray = executeAndGet(totalSQL, keyword[0], keyword[0], keyword[0], keyword[0],keyword[0],keyword[0],keyword[0],keyword[0],keyword[0]
					,keyword[1], keyword[1], keyword[1], keyword[1],keyword[1],keyword[1],keyword[1],keyword[1],keyword[1]
							,keyword[2],keyword[2],keyword[2],keyword[2],keyword[2],keyword[2],keyword[2],keyword[2],keyword[2]);
		}else if(keyword.length ==4 ) {
			return jsonArray = executeAndGet(totalSQL, keyword[0], keyword[0], keyword[0], keyword[0],keyword[0],keyword[0],keyword[0],keyword[0],keyword[0]
					,keyword[1], keyword[1], keyword[1], keyword[1],keyword[1],keyword[1],keyword[1],keyword[1],keyword[1]
							,keyword[2],keyword[2],keyword[2],keyword[2],keyword[2],keyword[2],keyword[2],keyword[2],keyword[2]
									,keyword[3],keyword[3],keyword[3],keyword[3],keyword[3],keyword[3],keyword[3],keyword[3],keyword[3]);
		}else if(keyword.length==5) {
			return jsonArray = executeAndGet(totalSQL, keyword[0], keyword[0], keyword[0], keyword[0],keyword[0],keyword[0],keyword[0],keyword[0],keyword[0]
					,keyword[1], keyword[1], keyword[1], keyword[1],keyword[1],keyword[1],keyword[1],keyword[1],keyword[1]
							,keyword[2],keyword[2],keyword[2],keyword[2],keyword[2],keyword[2],keyword[2],keyword[2],keyword[2]
									,keyword[3],keyword[3],keyword[3],keyword[3],keyword[3],keyword[3],keyword[3],keyword[3],keyword[3]
											,keyword[4],keyword[4],keyword[4],keyword[4],keyword[4],keyword[4],keyword[4],keyword[4],keyword[4]);
		}else if(keyword.length==6) {
			return jsonArray = executeAndGet(totalSQL, keyword[0], keyword[0], keyword[0], keyword[0],keyword[0],keyword[0],keyword[0],keyword[0],keyword[0]
					,keyword[1], keyword[1], keyword[1], keyword[1],keyword[1],keyword[1],keyword[1],keyword[1],keyword[1]
							,keyword[2],keyword[2],keyword[2],keyword[2],keyword[2],keyword[2],keyword[2],keyword[2],keyword[2]
									,keyword[3],keyword[3],keyword[3],keyword[3],keyword[3],keyword[3],keyword[3],keyword[3],keyword[3]
											,keyword[4],keyword[4],keyword[4],keyword[4],keyword[4],keyword[4],keyword[4],keyword[4],keyword[4]
													,keyword[5],keyword[5],keyword[5],keyword[5],keyword[5],keyword[5],keyword[5],keyword[5],keyword[5]);
		}else if(keyword.length==7) {
			return jsonArray = executeAndGet(totalSQL, keyword[0], keyword[0], keyword[0], keyword[0],keyword[0],keyword[0],keyword[0],keyword[0],keyword[0]
					,keyword[1], keyword[1], keyword[1], keyword[1],keyword[1],keyword[1],keyword[1],keyword[1],keyword[1]
							,keyword[2],keyword[2],keyword[2],keyword[2],keyword[2],keyword[2],keyword[2],keyword[2],keyword[2]
									,keyword[3],keyword[3],keyword[3],keyword[3],keyword[3],keyword[3],keyword[3],keyword[3],keyword[3]
											,keyword[4],keyword[4],keyword[4],keyword[4],keyword[4],keyword[4],keyword[4],keyword[4],keyword[4]
													,keyword[5],keyword[5],keyword[5],keyword[5],keyword[5],keyword[5],keyword[5],keyword[5],keyword[5]
															,keyword[6],keyword[6],keyword[6],keyword[6],keyword[6],keyword[6],keyword[6],keyword[6],keyword[6]);
		}
		
		return jsonArray;
				
	}
	
	public JSONArray stringSearch(String content) {
		String SQL_USER="select * from user where adm_year like ? or stu_id like ? or intro like ? or name like ? or gender like ?;";
		String SQL_AWARD="select * from award where name like ? or ins like ?";
		String SQL_CERT="select * from cert where name like ? or ins like ?";
		String SQL_CLUB="select * from club where name like ? or `desc` like ?";
		String SQL_CONFERENCE="select * from conference where name like ?";
		String SQL_PROJECT="select * from project where name like ? or `desc` like ?";
		String SQL_TEST="select * from test where name like ? or score like ?";
		String SQL_VOLUNTEER="select * from volunteer where name like ? or ins like ?";
		String SQL_READING="select * from reading where name like ?";
		
		String[] SQL_ARRAYS = { SQL_USER, SQL_AWARD, SQL_CERT, SQL_CLUB, SQL_CONFERENCE, SQL_PROJECT, SQL_TEST,
				SQL_VOLUNTEER, SQL_READING };

		JSONArray totalJsonArray = new JSONArray();

		for (int i = 0; i < SQL_ARRAYS.length; i++) {
			JSONArray ONE_SQL_JSONARRAY = new JSONArray();
			int parameter = getCharNumber(SQL_ARRAYS[i], '?'); //?의 갯수를 얻어옴
			String contents[] = new String[parameter]; // ?의 갯수 만큼 넣어준 배열크기 선언
			for (int j = 0; j < parameter; j++) {
				contents[j] = content;
			}
			ONE_SQL_JSONARRAY = executeAndGet(SQL_ARRAYS[i], contents);
			totalJsonArray.addAll(ONE_SQL_JSONARRAY);
		}

		return totalJsonArray;
	}
	
	@SuppressWarnings("unchecked")
	public JSONArray totalSearch(JSONArray...jsonArraysjson) {
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
		} catch (Exception e) {
			// TODO: handle exception
		}

		return jsonArray;
	}

	public void All_insert(JSONObject jsonObject) throws SQLException {
		JSONArray jsonArrCerts;
		JSONArray jsonArrAward;
		JSONArray jsonArrClubs;
		JSONArray jsonArrReadings;
		JSONArray jsonArrConferences;
		JSONArray jsonArrVolunteers;
		JSONArray jsonArrTests;
		JSONArray jsonArrProjects;

		ArrayList<Cert> certs;
		ArrayList<Award> awards;
		ArrayList<Club> clubs;
		ArrayList<Reading> readings;
		ArrayList<Conference> conferences;
		ArrayList<Volunteer> volunteers;
		ArrayList<Test> tests;
		ArrayList<Project> projects;

		jsonArrCerts = (JSONArray) jsonObject.get("licenseArr");
		if(jsonArrCerts != null) {
			certs = certsJsonArrayParser(jsonArrCerts);
			inputCareer_cert(certs);
		}else {
			System.out.println("JsonArray 없음");
		}
		
		jsonArrAward = (JSONArray) jsonObject.get("awardArr");
		if(jsonArrAward != null) {
			awards = awardsJsonArrayParser(jsonArrAward);
			inputCareer_award(awards);
		}else {
			System.out.println("JsonArray 없음");
		}
		
		jsonArrClubs = (JSONArray) jsonObject.get("clubArr");
		if(jsonArrClubs!=null) {
			clubs = clubsJsonArrayParser(jsonArrClubs);
			inputCareer_club(clubs);
		}else {
			System.out.println("JsonArray 없음");
		}
		
	
		jsonArrReadings = (JSONArray) jsonObject.get("readingArr");
		if(jsonArrReadings !=null) {
			readings = readingsJsonArrayParser(jsonArrReadings);
			inputCareer_reading(readings);
		}else {
			System.out.println("JsonArray 없음");
		}
		
		
		jsonArrConferences = (JSONArray) jsonObject.get("conferenceArr");
		if(jsonArrConferences != null) {
			conferences = conferencesJsonArrayParser(jsonArrConferences);
			inputCareer_conference(conferences);
		}else {
			System.out.println("JsonArray 없음");
		}
		
		
		jsonArrVolunteers = (JSONArray) jsonObject.get("volunteerArr");
		if(jsonArrVolunteers!=null) {
			volunteers = volunteersJsonArrayParser(jsonArrVolunteers);
			inputCareer_volunteer(volunteers);
		}else {
			System.out.println("JsonArray 없음");
		}
		
		
		jsonArrTests = (JSONArray) jsonObject.get("testArr");
		if(jsonArrTests !=null) {
			tests = testsJsonArrayParser(jsonArrTests);
			inputCareer_test(tests);

		}else {
			System.out.println("JsonArray 없음");
		}
		

		jsonArrProjects = (JSONArray) jsonObject.get("projectArr");
		if(jsonArrProjects != null) {
			projects = projectsJsonArrayParser(jsonArrProjects);
			inputCareer_project(projects);
		}else {
			System.out.println("JsonArray 없음");
		}
		
	
	}



	// ?로 가 몇개인지 알려주는 함수
	public int getCharNumber(String str,char c) {
		int count=0;
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)==c) {
				count++;
			}
		}
		return count;
	}
}
