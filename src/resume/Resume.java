package resume;

public class Resume {
	private int student_id;
	private String resumeName;
	private String resumeContent;
	private String resumeStartDate;
	private String resumeFinishDate;
	private int resume_category;
	private int keyword_category;
	
	public Resume(int student_id, String resumeName, String resumeContent, String resumeStartDate, int resume_category,
			int keyword_category) {
		this.student_id = student_id;
		this.resumeName = resumeName;
		this.resumeContent = resumeContent;
		this.resumeStartDate = resumeStartDate;
		this.resume_category = resume_category;
		this.keyword_category = keyword_category;
	}

	
	public Resume(int student_id, String resumeName, String resumeContent, 
			String resumeStartDate,String resumeFinishDate, int resume_category,
			int keyword_category) {
		this.student_id = student_id;
		this.resumeName = resumeName;
		this.resumeContent = resumeContent;
		this.resumeStartDate=resumeStartDate;
		this.resumeFinishDate=resumeFinishDate;
		this.resume_category = resume_category;
		this.keyword_category = keyword_category;
	}
	
	public String getResumeStartDate() {
		return resumeStartDate;
	}
	public void setResumeStartDate(String resumeStartDate) {
		this.resumeStartDate = resumeStartDate;
	}
	public String getResumeFinishDate() {
		return resumeFinishDate;
	}
	public void setResumeFinishDate(String resumeFinishDate) {
		this.resumeFinishDate = resumeFinishDate;
	}
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	public String getResumeName() {
		return resumeName;
	}
	public void setResumeName(String resumeName) {
		this.resumeName = resumeName;
	}
	public String getResumeContent() {
		return resumeContent;
	}
	public void setResumeContent(String resumeContent) {
		this.resumeContent = resumeContent;
	}

	public int getResume_category() {
		return resume_category;
	}
	public void setResume_category(int resume_category) {
		this.resume_category = resume_category;
	}
	public int getKeyword_category() {
		return keyword_category;
	}
	public void setKeyword_category(int keyword_category) {
		this.keyword_category = keyword_category;
	}

	
}
