package com.ssafy.board.model.dao;

import java.util.List;

import com.ssafy.board.model.dto.Board;
import com.ssafy.board.model.dto.Worldcup;

public interface NoticeboardDao {
	
	// 전체 게시판을 조회하겠어요
	public List<Worldcup> selectAll();

	// 월드컵 id를 따와서 게시판에 있는 게시물 1개 선택할게요.
	public List<Board> selectOne(int W_id);
	
	
}
