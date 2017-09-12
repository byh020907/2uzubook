package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import user.Account;

public class Database {
	/*
	 * 서버 내의 데이터베이스를 다루는 싱글톤 객체 
	 */
	
	private Connection connection;
	private static Database instance;
	
    private Database() {
    	// Driver 객체 동적 로딩 및 connection 인스턴스 초기화
    	try {
    		// 객체 생성 시 서버의 데이터베이스와 연결 
    		Class.forName("com.mysql.jdbc.Driver");    // Driver 클래스를 동적 로딩 및 생성
    		connection = DriverManager.getConnection("jdbc:mysql://10.156.145.110/2uzubook", "root", "root0209");    // 서버 내의 데이터베이스와의 커넥션 생성
    	} catch (ClassNotFoundException | SQLException e) {
    		e.printStackTrace();
    	} 
    }
    
    public static Database getInstance() {
    	if(instance==null)
    		instance=new Database();
    	return instance;
    }
    
    public JSONArray executeAndGet(String sql, Object ... objects) {
    	// SELECT와 같이 테이블의 값을 조회하는 쿼리 실행
    	try {
    		// connection PreparedStatement 실행
    		PreparedStatement statement = connection.prepareStatement(sql);
        	if (objects.length > 0) {
        		// 플레이스 홀더 (물음표 : ?) 가 담긴 SQL 문을 실행 시 파라미터 조회
    			int index = 1;
    			for (Object object : objects) {
        			statement.setObject(index++, object);
        		}
        		return filterData(statement.executeQuery());
        	} else {
        		// 플레이스 홀더가 없을 경우 바로 SQL 실행
        		return filterData(statement.executeQuery());
        	} 
    	} catch (SQLException sqlE) {
    		sqlE.printStackTrace();
    		return null;
    	}
    }
    
    public int executeAndUpdate(String sql, Object ... objects) {
    	// DELETE, INSERT, UPDATE와 같이 테이블의 값을 변경하는 쿼리 실행
    	try {
    		PreparedStatement statement = connection.prepareStatement(sql);
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
    	// 튜플들의 데이터가 담긴 ResultSet 객체를 ArrayList 형태로 가공 및 반환
    	JSONArray results = new JSONArray();

    	while (resultSet.next()) {
    		// 튜플들의 목록을 조회한다
    		JSONObject result = new JSONObject();
			ResultSetMetaData metaData = resultSet.getMetaData(); 
			for (int i = 1; i <= metaData.getColumnCount(); i++) {
				// 해당 튜플 내 메타데이터를 조회한다
    		    String label = metaData.getColumnLabel(i);
    		    Object value = resultSet.getObject(i);
    		    result.put(label, value);
			}
			results.add(result);    // results JSONArray에 튜플의 데이터를 추가한다 
		}
    	
    	return results;    // 비정상적인 종료인지, 결과 값이 없는 것인지 확인하기 위해 그대로 results 반환
    }
    
    public int login(String id,String password){
		String sql="select password from account where id= ?";
		
		try{
			PreparedStatement pstmt=connection.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()){
				if(rs.getString(1).equals(password)){
					return 1; //성공
				}else{
					return 0; //로그인 실패(비밀 번호가 다름)
				}
			}
			return -1; //로그인 실패(해당 id 가없음)
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return 0;
	}
    
    public int join(Account account){
		String sql="insert into account values(?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement pstmt=connection.prepareStatement(sql);
			pstmt.setInt(1, account.getStudent_id());
			pstmt.setString(2, account.getId());
			pstmt.setString(3, account.getPassword());
			pstmt.setString(4, account.getName());
			pstmt.setString(5, account.getGender());
			pstmt.setString(6, account.getMajor());
			pstmt.setString(7, account.getEmail());
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;//데이터베이스 오류
	}
    
    public JSONArray getSearchData(Object ...objs){
    	return null;
    }
    
    public int getNextNum(){
		String SQL="SELECT USERNO FROM serial ORDER BY USERNO DESC limit 1";
		try{
			PreparedStatement pstmt=connection.prepareStatement(SQL);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()){
				return rs.getInt(1)+1;
			}
			return 1;//첫 번째 게시물인 경우
		}catch(Exception e){
			e.printStackTrace();
		}
		return -1;//데이터베이스 오류
		
	}
    
    public int createSerialKey(){
    	String sql="INSULT INTO serial VALUES(?,?,?)";
		
    	int num=0;
    	String serialKey="";
    	String content="";
		try{
			PreparedStatement pstmt=connection.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, serialKey);
			pstmt.setString(3, content);
			
			return pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
    	return -1;//데이터베이스 오류
    }
    
    public JSONArray search(String name, int student_id, String major){
    	String SQL="select a.student_id, a.name, a.gender, a.major from account as a "
    			+ "where a.name like ?% or a.student_id like ?% or a.major like ?%";
    	try{
			JSONArray arr=executeAndGet(SQL,name,student_id,major);
			return arr;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;//데이터베이스 오류
    }
}

