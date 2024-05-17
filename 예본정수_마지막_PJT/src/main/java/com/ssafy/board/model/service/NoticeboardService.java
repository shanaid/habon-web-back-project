package com.ssafy.board.model.service;

import java.util.List;

import com.ssafy.board.model.dto.Board;
import com.ssafy.board.model.dto.Worldcup;

public interface NoticeboardService {

	public List<Worldcup> selectAll();

	public List<Board> selectWorldcupBoard(int W_id);
	
}
