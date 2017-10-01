package etc;

public class Volunteer {
	private int id;
	private String user;
	private String name;
	private String ins;
	private String startTime;
	private String endTime;
	private int keyword;
	
	
	public Volunteer(String user, String name, String ins, String startTime, String endTime, int keyword) {
		super();
		this.user = user;
		this.name = name;
		this.ins = ins;
		this.startTime = startTime;
		this.endTime = endTime;
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
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public int getKeyword() {
		return keyword;
	}
	public void setKeyword(int keyword) {
		this.keyword = keyword;
	}

}
