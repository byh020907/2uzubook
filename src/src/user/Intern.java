package user;

public class Intern {
	private int student_id;
	private String companyName;
	private String companyWorkContent;
	private String companyDate;
	
	
	public Intern(int student_id, String companyName, String companyWorkContent, String companyDate) {
		this.student_id = student_id;
		this.companyName = companyName;
		this.companyWorkContent = companyWorkContent;
		this.companyDate = companyDate;
	}
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyWorkContent() {
		return companyWorkContent;
	}
	public void setCompanyWorkContent(String companyWorkContent) {
		this.companyWorkContent = companyWorkContent;
	}
	public String getCompanyDate() {
		return companyDate;
	}
	public void setCompanyDate(String companyDate) {
		this.companyDate = companyDate;
	}
}
