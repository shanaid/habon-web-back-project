package com.ssafy.board.model.dto;

public class Rank {
	private int id;
	private int worldcupId;
	private int eleId;
	private int point;	
	private int league;
	private int accPoint;
	
	public Rank(int id, int worldcupId, int eleId, int point, int league, int accPoint) {
		super();
		this.id = id;
		this.worldcupId = worldcupId;
		this.eleId = eleId;
		this.point = point;
		this.league = league;
		this.accPoint = accPoint;
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
	public int getAccPoint() {
		return accPoint;
	}
	public void setAccPoint(int accPoint) {
		this.accPoint = accPoint;
	}
	@Override
	public String toString() {
		return "Rank [id=" + id + ", worldcupId=" + worldcupId + ", eleId=" + eleId + ", point=" + point + ", league="
				+ league + ", accPoint=" + accPoint + "]";
	}
	
	
	
	
	
}
