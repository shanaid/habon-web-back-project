package com.ssafy.board.model.dto;

public class Elements {
	private int id; // 요소의 고유 id
	private String category; // 요소의 주 카테고리
	private String subCategory; // 요소의 부 카테고리
	private int league; // 1부,2부 리그(TINYINT는 int로 받아야하는가?)
	private String name; // 요소의 이름
	private String img; // 요소의 이미지 url
	private String information; // 요소의 (간단)정보
	
	public Elements(int id, String category, String subCategory, int league, String name, String img,
			String information) {
		super();
		this.id = id;
		this.category = category;
		this.subCategory = subCategory;
		this.league = league;
		this.name = name;
		this.img = img;
		this.information = information;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
	}

	@Override
	public String toString() {
		return "elements [id=" + id + ", category=" + category + ", subCategory=" + subCategory + ", league=" + league
				+ ", name=" + name + ", img=" + img + ", information=" + information + "]";
	}
}
