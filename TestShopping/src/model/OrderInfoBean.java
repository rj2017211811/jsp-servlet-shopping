package model;

import java.util.Date;

public class OrderInfoBean{
	private int ordersId;
	private int userId;
	private String username;
	private String truename;
	private String password;
	private String email;
	private String phone;
	private String address;
	private String  postcode;
	private int grade;
	private java.util.Date orderDate;
	private byte isPayed ;
	private String payMode;
	private float totalPrice;
	public int getOrdersId() {
		return ordersId;
	}
	public void setOrdersId(int ordersId) {
		this.ordersId = ordersId;
	}
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
	public java.util.Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(java.util.Date orderDate) {
		this.orderDate = orderDate;
	}
	public byte getIsPayed() {
		return isPayed;
	}
	public void setIsPayed(byte isPayed) {
		this.isPayed = isPayed;
	}
	public String getPayMode() {
		return payMode;
	}
	public void setPayMode(String payMode) {
		this.payMode = payMode;
	}
	public float getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}
	public OrderInfoBean( String username, String truename,  String email,
			String phone, String address, String postcode, int grade, Date orderDate, 
			float totalPrice) {
		super();
		this.username = username;
		this.truename = truename;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.postcode = postcode;
		this.grade = grade;
		this.orderDate = orderDate;
		this.totalPrice = totalPrice;
	}
	public OrderInfoBean(int ordersId, String username, String truename,  String email,
			String phone, String address, String postcode, int grade, Date orderDate, 
			float totalPrice) {
		super();
		this.ordersId=ordersId;
		this.username = username;
		this.truename = truename;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.postcode = postcode;
		this.grade = grade;
		this.orderDate = orderDate;
		this.totalPrice = totalPrice;
	}
	
	
	
	
	
	
}