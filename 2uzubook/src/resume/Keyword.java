package resume;

public class Keyword {
	private int id;
	private String name;
	

	//키워드 넣을때는 id값은 자동으로 데이터베이스 내부애서 1 증가함으로 String 값만있으면 됌
	public Keyword(String name) {
		this.name=name;
	}
	
	
	public Keyword(int id, String name) {
		super();
		this.id = id;
		this.name = name;
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
}
