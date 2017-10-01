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

}
