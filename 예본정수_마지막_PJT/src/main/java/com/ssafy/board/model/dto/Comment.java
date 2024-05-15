package com.ssafy.board.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "댓글 dto")
public class Comment {
	private int id; // 댓글의 고유 id
	private String userId; // 댓글 작성자의 id
	private int boardId; // 댓글이 작성된 게시판 id
	private String comments; // 댓글내용
	private String registDate; // 댓글 작성시간
	private int good; // 추천갯수
	private int bad; // 비추갯수

	public Comment(String comments) {
		super();
		this.comments = comments;
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

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getRegistDate() {
		return registDate;
	}

	public void setRegistDate(String registDate) {
		this.registDate = registDate;
	}

	public int getGood() {
		return good;
	}

	public void setGood(int good) {
		this.good = good;
	}

	public int getBad() {
		return bad;
	}

	public void setBad(int bad) {
		this.bad = bad;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", userId=" + userId + ", boardId=" + boardId + ", comments=" + comments
				+ ", registDate=" + registDate + ", good=" + good + ", bad=" + bad + "]";
	}
}
