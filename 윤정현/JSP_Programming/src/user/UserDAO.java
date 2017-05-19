package user;

import java.sql.*;

import com.sun.org.apache.regexp.internal.recompile;

public class UserDAO {
	
	private static final String url="jdbc:mysql://localhost:3306/bbs";
	private static final String id="root";
	private static final String password="1022";
	private static UserDAO uDao;
	private static Connection conn;
	
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public static UserDAO getInstance(){
		try{
			if(uDao==null){
				uDao=new UserDAO();
				Class.forName("com.mysql.jdbc.Driver");
				conn=DriverManager.getConnection(url,id,password);
			}else {
				System.out.println("��ü�� �̹� ������� ����");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return uDao;
	}
	
	public int login(String userID,String userPassword){
		String sql="select userPassword from user where userID= ?";
		try{
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, userID);
			rs=pstmt.executeQuery(); //����� rs ���۷��� ������ ����
			if(rs.next()){
				if(rs.getString(1).equals(userPassword)){
					return 1; //�α��� ����
				}else{
					return 0; //��� ����ġ
				}
			}
			return -1; //���̵� ����
		}catch (Exception e) {
			e.printStackTrace();
		}
		return -2; //db����
	}
	
	public int join(User user){
		String sql="insert into user values (?,?,?,?,?)";
		try{
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, user.getUserID());
			pstmt.setString(2, user.getUserPassword());
			pstmt.setString(3, user.getUserName());
			pstmt.setString(4, user.getUserGender());
			pstmt.setString(5, user.getUserEmail());
			return pstmt.executeUpdate(); //insert ��� 0�̻����� ��ȯ�̵�
		}catch (Exception e) {
			e.printStackTrace();
		}
		return -1;//db����
	}
	
}

