package com.ssafy.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.board.model.dao.NoticeboardDao;
import com.ssafy.board.model.dto.Board;
import com.ssafy.board.model.dto.Worldcup;

@Service
public class NoticeBoardServiceImpl implements NoticeboardService{

	private final NoticeboardDao noticeboardDao;
	
	@Autowired
	public NoticeBoardServiceImpl(NoticeboardDao noticeboardDao) {
		this.noticeboardDao = noticeboardDao;
	}

	@Override
	public List<Worldcup> selectAll() {
		return noticeboardDao.selectAll();
	}

	@Override
	public List<Board> selectWorldcupBoard(int W_id) {
		return noticeboardDao.selectOne(W_id);
	}
	

}
