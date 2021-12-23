package com.exercise.vo;

public class Days {
	
	private String days_id;
	private String days;
	private String user_email;
	
	public Days() {}
	
	public Days(String days_id, String days, String user_email) {
		super();
		this.days_id = days_id;
		this.days = days;
		this.user_email = user_email;
	}
	
	public String getDays_id() {
		return days_id;
	}
	public void setDays_id(String days_id) {
		this.days_id = days_id;
	}
	public String getDays() {
		return days;
	}
	public void setDays(String days) {
		this.days = days;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	
	
	
	

}
