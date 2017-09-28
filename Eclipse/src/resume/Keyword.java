package resume;

public class Keyword {
	private int id;
	private String name;
	

	//Ű���� �������� id���� �ڵ����� �����ͺ��̽� ���ξּ� 1 ���������� String ���������� ��
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
