package user;

public class Hobby {
	private int student_id;
	private String hobbyName;

	public Hobby(int student_id, String hobbyName) {
		this.student_id = student_id;
		this.hobbyName = hobbyName;
	}

	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public String getHobbyName() {
		return hobbyName;
	}

	public void setHobbyName(String hobbyName) {
		this.hobbyName = hobbyName;
	}

}
