package com.exercise.vo;

public class Part_Data {
	
	private String part_data_id;
	private int part_weghit;
	private int part_sets;
	private int part_number;
	private int part_heart;
	private int part_kcal;
	private int part_time;
	private String part_sporting_id;
	private String part_id;
	
	public Part_Data() {}

	public Part_Data(String part_data_id, int part_weghit, int part_sets, int part_number, int part_heart,
			int part_kcal, int part_time, String part_sporting_id, String part_id) {
		super();
		this.part_data_id = part_data_id;
		this.part_weghit = part_weghit;
		this.part_sets = part_sets;
		this.part_number = part_number;
		this.part_heart = part_heart;
		this.part_kcal = part_kcal;
		this.part_time = part_time;
		this.part_sporting_id = part_sporting_id;
		this.part_id = part_id;
	}

	public String getPart_data_id() {
		return part_data_id;
	}

	public void setPart_data_id(String part_data_id) {
		this.part_data_id = part_data_id;
	}

	public int getPart_weghit() {
		return part_weghit;
	}

	public void setPart_weghit(int part_weghit) {
		this.part_weghit = part_weghit;
	}

	public int getPart_sets() {
		return part_sets;
	}

	public void setPart_sets(int part_sets) {
		this.part_sets = part_sets;
	}

	public int getPart_number() {
		return part_number;
	}

	public void setPart_number(int part_number) {
		this.part_number = part_number;
	}

	public int getPart_heart() {
		return part_heart;
	}

	public void setPart_heart(int part_heart) {
		this.part_heart = part_heart;
	}

	public int getPart_kcal() {
		return part_kcal;
	}

	public void setPart_kcal(int part_kcal) {
		this.part_kcal = part_kcal;
	}

	public int getPart_time() {
		return part_time;
	}

	public void setPart_time(int part_time) {
		this.part_time = part_time;
	}

	public String getPart_sporting_id() {
		return part_sporting_id;
	}

	public void setPart_sporting_id(String part_sporting_id) {
		this.part_sporting_id = part_sporting_id;
	}

	public String getPart_id() {
		return part_id;
	}

	public void setPart_id(String part_id) {
		this.part_id = part_id;
	}
	
}
