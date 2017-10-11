package etc;

import org.json.simple.JSONArray;

import com.sun.org.apache.regexp.internal.recompile;

import dao.Database;
import resume.Project;
import resume.ResumeDAO;

public class EtcDAO extends Database {
	
	private static EtcDAO instance;
	
	private EtcDAO(){}
	
	public static EtcDAO getInstance(){
		if(instance==null)
			instance=new EtcDAO();
		return instance;
	}

	public JSONArray select_resume(String id, int position) {

		JSONArray jsonArray = new JSONArray();

		switch (position) {
		case 1:
			// 봉사
			String SQL_VOLUNTEER = "select * from volunteer where user=?";
			jsonArray = executeAndGet(SQL_VOLUNTEER, id);
			return jsonArray;
		case 2:
			// 독서
			String SQL_READING = "select * from reading where user=?";
			jsonArray = executeAndGet(SQL_READING, id);
			return jsonArray;
		case 3:
			//관심분야
			String SQL_INTERESTS = "select * from interests where user=?";
			jsonArray = executeAndGet(SQL_INTERESTS, id);
			return jsonArray;
		default:
			return jsonArray;
		}
	}
	
	public int insert_interest(Interest interest) {
		String SQL= "insert into interests (user,name,date) values (?,?,?)";
		
		try {
			return executeAndUpdate(SQL, interest.getUser(), interest.getName(), interest.getDate());
			// 성공이면 0 이상
		} catch (Exception e) {
			// TODO: handle exception
		}
		return -1;
	}
	
	public int insert_reading(Reading reading) {
		String SQL = "insert into reading (user,name,date,keyword) values (?,?,?,?)";

		try {
			return executeAndUpdate(SQL, reading.getUser(), reading.getName(), reading.getDate(),
					reading.getKeyword());
			// 성공이면 0 이상
		} catch (Exception e) {
			// TODO: handle exception
		}

		return -1;
	}
	
	public int insert_volunteer(Volunteer volunteer) {
		String SQL="insert into volunteer (user,name,ins,starttime,endtime,keyword) values (?,?,?,?,?,?)";
		try {
			return executeAndUpdate(SQL, volunteer.getUser(), volunteer.getName(), volunteer.getIns(),
					volunteer.getStartTime(),volunteer.getEndTime(),volunteer.getKeyword());
			// 성공이면 0 이상
		} catch (Exception e) {
			// TODO: handle exception
		}

		return -1;
	}
	
	public int update_reading(String name,String date,int keyword) {
		String SQL="update reading set name=?,date=?,keyword=?";
		
		try {
			return executeAndUpdate(SQL,name,date,keyword);
			// 성공이면 0 이상
		} catch (Exception e) {
			// TODO: handle exception
		}

		return -1;
	}
	
	public int update_volunteer(String name,String ins,String startTime,String endTime,int keyword) {
	String SQL="update volunteer set name=?,ins=?,starttime=?,endTime=?,keyword=?";
		
		try {
			return executeAndUpdate(SQL,name,ins,startTime,endTime,keyword);
			// 성공이면 0 이상
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return -1;
	}
	
	public int delete_etc(String user,String name,int position) {
		// 1. 봉사 2. 독서  3. 관심분야
		switch (position) {
			
			case 1:{
				String SQL_DELETE_volunteer = "delete from volunteer where user=? and name=?";
				return executeAndUpdate(SQL_DELETE_volunteer, user,name);
			}
				
			case 2:{
				String SQL_DELETE_reading = "delete from reading where user=? and name=?";
				return executeAndUpdate(SQL_DELETE_reading, user,name);
			}
			
			case 3:{
				String SQL_DELETE_reading = "delete from interests where user=? and name=?";
				return executeAndUpdate(SQL_DELETE_reading, user,name);
			}
			default:
				return -2;
		}
	}
	
	

}
