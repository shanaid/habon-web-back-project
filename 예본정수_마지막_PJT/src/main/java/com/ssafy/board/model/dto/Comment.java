package com.ssafy.board.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "댓글 dto")
public class Comment {
	private int id; // 댓글의 고유 id
	private int boardId; // 댓글이 작성된 게시판 id
	private String userId; // 댓글 작성자의 id
	private String content; // 댓글내용
	private String writer; // 댓글 작성자
	private String registDate; // 댓글 작성시간
	private int likeCount; //좋아요 수
	
	
	public Comment(String content) {
		super();
		this.content = content;
	}


	public Comment(int id, int boardId, String userId, String content, String writer, String registDate,
			int likeCount) {
		this.id = id;
		this.boardId = boardId;
		this.userId = userId;
		this.content = content;
		this.writer = writer;
		this.registDate = registDate;
		this.likeCount = likeCount;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getBoardId() {
		return boardId;
	}


	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getWriter() {
		return writer;
	}


	public void setWriter(String writer) {
		this.writer = writer;
	}


	public String getRegistDate() {
		return registDate;
	}


	public void setRegistDate(String registDate) {
		this.registDate = registDate;
	}


	public int getLikeCount() {
		return likeCount;
	}


	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}


	@Override
	public String toString() {
		return "Comment [id=" + id + ", boardId=" + boardId + ", userId=" + userId + ", content=" + content
				+ ", writer=" + writer + ", registDate=" + registDate + ", likeCount=" + likeCount + "]";
	}

	
}
