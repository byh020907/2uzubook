package user;

public class Circle {
	private int student_id;
	private String circleName;
	private String circleContent;

	public Circle(int student_id, String circleName, String circleContent) {
		this.student_id = student_id;
		this.circleName = circleName;
		this.circleContent = circleContent;
	}

	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public String getCircleName() {
		return circleName;
	}

	public void setCircleName(String circleName) {
		this.circleName = circleName;
	}

	public String getCircleContent() {
		return circleContent;
	}
	public void setCircleContent(String circleContent) {
		this.circleContent = circleContent;
	}
}
