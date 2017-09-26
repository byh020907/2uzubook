package dao;

import java.sql.*;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import TEST.J;
import resume.Resume;
import user.Account;

public class Database {
	/*
	 * �꽌踰� �궡�쓽 �뜲�씠�꽣踰좎씠�뒪瑜� �떎猷⑤뒗 �떛湲��넠 媛앹껜 
	 */
	
	private Connection connection;
	private static Database instance;
	
    private Database() {
    	// Driver 媛앹껜 �룞�쟻 濡쒕뵫 諛� connection �씤�뒪�꽩�뒪 珥덇린�솕
    	try {
    		// 媛앹껜 �깮�꽦 �떆 �꽌踰꾩쓽 �뜲�씠�꽣踰좎씠�뒪�� �뿰寃� 
    		Class.forName("com.mysql.jdbc.Driver");    // Driver �겢�옒�뒪瑜� �룞�쟻 濡쒕뵫 諛� �깮�꽦
    		connection = DriverManager.getConnection("jdbc:mysql://10.156.145.110:3306/2uzubook", "root", "root0209");    // �꽌踰� �궡�쓽 �뜲�씠�꽣踰좎씠�뒪���쓽 而ㅻ꽖�뀡 �깮�꽦
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
    	// SELECT�� 媛숈씠 �뀒�씠釉붿쓽 媛믪쓣 議고쉶�븯�뒗 荑쇰━ �떎�뻾
    	try {
    		// connection PreparedStatement �떎�뻾
    		PreparedStatement statement = connection.prepareStatement(sql);
        	if (objects.length > 0) {
        		// �뵆�젅�씠�뒪 ���뜑 (臾쇱쓬�몴 : ?) 媛� �떞湲� SQL 臾몄쓣 �떎�뻾 �떆 �뙆�씪誘명꽣 議고쉶
    			int index = 1;
    			for (Object object : objects) {
        			statement.setObject(index++, object);
        		}
        		return filterData(statement.executeQuery());
        	} else {
        		// �뵆�젅�씠�뒪 ���뜑媛� �뾾�쓣 寃쎌슦 諛붾줈 SQL �떎�뻾
        		return filterData(statement.executeQuery());
        	} 
    	} catch (SQLException sqlE) {
    		sqlE.printStackTrace();
    		return null;
    	}
    }
    
    public int executeAndUpdate(String sql, Object ... objects) {
    	// DELETE, INSERT, UPDATE�� 媛숈씠 �뀒�씠釉붿쓽 媛믪쓣 蹂�寃쏀븯�뒗 荑쇰━ �떎�뻾
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
    	// �뒠�뵆�뱾�쓽 �뜲�씠�꽣媛� �떞湲� ResultSet 媛앹껜瑜� ArrayList �삎�깭濡� 媛�怨� 諛� 諛섑솚
    	JSONArray results = new JSONArray();

    	while (resultSet.next()) {
    		// �뒠�뵆�뱾�쓽 紐⑸줉�쓣 議고쉶�븳�떎
    		JSONObject result = new JSONObject();
			ResultSetMetaData metaData = resultSet.getMetaData(); 
			for (int i = 1; i <= metaData.getColumnCount(); i++) {
				// �빐�떦 �뒠�뵆 �궡 硫뷀��뜲�씠�꽣瑜� 議고쉶�븳�떎
    		    String label = metaData.getColumnLabel(i);
    		    Object value = resultSet.getObject(i);
    		    result.put(label, value);
			}
			results.add(result);    // results JSONArray�뿉 �뒠�뵆�쓽 �뜲�씠�꽣瑜� 異붽��븳�떎 
		}
    	
    	return results;    // 鍮꾩젙�긽�쟻�씤 醫낅즺�씤吏�, 寃곌낵 媛믪씠 �뾾�뒗 寃껋씤吏� �솗�씤�븯湲� �쐞�빐 洹몃�濡� results 諛섑솚
    }
    
    public int login(String id,String password){
		String sql="select password from account where id= ?";
		try{
			PreparedStatement pstmt=connection.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()){
				if(rs.getString(1).equals(password)){
					return 1; //�꽦怨�
				}else{
					return 0; //濡쒓렇�씤 �떎�뙣(鍮꾨� 踰덊샇媛� �떎由�)
				}
			}
			return -1; //濡쒓렇�씤 �떎�뙣(�빐�떦 id 媛��뾾�쓬)
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return 0;
	}
    
    public int register(Account account) {
    	String SQL = "insert into account values(?,?,?,?,?,?,?,?)";
    	
    	try {
    		
    		int num = executeAndUpdate(SQL, account.getStudnet_id(),account.getId(),account.getPassword()
    				,account.getIntro(),account.getName(),account.getGender(),account.getMajor(),account.getEmail());
    		return num;
    	}catch (Exception e) {
			// TODO: handle exception
		}
    	
    	return -1;
    }
    
	public int insert_resume(Resume resume, int check) {
		String SQL = "insert into resume values(?,?,?,?,?,?,?)";
		String NULL_FINISHDATE_SQL = "insert into resume"
				+ "(student_id,name,content,startDate,resume_num,keyword_num) " + "values(?,?,?,?,?,?)";
		try {
			if (check == 0) {
				//프로젝트 같은경우는 시작점과 끝나는 시점을 넣어야하기때매 flag 값 0 을 전달해줘야됌 
				PreparedStatement pstmt = connection.prepareStatement(SQL);
				pstmt.setInt(1, resume.getStudent_id());
				pstmt.setString(2, resume.getResumeName());
				pstmt.setString(3, resume.getResumeContent());
				pstmt.setString(4, resume.getResumeStartDate());
				pstmt.setString(5, resume.getResumeFinishDate());
				pstmt.setInt(6, resume.getResume_category());
				pstmt.setInt(7, resume.getKeyword_category());
				return pstmt.executeUpdate();
			} else if (check == 1) {
				//자격증 같은거는 취득한날만 있어도 되기 떄매 startDate 넣어줌 flag 값은 1
				PreparedStatement pstmt = connection.prepareStatement(NULL_FINISHDATE_SQL);
				pstmt.setInt(1, resume.getStudent_id());
				pstmt.setString(2, resume.getResumeName());
				pstmt.setString(3, resume.getResumeContent());
				pstmt.setString(4, resume.getResumeStartDate());
				pstmt.setInt(5, resume.getResume_category());
				pstmt.setInt(6, resume.getKeyword_category());
				return pstmt.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
    }
	

    public int join(Account account){
		String sql="insert into account values(?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement pstmt=connection.prepareStatement(sql);
			pstmt.setInt(1, account.getStudnet_id());
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
		return -1;//�뜲�씠�꽣踰좎씠�뒪 �삤瑜�
	}
    

	public JSONArray select_intro_resume(Resume resume) {
		String INTRO_SQL="select intro from account where student_id=?";
		
		JSONArray jsonArray=new JSONArray();
		
		try {
			jsonArray=executeAndGet(INTRO_SQL, resume.getStudent_id());

		}catch (Exception e) {
			// TODO: handle exception
		}
		return jsonArray;
	}
	
	
	public JSONArray select_license_resume(Resume resume) {
		String LICENSE_SQL="select name,title from resume where student_id=? and resume_num=1";
		
		JSONArray jsonArray=new JSONArray();
		
		try {
/*			PreparedStatement pstmt = connection.prepareStatement(AWARD_SQL);
			ResultSet rs=pstmt.executeQuery();*/
			jsonArray=executeAndGet(LICENSE_SQL, resume.getStudent_id());
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return jsonArray;
	}
	
	public JSONArray select_award_resume(Resume resume) {
		String AWARD_SQL="select name,title from resume where student_id=? and resume_num=2";
		
		JSONArray jsonArray=new JSONArray();
		
		try {
/*			PreparedStatement pstmt = connection.prepareStatement(AWARD_SQL);
			ResultSet rs=pstmt.executeQuery();*/
			jsonArray=executeAndGet(AWARD_SQL, resume.getStudent_id());
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return jsonArray;
	}
	
	public JSONArray select_contest_resume(Resume resume) {
		String CONTEST_SQL="select name,title from resume where student_id=? and resume_num=3";
		
		JSONArray jsonArray=new JSONArray();
		
		try {
		/*	PreparedStatement pstmt = connection.prepareStatement(CONTEST_SQL);
			pstmt.setInt(1, resume.getStudent_id());
			ResultSet rs=pstmt.executeQuery();*/
			jsonArray=executeAndGet(CONTEST_SQL, resume.getStudent_id());
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return jsonArray;
	}
	
	public JSONArray select_intern_resume(Resume resume) {
		String INTERN_SQL="select name,title from resume where student_id=? and resume_num=4";
		
		JSONArray jsonArray=new JSONArray();
		
		try {
		/*	PreparedStatement pstmt = connection.prepareStatement(CONTEST_SQL);
			pstmt.setInt(1, resume.getStudent_id());
			ResultSet rs=pstmt.executeQuery();*/
			jsonArray=executeAndGet(INTERN_SQL, resume.getStudent_id());
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return jsonArray;
	}
	
	public JSONArray select_project_resume(Resume resume) {
		String PROJECT_SQL="select name,title from resume where student_id=? and resume_num=5";
		
		JSONArray jsonArray=new JSONArray();
		
		try {
		/*	PreparedStatement pstmt = connection.prepareStatement(CONTEST_SQL);
			pstmt.setInt(1, resume.getStudent_id());
			ResultSet rs=pstmt.executeQuery();*/
			jsonArray=executeAndGet(PROJECT_SQL, resume.getStudent_id());
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return jsonArray;
	}
    
    
    
 
    
    public int getNextNum(){
		String SQL="SELECT USERNO FROM serial ORDER BY USERNO DESC limit 1";
		try{
			PreparedStatement pstmt=connection.prepareStatement(SQL);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()){
				return rs.getInt(1)+1;
			}
			return 1;//泥� 踰덉㎏ 寃뚯떆臾쇱씤 寃쎌슦
		}catch(Exception e){
			e.printStackTrace();
		}
		return -1;//�뜲�씠�꽣踰좎씠�뒪 �삤瑜�
		
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
		
    	return -1;//�뜲�씠�꽣踰좎씠�뒪 �삤瑜�
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

