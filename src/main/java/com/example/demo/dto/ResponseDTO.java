package com.example.demo.dto;

public class ResponseDTO {

	private String createdAt;
	private String name;
	private String avatar;
	private int id;

	public ResponseDTO() {

	}

	public ResponseDTO(String createdAt, String name, String avatar, int id) {
		super();
		this.createdAt = createdAt;
		this.name = name;
		this.avatar = avatar;
		this.id = id;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
