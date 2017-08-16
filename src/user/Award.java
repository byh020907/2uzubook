package user;

public class Award {
	private int student_id;
	private String awardName;
	private String award;
	private String awardDate;

	public Award(int student_id, String awardName, String award, String awardDate) {
		this.student_id = student_id;
		this.awardName = awardName;
		this.award = award;
		this.awardDate = awardDate;
	}

	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public String getAwardName() {
		return awardName;
	}
	public void setAwardName(String awardName) {
		this.awardName = awardName;
	}
	public String getAward() {
		return award;
	}
	public void setAward(String award) {
		this.award = award;
	}
	public String getAwardDate() {
		return awardDate;
	}
	public void setAwardDate(String awardDate) {
		this.awardDate = awardDate;
	}
	
}
