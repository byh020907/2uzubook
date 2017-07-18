package user;

public class Account {
	private int student_id;
	private String id;
	private String password;
	private String name;
	private String gender;
	private String major;
	private String email;

	public Account(int student_id, String id, String password, String name, String gender, String major, String email) {
		this.student_id = student_id;
		this.id = id;
		this.password = password;
		this.name = name;
		this.gender = gender;
		this.major = major;
		this.email = email;
	}

	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	 
	 
}
