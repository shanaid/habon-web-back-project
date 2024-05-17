package com.ssafy.board.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "게시판 DTO")
public class Board {
	private int id; // 게시판 고유 id
	private String userId; // 게시판 작성 유저 id
	private int worldcupId; // 월드컵 고유 id
	private String title; // 게시판 제목
	private String writer; // 게시판 작성자
	private String content; // 게시판 내용
	private String registDate; // 작성일자
	private int viewCount; // 게시판 조회수

	public Board() {
	}

	public Board(String writer, String content, String title) {
		super();
		this.writer = writer;
		this.content = content;
		this.title = title;
	}

	public Board(int id, String userId, int worldcupId, String content, String writer, String title, String registDate,
			int viewCount) {
		super();
		this.id = id;
		this.userId = userId;
		this.worldcupId = worldcupId;
		this.content = content;
		this.writer = writer;
		this.title = title;
		this.registDate = registDate;
		this.viewCount = viewCount;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getRegistDate() {
		return registDate;
	}

	public void setRegistDate(String registDate) {
		this.registDate = registDate;
	}

	public int getViewCount() {
		return viewCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}

	@Override
	public String toString() {
		return "Board [id=" + id + ", userId=" + userId + ", worldcupId=" + worldcupId + ", content=" + content
				+ ", writer=" + writer + ", title=" + title + ", registDate=" + registDate + ", viewCount=" + viewCount
				+ "]";
	}
}