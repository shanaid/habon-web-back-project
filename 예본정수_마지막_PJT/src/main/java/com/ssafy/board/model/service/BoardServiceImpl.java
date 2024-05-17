package com.ssafy.board.model.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import com.ssafy.board.model.dao.BoardDao;
import com.ssafy.board.model.dto.Board;

@Service
public class BoardServiceImpl implements BoardService {

	private final BoardDao boardDao;

	private final ResourceLoader resourceLoader;

	@Autowired
	public BoardServiceImpl(BoardDao boardDao, ResourceLoader resourceLoader) {
		this.boardDao = boardDao;
		this.resourceLoader = resourceLoader;
	}

	@Override
	public Board getBoard(int id) {
		boardDao.updateViewCnt(id);
		return boardDao.selectOne(id);
	}

	@Override
	public void modifyBoard(Board board) {
		boardDao.updateBoard(board);
	}

	@Override
	public void removeBoard(int id) {
		boardDao.deleteBoard(id);
	}

	@Override
	public void writeBoard(Board board) {
		boardDao.insertBoard(board);
	}

	@Override
	public void readBoard(int id) {
		boardDao.updateViewCnt(id);
	}

	@Override
	public String getUserId(int id) {
		return boardDao.getUserId(id);
	}

	@Override
	public String getWorldcupId(int id) {
		return boardDao.getWorldcupId(id);
	}


}
