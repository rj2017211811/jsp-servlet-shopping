package model;
public class UserBean{
	private int userId;
	private String username;
	private String truename;
	private String password;
	private String email;
	private String phone;
	private String address;
	private String  postcode;
	private int grade;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getTruename() {
		return truename;
	}
	public void setTruename(String truename) {
		this.truename = truename;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public UserBean(int userId, String username, String truename, String password, String email, String phone,
			String address, String postcode, int grade) {
		super();
		this.userId = userId;
		this.username = username;
		this.truename = truename;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.postcode = postcode;
		this.grade = grade;
	}
	public UserBean( String username, String truename, String password, String email, String phone,
			String address, String postcode) {
		super();

		this.username = username;
		this.truename = truename;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.postcode = postcode;
		
	}
	public UserBean( String username, String truename, String password, String email, String phone,
			String address, String postcode, int grade) {
		super();

		this.username = username;
		this.truename = truename;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.postcode = postcode;
		this.grade = grade;
		
	}
	public UserBean( String username, String password) {
		super();

		this.username = username;
	
		this.password = password;
		
	}
	public UserBean( String username) {
		super();

		this.username = username;
	
		
	}

	
	
}