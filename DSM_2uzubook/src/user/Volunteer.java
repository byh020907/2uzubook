package user;

public class Volunteer {
	private int student_id;
	private String volunteerName;
	private String volunteerDate;

	public Volunteer(int student_id, String volunteerName, String volunteerDate) {
		this.student_id = student_id;
		this.volunteerName = volunteerName;
		this.volunteerDate = volunteerDate;
	}

	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public String getVolunteerName() {
		return volunteerName;
	}
	public void setVolunteerName(String volunteerName) {
		this.volunteerName = volunteerName;
	}
	public String getVolunteerDate() {
		return volunteerDate;
	}
	public void setVolunteerDate(String volunteerDate) {
		this.volunteerDate = volunteerDate;
	}
}
