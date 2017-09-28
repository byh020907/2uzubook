package resume;

public class Award {
	private int id; // 데이터베이스에서 자동으로 증가하는 숫자 
	private String user; // 사용자 아이디
	private String name; // 상 이름
	private String ins; //주최측 정보
	private String date;
	private int keyword;
	
	public Award(String user, String name, String ins, String date, int keyword) {
		super();
		this.user = user;
		this.name = name;
		this.ins = ins;
		this.date = date;
		this.keyword = keyword;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIns() {
		return ins;
	}
	public void setIns(String ins) {
		this.ins = ins;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getKeyword() {
		return keyword;
	}
	public void setKeyword(int keyword) {
		this.keyword = keyword;
	}
	
	
	
	
}
