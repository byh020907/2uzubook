package resume;

public class Resume {
	int student_id;
	String resumeName;
	String resumeContent;
	String resumeDate;
	int resume_category;
	int keyword_category;

	
	public Resume(int student_id, String resumeName, String resumeContent, 
			String resumeDate, int resume_category,
			int keyword_category) {
		this.student_id = student_id;
		this.resumeName = resumeName;
		this.resumeContent = resumeContent;
		this.resumeDate = resumeDate;
		this.resume_category = resume_category;
		this.keyword_category = keyword_category;
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
	public String getResumeDate() {
		return resumeDate;
	}
	public void setResumeDate(String resumeDate) {
		this.resumeDate = resumeDate;
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
