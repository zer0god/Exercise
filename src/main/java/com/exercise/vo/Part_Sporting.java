package com.exercise.vo;

public class Part_Sporting {
	
	private String part_sporting_id;
	private String part_sporting;
	private String days_id;
	
	public Part_Sporting() {}

	public Part_Sporting(String part_sporting_id, String part_sporting, String days_id) {
		super();
		this.part_sporting_id = part_sporting_id;
		this.part_sporting = part_sporting;
		this.days_id = days_id;
	}

	public String getPart_sporting_id() {
		return part_sporting_id;
	}

	public void setPart_sporting_id(String part_sporting_id) {
		this.part_sporting_id = part_sporting_id;
	}

	public String getPart_sporting() {
		return part_sporting;
	}

	public void setPart_sporting(String part_sporting) {
		this.part_sporting = part_sporting;
	}

	public String getDays_id() {
		return days_id;
	}

	public void setDays_id(String days_id) {
		this.days_id = days_id;
	}
	
	
	
	

	
	
	
	
}
