package com.ssafy.board.model.dto;

public class Worldcup_element {
	private int id; // 중간 연결 테이블의 고유 id
	private int worldcupId; // 월드컵의 고유 id
	private int eleId; // 요소의 고유 id
	
	public Worldcup_element(int id, int worldcupId, int eleId) {
		super();
		this.id = id;
		this.worldcupId = worldcupId;
		this.eleId = eleId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getWorldcupId() {
		return worldcupId;
	}

	public void setWorldcupId(int worldcupId) {
		this.worldcupId = worldcupId;
	}

	public int getEleId() {
		return eleId;
	}

	public void setEleId(int eleId) {
		this.eleId = eleId;
	}

	@Override
	public String toString() {
		return "Worldcup_element [id=" + id + ", worldcupId=" + worldcupId + ", eleId=" + eleId + "]";
	}
}
