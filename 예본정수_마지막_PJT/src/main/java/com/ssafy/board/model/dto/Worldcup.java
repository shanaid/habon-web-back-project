package com.ssafy.board.model.dto;

public class Worldcup {
	private int id; // 월드컵의 고유 id
	private String ele_category; // 요소의 주 카테고리
	private String sub_category; // 요소의 부 카테고리
	private int league; // 요소의 1부,2부 리그
	
	public Worldcup(int id, String ele_category, String sub_category, int league) {
		super();
		this.id = id;
		this.ele_category = ele_category;
		this.sub_category = sub_category;
		this.league = league;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEle_category() {
		return ele_category;
	}

	public void setEle_category(String ele_category) {
		this.ele_category = ele_category;
	}

	public String getSub_category() {
		return sub_category;
	}

	public void setSub_category(String sub_category) {
		this.sub_category = sub_category;
	}

	public int getLeague() {
		return league;
	}

	public void setLeague(int league) {
		this.league = league;
	}

	@Override
	public String toString() {
		return "Worldcup [id=" + id + ", ele_category=" + ele_category + ", sub_category=" + sub_category + ", league="
				+ league + "]";
	}
}
