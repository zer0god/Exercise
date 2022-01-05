package com.exercise.vo;

public class Body {
	
	private String body_id;
	private String body_date;
	private int    body_height;
	private int    body_weghit;
	private int    body_muscle;
	private int    body_fat;
	private int    body_percentfat;
	private int    body_bmi;
	
	public Body() {}

	public Body(String body_id, String body_date, int body_height, int body_weghit, int body_muscle, int body_fat,
			int body_percentfat, int body_bmi) {
		super();
		this.body_id = body_id;
		this.body_date = body_date;
		this.body_height = body_height;
		this.body_weghit = body_weghit;
		this.body_muscle = body_muscle;
		this.body_fat = body_fat;
		this.body_percentfat = body_percentfat;
		this.body_bmi = body_bmi;
	}

	public String getBody_id() {
		return body_id;
	}

	public void setBody_id(String body_id) {
		this.body_id = body_id;
	}

	public String getBody_date() {
		return body_date;
	}

	public void setBody_date(String body_date) {
		this.body_date = body_date;
	}

	public int getBody_height() {
		return body_height;
	}

	public void setBody_height(int body_height) {
		this.body_height = body_height;
	}

	public int getBody_weghit() {
		return body_weghit;
	}

	public void setBody_weghit(int body_weghit) {
		this.body_weghit = body_weghit;
	}

	public int getBody_muscle() {
		return body_muscle;
	}

	public void setBody_muscle(int body_muscle) {
		this.body_muscle = body_muscle;
	}

	public int getBody_fat() {
		return body_fat;
	}

	public void setBody_fat(int body_fat) {
		this.body_fat = body_fat;
	}

	public int getBody_percentfat() {
		return body_percentfat;
	}

	public void setBody_percentfat(int body_percentfat) {
		this.body_percentfat = body_percentfat;
	}

	public int getBody_bmi() {
		return body_bmi;
	}

	public void setBody_bmi(int body_bmi) {
		this.body_bmi = body_bmi;
	}
	
}
