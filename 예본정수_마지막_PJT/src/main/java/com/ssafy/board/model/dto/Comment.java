package com.ssafy.board.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "댓글 dto")
public class Comment {
	private int id; // 댓글의 고유 id
	private String userId; // 댓글 작성자의 id
	private int boardId; // 댓글이 작성된 게시판 id
	private String comments; // 댓글내용
	private String registDate; // 댓글 작성시간
	
}
