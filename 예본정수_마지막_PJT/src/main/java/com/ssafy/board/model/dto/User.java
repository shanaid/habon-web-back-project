package com.ssafy.board.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "유저 dto")
public class User {
	private String id; // 유저 id
	private String password; // 유저 password
	private String name; // 유저 이름
	private String email; // 유저 이메일
	private String nickname; // 유저 별명(닉네임)

	public User() {

	}

	public User(String id, String password, String name, String email, String nickname) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.email = email;
		this.nickname = nickname;
	}

	public User(String id, String password) {
		super();
		this.id = id;
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", password=" + password + ", name=" + name + ", email=" + email + ", nickname="
				+ nickname + "]";
	}

}