package com.ssafy.board.model.dao;

import java.util.List;

import com.ssafy.board.model.dto.Reply;

public interface ReplyDao {

	List<Reply> getReplyList(int id);

	void registReply(Reply reply);

	String getUserId(int id);

	void updateReply(Reply reply);

	void deleteReply(int id);

}
