package com.ssafy.board.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "게시판 DTO")
public class Board {
	private int id; // 게시판 고유 id
	private String userId; // 게시판 작성 유저 id
	private int videoId;
	private String content; // 게시판 내용
	private String nickname; // 게시판 작성자 별명(닉네임)
	private String title; // 게시판 제목
	private String registDate; // 작성일자
	private int viewCount; // 게시판 조회수

	public Board() {
	}

	public Board(String nickname, String content, String title) {
		super();
		this.nickname = nickname;
		this.content = content;
		this.title = title;
	}

	public Board(int id, String userId, int videoId, String content, String nickname, String title, String registDate,
			int viewCount) {
		super();
		this.id = id;
		this.userId = userId;
		this.videoId = videoId;
		this.content = content;
		this.nickname = nickname;
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

	public int getVideoId() {
		return videoId;
	}

	public void setVideoId(int videoId) {
		this.videoId = videoId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
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
		return "Board [id=" + id + ", userId=" + userId + ", videoId=" + videoId + ", content=" + content
				+ ", nickname=" + nickname + ", title=" + title + ", registDate=" + registDate + ", viewCount="
				+ viewCount + "]";
	}

}