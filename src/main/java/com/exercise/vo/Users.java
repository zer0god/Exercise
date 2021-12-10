package com.exercise.vo;

public class Users {
	
	private String user_email;
	private String user_name;
	private String user_pw;
	private String user_gender;
	private String user_phone;

	public Users() {}

	public Users(String user_email, String user_name, String user_pw, String user_gender, String user_phone) {
		super();
		this.user_email = user_email;
		this.user_name = user_name;
		this.user_pw = user_pw;
		this.user_gender = user_gender;
		this.user_phone = user_phone;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_pw() {
		return user_pw;
	}

	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}

	public String getUser_gender() {
		return user_gender;
	}

	public void setUser_gender(String user_gender) {
		this.user_gender = user_gender;
	}

	public String getUser_phone() {
		return user_phone;
	}

	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
	
	
	
	

}
