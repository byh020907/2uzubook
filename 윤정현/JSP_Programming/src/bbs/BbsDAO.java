package bbs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.sun.org.apache.regexp.internal.recompile;

import user.UserDAO;

public class BbsDAO {
	private static final String url = "jdbc:mysql://localhost:3306/BBS";
	private static final String id = "root";
	private static final String password = "1022";
	private static BbsDAO bDao;
	private static Connection conn;
	private ResultSet rs;

	public BbsDAO() {
		// TODO Auto-generated constructor stub
	}

	public static BbsDAO getInstance() {
		try {
			if (bDao == null) {
				bDao = new BbsDAO();
			} else {
				System.out.println("객체가 이미생성됌 ");
			}
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, id, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bDao;
	}

	public String getData() {
		String sql = "select now()";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ""; // db오류
	}

	public int getNext() {
		String sql = "select bbsID from bbs order by bbsID desc";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getInt(1) + 1;
			}
			return 1; // ù���� �Խù��ΰ��
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1; // �����ͺ��̽�����;
	}

	public int write(String bbsTitle, String userID, String bbsContent) {
		String sql = "insert into bbs values (?,?,?,?,?,?)";

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, getNext()); // �����°Խñ۹�ȣ
			pstmt.setString(2, bbsTitle);
			pstmt.setString(3, userID);
			pstmt.setString(4, getData());
			pstmt.setString(5, bbsContent);
			pstmt.setInt(6, 1);
			return pstmt.executeUpdate(); // 0�̻��� ����� ����
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1; // �����ͺ��̽�����;
	}

	public ArrayList<Bbs> getList(int pageNumber) {
		String sql = "select * from bbs where bbsID < ? and bbsAvailable=1 order by bbsID desc limit 10";
		ArrayList<Bbs> list = new ArrayList<Bbs>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, getNext() - (pageNumber - 1) * 10); // 다음에 쓸일번호가 6이면
																// 지금 5개의 글이있음
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Bbs bbs = new Bbs();
				bbs.setBbsID(rs.getInt(1));
				bbs.setBbsTitle(rs.getString(2));
				bbs.setUserID(rs.getString(3));
				bbs.setBbsData(rs.getString(4));
				bbs.setBbsContent(rs.getString(5));
				bbs.setBbsAvailable(rs.getInt(6));
				list.add(bbs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public boolean nextPage(int pageNumber) {
		String sql = "select * from bbs where bbsID < ? And bbsAvailable=1";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, getNext() - (pageNumber - 1) * 10); // 다음에 쓸일번호가 6이면
																// 지금 5개의 글이있음
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	public Bbs getBbs(int bbsID) {
		String sql = "select * from bbs where bbsID = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bbsID);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				Bbs bbs = new Bbs();
				bbs.setBbsID(rs.getInt(1));
				bbs.setBbsTitle(rs.getString(2));
				bbs.setUserID(rs.getString(3));
				bbs.setBbsData(rs.getString(4));
				bbs.setBbsContent(rs.getString(5));
				bbs.setBbsAvailable(rs.getInt(6));
				return bbs;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public int update(int bbsID, String bbsTitle, String bbsContent) {
		String sql = "update bbs set bbsTitle=?,bbsContent = ? where bbsID=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bbsTitle); //
			pstmt.setString(2, bbsContent); //
			pstmt.setInt(3, bbsID); //
			return pstmt.executeUpdate(); // 0�̻��� ����� ����
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1; // �����ͺ��̽�����;
	}

	public int delete(int bbsID) {
		String sql = "update bbs set bbsAvailable=0 where bbsID=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bbsID); //
			return pstmt.executeUpdate(); // 0�̻��� ����� ����
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1; // 데이터베이스오류;
	}
}
