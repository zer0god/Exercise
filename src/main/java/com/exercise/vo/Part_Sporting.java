package com.exercise.vo;

import java.time.LocalDate;

public class Part_Sporting {
	
	private String part_sporting_id;
	private LocalDate days;
	private String user_email;
	
	public Part_Sporting() {}

	public Part_Sporting(String part_sporting_id, LocalDate days, String user_email) {
		super();
		this.part_sporting_id = part_sporting_id;
		this.days = days;
		this.user_email = user_email;
	}

	public String getPart_sporting_id() {
		return part_sporting_id;
	}

	public void setPart_sporting_id(String part_sporting_id) {
		this.part_sporting_id = part_sporting_id;
	}

	public LocalDate getDays() {
		return days;
	}

	public void setDays(LocalDate days) {
		this.days = days;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	
	
	
	
}
