package com.ssafy.board.model.dto;

public class Recommendation {
	private int id;
	private String userId;
	private String contentType;
	private int contentId;
	
	public Recommendation(int id, String userId, String contentType, int contentId) {
		super();
		this.id = id;
		this.userId = userId;
		this.contentType = contentType;
		this.contentId = contentId;
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
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public int getContentId() {
		return contentId;
	}
	public void setContentId(int contentId) {
		this.contentId = contentId;
	}
	
	@Override
	public String toString() {
		return "Recommendation [id=" + id + ", userId=" + userId + ", contentType=" + contentType + ", contentId="
				+ contentId + "]";
	}
	
	
}
