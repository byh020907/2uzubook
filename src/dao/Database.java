package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import user.Account;



public class Database {
	/*
	 * 占쎄퐣甕곤옙 占쎄땀占쎌벥 占쎈쑓占쎌뵠占쎄숲甕곗쥙�뵠占쎈뮞�몴占� 占쎈뼄�뙴�뫀�뮉 占쎈뼓疫뀐옙占쎈꽑 揶쏆빘猿� 
	 */
	
	private Connection connection;
	private static Database instance;
	
    private Database() {
    	// Driver 揶쏆빘猿� 占쎈짗占쎌읅 嚥≪뮆逾� 獄쏉옙 connection 占쎌뵥占쎈뮞占쎄쉘占쎈뮞 �룯�뜃由곤옙�넅
    	try {
    		// 揶쏆빘猿� 占쎄문占쎄쉐 占쎈뻻 占쎄퐣甕곌쑴�벥 占쎈쑓占쎌뵠占쎄숲甕곗쥙�뵠占쎈뮞占쏙옙 占쎈염野껓옙 
    		Class.forName("com.mysql.jdbc.Driver");    // Driver 占쎄깻占쎌삋占쎈뮞�몴占� 占쎈짗占쎌읅 嚥≪뮆逾� 獄쏉옙 占쎄문占쎄쉐
    		connection = DriverManager.getConnection("jdbc:mysql://10.156.145.112/", "root", "1022");    // 占쎄퐣甕곤옙 占쎄땀占쎌벥 占쎈쑓占쎌뵠占쎄숲甕곗쥙�뵠占쎈뮞占쏙옙占쎌벥 �뚣끇苑뽳옙�� 占쎄문占쎄쉐
    	} catch (ClassNotFoundException | SQLException e) {
    		e.printStackTrace();
    	} 
    }
    
    public static Database getInstance() {
    	if(instance==null)
    		instance=new Database();
    	return instance;
    }
    
	public int input_resume(Account account) {
		String SQL = "insert into  values(?,?,?,?,?,?,?)";
		
		try {
				PreparedStatement pstmt = connection.prepareStatement(SQL);
				pstmt.setInt(1, account.getStudnet_id());
				pstmt.setString(2, account.getId());
				pstmt.setString(3, account.getPassword());
				pstmt.setString(4, account.getIntro());
				pstmt.setString(5, account.getName());
				pstmt.setString(6, account.getGender());
				pstmt.setString(7, account.getEmail());
				return pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	  
    public int login(String id,String password){
		String sql="select password from account where id= ?";
		
		try{
			PreparedStatement pstmt=connection.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()){
				if(rs.getString(1).equals(password)){
					return 1; //占쎄쉐�⑨옙
				}else{
					return 0; //嚥≪뮄�젃占쎌뵥 占쎈뼄占쎈솭(�뜮袁⑨옙 甕곕뜇�깈揶쏉옙 占쎈뼄�뵳占�)
				}
			}
			return -1; //嚥≪뮄�젃占쎌뵥 占쎈뼄占쎈솭(占쎈퉸占쎈뼣 id 揶쏉옙占쎈씨占쎌벉)
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return 0;
	}
	
	
    
  
 
}

