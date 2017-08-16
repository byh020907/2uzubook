package user;

public class Reading {
	private int student_id;
	private String readingName;

	public Reading(int student_id, String readingName, String readingDate) {
		this.student_id = student_id;
		this.readingName = readingName;
		this.readingDate = readingDate;
	}

	private String readingDate;

	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public String getReadingName() {
		return readingName;
	}

	public void setReadingName(String readingName) {
		this.readingName = readingName;
	}
	public String getReadingDate() {
		return readingDate;
	}
	public void setReadingDate(String readingDate) {
		this.readingDate = readingDate;
	}
}
