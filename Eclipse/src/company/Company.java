package company;

public class Company {
	private int id;
	private String name;
	private String desc;
	private String key;
	private int keyword;

	public Company(String name, String desc, String key, int keyword) {
		super();
		this.name = name;
		this.desc = desc;
		this.key = key;
		this.keyword = keyword;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public int getKeyword() {
		return keyword;
	}
	public void setKeyword(int keyword) {
		this.keyword = keyword;
	}
	
	
}
