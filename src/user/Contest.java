package user;

public class Contest {

	private int student_id;
	private String contestName;
	private String contestDate;

	public Contest(int student_id, String contestName, String contestDate) {
		this.student_id = student_id;
		this.contestName = contestName;
		this.contestDate = contestDate;
	}

	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public String getContestName() {
		return contestName;
	}

	public void setContestName(String contestName) {
		this.contestName = contestName;
	}

	public String getContestDate() {
		return contestDate;
	}
	public void setContestDate(String contestDate) {
		this.contestDate = contestDate;
	}
	
}
