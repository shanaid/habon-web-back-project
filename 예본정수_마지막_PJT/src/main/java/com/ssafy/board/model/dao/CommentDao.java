package com.ssafy.board.model.dao;

import java.util.List;

import com.ssafy.board.model.dto.Comment;

public interface CommentDao {

	public List<Comment> getCommentList(int boardId);

	public void registComment(Comment comment);

	public String getUserId(int id);

	public void updateComment(Comment comment);

	public void deleteComment(int id);

}
