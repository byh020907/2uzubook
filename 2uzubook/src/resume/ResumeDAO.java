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

	public int search(String query) {
		String sql = "SELECT DISTINCT user FROM  WHERE id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				if (rs.getString(1).equals(pw)) {
					return 1;
				} else {
					return 0;
				}
			}
			return -1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -2;
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
		}catch (Exception e) {
			// TODO: handle exception
		}
		return results;
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
	
	public int inert_club(Club club) {
		String SQL="insert into club (user,name,`desc`,startdate,enddate,keyword) values (?,?,?,?,?,?)";
		
		
	try {
		return executeAndUpdate(SQL, club.getUser(),club.getName(),club.getDesc(),club.getStartDate()
				,club.getEndDate(),club.getKeyword());
		// 성공이면 0 이상
	}catch (Exception e) {
		// TODO: handle exception
	}
	
	return -1;
	}
	
}
