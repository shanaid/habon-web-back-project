package com.ssafy.board.model.dto;

public class Reply {
	private int id; // 대댓글의 고유 id
	private int boardId; // 보드의 id
	private String userId; // 유저의 id
	private int commentId; // 댓글의 id
	private String writer; // 대댓글 작성자
	private String content; // 대댓글 내용
	private String registDate; // 대댓글 등록날짜
	
	
	public Reply(String content) {
		super();
		this.content = content;
	}

	public Reply(int id, int boardId, String userId, int commentId, String writer, String content, String registDate) {
		super();
		this.id = id;
		this.boardId = boardId;
		this.userId = userId;
		this.commentId = commentId;
		this.writer = writer;
		this.content = content;
		this.registDate = registDate;
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

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRegistDate() {
		return registDate;
	}

	public void setRegistDate(String registDate) {
		this.registDate = registDate;
	}

	@Override
	public String toString() {
		return "Reply [id=" + id + ", boardId=" + boardId + ", userId=" + userId + ", commentId=" + commentId
				+ ", writer=" + writer + ", content=" + content + ", registDate=" + registDate + "]";
	}
}
