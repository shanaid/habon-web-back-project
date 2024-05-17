package com.ssafy.board.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.board.model.dao.ReplyDao;
import com.ssafy.board.model.dto.Reply;

@Service
public class ReplyServiceImpl implements ReplyService {

	private final ReplyDao replyDao;

	public ReplyServiceImpl(ReplyDao replyDao) {
		this.replyDao = replyDao;
	}

	@Override
	public List<Reply> getReplyList(int id) {
		return replyDao.getReplyList(id);
	}

	@Override
	public void registReply(Reply reply) {
		System.out.println("대댓글 작성할게~");
		replyDao.registReply(reply);
	}

	@Override
	public String getUserId(int id) {
		return replyDao.getUserId(id);
	}

	@Override
	public void updateReply(Reply reply) {
		System.out.println("댓글 수정할게~");
		replyDao.updateReply(reply);
	}

	@Override
	public void deleteReply(int id) {
		replyDao.deleteReply(id);
	}

}
