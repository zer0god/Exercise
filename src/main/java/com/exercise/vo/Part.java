package com.exercise.vo;

public class Part {
	
	private String part_id;
	private String part;
	private String part_sporting;
	
	public Part() {}

	public Part(String part_id, String part, String part_sporting) {
		super();
		this.part_id = part_id;
		this.part = part;
		this.part_sporting = part_sporting;
	}

	public String getPart_id() {
		return part_id;
	}

	public void setPart_id(String part_id) {
		this.part_id = part_id;
	}

	public String getPart() {
		return part;
	}

	public void setPart(String part) {
		this.part = part;
	}

	public String getPart_sporting() {
		return part_sporting;
	}

	public void setPart_sporting(String part_sporting) {
		this.part_sporting = part_sporting;
	}

}
