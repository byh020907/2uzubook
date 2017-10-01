package etc;

import dao.Database;
import resume.Project;

public class EtcDAO extends Database {

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
	String SQL="update volunteer set name=?,ins=?,startTime=?,endTime=?,keyword=?";
		
		try {
			return executeAndUpdate(SQL,name,ins,startTime,endTime,keyword);
			// 성공이면 0 이상
		} catch (Exception e) {
			// TODO: handle exception
		}

		return -1;
	}

}
