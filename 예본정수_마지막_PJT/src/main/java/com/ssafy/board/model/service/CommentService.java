package com.ssafy.board.model.service;

import java.util.List;

import com.ssafy.board.model.dto.Comment;

public interface CommentService {
	
	// 댓글 전체 조회
	public List<Comment> getCommentList(int id);
	// 댓글 작성
	public void registComment(Comment comment);
	// 유저아이디 가져오기(댓글 수정과 삭제를 위해)
	public String getUserId(int id);
	// 댓글 수정
	public void updateComment(Comment comment);
	// 댓글 삭제
	public void deleteComment(int id);

}
