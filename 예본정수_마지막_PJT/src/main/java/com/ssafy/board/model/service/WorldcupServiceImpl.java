package com.ssafy.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.board.model.dao.NoticeboardDao;
import com.ssafy.board.model.dao.WorldcupDao;
import com.ssafy.board.model.dto.Board;
import com.ssafy.board.model.dto.Worldcup;

@Service
public class WorldcupServiceImpl implements WorldcupService{

	private final WorldcupDao worldcupDao;
	
	@Autowired
	public WorldcupServiceImpl(WorldcupDao worldcupDao) {
		this.worldcupDao = worldcupDao;
	}

	@Override
	public List<Worldcup> selectAll() {
		return worldcupDao.selectAll();
	}
	

}
