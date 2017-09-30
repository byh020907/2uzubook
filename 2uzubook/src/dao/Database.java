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

	protected Connection conn;
	protected PreparedStatement pstmt;
	protected ResultSet rs;

	protected Database() {
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

	private JSONArray filterData(ResultSet resultSet) throws SQLException {
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

//	public int registerStudent(Account account) {
//		String SQL = "insert into account values(?,?,?,?,?,?,?,?)";
//
//		try {
//			int num = executeAndUpdate(SQL, account.getStudent_id(), account.getId(), account.getPassword(),
//					account.getIntro(), account.getName(), account.getGender(), account.getMajor(), account.getEmail());
//			return num;
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return -1;
//	}
//
//	public int registerCompany(String companyName,String companyEmail,int keyword_category) {
//    	String SQL = "insert into serial values(?,?,?)";
//    	
//    	try {		
//    		int num = executeAndUpdate(SQL, );
//    		return num;
//    	}catch (Exception e) {
//			e.printStackTrace();
//		}
//    	
//    	return -1;
//    }


	

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
			e.printStackTrace();
		}
		return -2;

	}

}
