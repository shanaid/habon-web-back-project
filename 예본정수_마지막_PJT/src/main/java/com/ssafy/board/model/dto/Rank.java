package com.ssafy.board.model.dto;

public class Rank {
	private int id;
	private int worldcupId;
	private int eleId;
	private int point;	
	private int league;
	
	public Rank(int id, int worldcupId, int eleId, int point, int league) {
		super();
		this.id = id;
		this.worldcupId = worldcupId;
		this.eleId = eleId;
		this.point = point;
		this.league = league;
	}
	
	public int getId() {
		return id;
	}
	
	public int getWorldcupId() {
		return worldcupId;
	}
	
	public int getEleId() {
		return eleId;
	}
	
	public int getPoint() {
		return point;
	}
	
	public int getLeague() {
		return league;
	}
	
	@Override
	public String toString() {
		return "Rank [id=" + id + ", worldcupId=" + worldcupId + ", eleId=" + eleId + ", point=" + point + ", league="
				+ league + "]";
	}
	
	
	
}
