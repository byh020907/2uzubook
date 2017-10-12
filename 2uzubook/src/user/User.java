package user;

public class User {

	private int adm_year;
	private int stu_id;
	private String id;
	private String password;
	private String intro;
	private String name;
	private char gender;
	private String major;
	private String email;
	private String profile_image_path;
	private String main_image_path;
	private String github_address;
	private String facebook_address;
	
	public User(String profile_image_path, String main_image_path, String github_address, String facebook_address) {
		super();
		this.profile_image_path = profile_image_path;
		this.main_image_path = main_image_path;
		this.github_address = github_address;
		this.facebook_address = facebook_address;
	}

	public String getProfile_image_path() {
		return profile_image_path;
	}

	public void setProfile_image_path(String profile_image_path) {
		this.profile_image_path = profile_image_path;
	}

	public String getMain_image_path() {
		return main_image_path;
	}

	public void setMain_image_path(String main_image_path) {
		this.main_image_path = main_image_path;
	}

	public String getGithub_address() {
		return github_address;
	}

	public void setGithub_address(String github_address) {
		this.github_address = github_address;
	}

	public String getFacebook_address() {
		return facebook_address;
	}

	public void setFacebook_address(String facebook_address) {
		this.facebook_address = facebook_address;
	}

	public int getAdm_year() {
		return adm_year;
	}

	public void setAdm_year(int adm_year) {
		this.adm_year = adm_year;
	}

	public int getStu_id() {
		return stu_id;
	}

	public void setStu_id(int stu_id) {
		this.stu_id = stu_id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
