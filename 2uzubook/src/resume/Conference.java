package resume;

public class Conference {
	private int id;
	private String user;
	private String name;
	private String date;
	private int keyword;

	public Conference(String user, String name, String date, int keyword) {
		super();
		this.user = user;
		this.name = name;
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
