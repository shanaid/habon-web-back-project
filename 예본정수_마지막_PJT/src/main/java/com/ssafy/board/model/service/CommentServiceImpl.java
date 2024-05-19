package com.ssafy.board.model.service;

import java.util.List;

import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import com.ssafy.board.model.dao.CommentDao;
import com.ssafy.board.model.dto.Comment;

@Service
public class CommentServiceImpl implements CommentService {
	private final CommentDao commentDao;

	private final ResourceLoader resourceLoader;

	public CommentServiceImpl(CommentDao commentDao, ResourceLoader resourceLoader) {
		this.commentDao = commentDao;
		this.resourceLoader = resourceLoader;
	}

	@Override
	public List<Comment> getCommentList(int id) {
		
			return commentDao.getCommentList(id);
	}

	@Override
	public void registComment(Comment comment) {
		System.out.println("댓글작성할게~");
		commentDao.registComment(comment);
	}

	@Override
	public String getUserId(int id) {
		return commentDao.getUserId(id);
	}

	@Override
	public void updateComment(Comment comment) {
		System.out.println("댓글 수정합니다.");
		commentDao.updateComment(comment);
	}

	@Override
	public void deleteComment(int id) {
		commentDao.deleteComment(id);
	}

}
