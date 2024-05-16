package com.ssafy.board.model.dto;

public class Rank {
	private int id;
	private int bridgeId;
	private int point;
	private int league;
	
	public Rank(int id, int bridgeId, int point, int league) {
		super();
		this.id = id;
		this.bridgeId = bridgeId;
		this.point = point;
		this.league = league;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBridgeId() {
		return bridgeId;
	}

	public void setBridgeId(int bridgeId) {
		this.bridgeId = bridgeId;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public int getLeague() {
		return league;
	}

	public void setLeague(int league) {
		this.league = league;
	}

	@Override
	public String toString() {
		return "Rank [id=" + id + ", bridgeId=" + bridgeId + ", point=" + point + ", league=" + league + "]";
	}
}
