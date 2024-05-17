package com.ssafy.board.model.dto;

public class Worldcup {
	private int id; // 월드컵의 고유 id
	private String eleCategory; // 요소의 주 카테고리
	private String subCategory; // 요소의 부 카테고리
	private int league; // 요소의 1부,2부 리그
	public Worldcup(int id, String eleCategory, String subCategory, int league) {
		super();
		this.id = id;
		this.eleCategory = eleCategory;
		this.subCategory = subCategory;
		this.league = league;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEleCategory() {
		return eleCategory;
	}
	public void setEleCategory(String eleCategory) {
		this.eleCategory = eleCategory;
	}
	public String getSubCategory() {
		return subCategory;
	}
	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}
	public int getLeague() {
		return league;
	}
	public void setLeague(int league) {
		this.league = league;
	}
	@Override
	public String toString() {
		return "Worldcup [id=" + id + ", eleCategory=" + eleCategory + ", subCategory=" + subCategory + ", league="
				+ league + "]";
	}
	
	
}
