package user;

public class Project {
	private int student_id;
	private String projectName;
	private String projectStartDate;
	private String projecfinishDate;
	private String projectContent;
	
	public Project(int student_id, String projectName, String projectStartDate, String projecfinishDate,
			String projectContent) {
		this.student_id = student_id;
		this.projectName = projectName;
		this.projectStartDate = projectStartDate;
		this.projecfinishDate = projecfinishDate;
		this.projectContent = projectContent;
	}
	
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getProjectStartDate() {
		return projectStartDate;
	}
	public void setProjectStartDate(String projectStartDate) {
		this.projectStartDate = projectStartDate;
	}
	public String getProjecfinishDate() {
		return projecfinishDate;
	}
	public void setProjecfinishDate(String projecfinishDate) {
		this.projecfinishDate = projecfinishDate;
	}
	public String getProjectContent() {
		return projectContent;
	}
	public void setProjectContent(String projectContent) {
		this.projectContent = projectContent;
	}
	
}
