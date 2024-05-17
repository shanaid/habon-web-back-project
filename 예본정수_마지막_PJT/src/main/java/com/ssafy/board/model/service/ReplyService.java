package com.ssafy.board.model.service;

import java.util.List;

import com.ssafy.board.model.dto.Reply;

public interface ReplyService {

	// 대댓글 전체 조회
	public List<Reply> getReplyList(int id);

	// 대댓글 작성
	public void registReply(Reply reply);

	// 유저아이디 가져오기(대댓글 수정과 삭제를 위해)
	public String getUserId(int id);

	// 대댓글 수정
	public void updateReply(Reply reply);

	// 대댓글 삭제
	public void deleteReply(int id);

}
