package resume;

public class Project {
	private int id;
	private String user;
	private String name;
	private String desc;
	private String startDate;
	private String endDate;
	private int keyword;
	
	public Project(String user, String name, String desc, String startDate, String endDate, int keyword) {
		super();
		this.user = user;
		this.name = name;
		this.desc = desc;
		this.startDate = startDate;
		this.endDate = endDate;
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
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public int getKeyword() {
		return keyword;
	}
	public void setKeyword(int keyword) {
		this.keyword = keyword;
	}
	
	
	
}
