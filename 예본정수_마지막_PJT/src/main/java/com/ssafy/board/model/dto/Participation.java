package com.ssafy.board.model.dto;

public class Participation {

	private int id;
	private String userId;
	private int worldcupId;
	private int participationCount;
	public Participation(int id, String userId, int worldcupId, int participationCount) {
		super();
		this.id = id;
		this.userId = userId;
		this.worldcupId = worldcupId;
		this.participationCount = participationCount;
	}
	
	
	public Participation() {
		super();
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getWorldcupId() {
		return worldcupId;
	}
	public void setWorldcupId(int worldcupId) {
		this.worldcupId = worldcupId;
	}
	public int getParticipationCount() {
		return participationCount;
	}
	public void setParticipationCount(int participationCount) {
		this.participationCount = participationCount;
	}
	@Override
	public String toString() {
		return "Participation [id=" + id + ", userId=" + userId + ", worldcupId=" + worldcupId + ", participationCount="
				+ participationCount + "]";
	}
	
	
	
}
