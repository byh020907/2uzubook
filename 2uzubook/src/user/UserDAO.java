package user;

import org.json.simple.JSONArray;

import com.sun.org.apache.regexp.internal.recompile;

import dao.Database;

public class UserDAO extends Database{

	private static UserDAO instance;
	
	private UserDAO(){}
	
	public static UserDAO getInstance(){
		if(instance==null)
			instance=new UserDAO();
		return instance;
	}
	

	public int login(String id, String pw) {
		String sql = "SELECT password FROM user WHERE id=?";
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

	public int join(String name, String gender, String email, String id, String password, int adm_year, int stu_id,
			String intro, int major) {
		String sql = "INSERT INTO user (name, gender, email, id, password, adm_year, stu_id, intro, major) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, gender);
			pstmt.setString(3, email);
			pstmt.setString(4, id);
			pstmt.setString(5, password);
			pstmt.setInt(6, adm_year);
			pstmt.setInt(7, stu_id);
			pstmt.setString(8, intro);
			pstmt.setInt(9, major);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public int insert_code(AuthenticationCode code) {
		String SQL="insert into authentication_code (user_email,code) values (?,?)";
		
		try {
			return executeAndUpdate(SQL, code.getUser_email(),code.getCode());  //0 이상 
		}catch (Exception e) {
			// TODO: handle exception
		}
		return -1;
	}
	
	public int check_code(AuthenticationCode code) {
		String SQL="select * from authentication_code where user_email=? and code=?";
		
		JSONArray ja=executeAndGet(SQL, code.getUser_email(),code.getCode());
		//디비오류
		if(ja==null)
			return -1;
		
		//코드확인
		if(ja.size()==1)
			return 1;//성공
		else
			return 0;//실패
	}
	
	public String majorToString(int majorNum) {
		String SQL="select name from major where id=?";
		String major = null;
		try {
			
			pstmt=conn.prepareStatement(SQL);
			pstmt.setInt(1, majorNum);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				major=rs.getString("name");				
			}
			
			return major;
		}catch (Exception e) {
			// TODO: handle exception
		}
		return major;
	}
}
