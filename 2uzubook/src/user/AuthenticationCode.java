package user;

public class AuthenticationCode {
	private int id;
	private String user_email;
	private int code;
	
	public AuthenticationCode(String user_email, int code) {
		super();
		this.user_email = user_email;
		this.code = code;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}

	
}
