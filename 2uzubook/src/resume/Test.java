package resume;

public class Test {
	private int id;
	private String user;
	private String name;
	private int score;
	private String date;
	private int keyword;

	public Test(String user, String name, int score, String date, int keyword) {
		super();
		this.user = user;
		this.name = name;
		this.score = score;
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
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
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
