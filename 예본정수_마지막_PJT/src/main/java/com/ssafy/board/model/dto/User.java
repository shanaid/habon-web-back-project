package com.ssafy.board.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "유저 dto")
public class User {
	private String id; // 유저 id
	private String password; // 유저 password
	private String name; // 유저 이름
	private String email; // 유저 이메일
	private String nickname; // 유저 별명(닉네임)
	private int age; // 유저 나이
	private String img; // 이미지 주소
	private String sport; // 선호하는 스포츠
	private String team; // 선호하는 팀
	private String player; // 선호하는 선수
	private int point; // 유저 경험치??

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

	public User(String id, String password, String name, String email, String nickname, int age, String img,
			String sport, String team, String player, int point) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.email = email;
		this.nickname = nickname;
		this.age = age;
		this.img = img;
		this.sport = sport;
		this.team = team;
		this.player = player;
		this.point = point;
	}
	
	public User(String id, String password, String name, String email, String nickname, int age, String img,
			String sport, String team, String player) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.email = email;
		this.nickname = nickname;
		this.age = age;
		this.img = img;
		this.sport = sport;
		this.team = team;
		this.player = player;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getSport() {
		return sport;
	}

	public void setSport(String sport) {
		this.sport = sport;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getPlayer() {
		return player;
	}

	public void setPlayer(String player) {
		this.player = player;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", password=" + password + ", name=" + name + ", email=" + email + ", nickname="
				+ nickname + ", age=" + age + ", img=" + img + ", sport=" + sport + ", team=" + team + ", player="
				+ player + ", point=" + point + "]";
	}
}