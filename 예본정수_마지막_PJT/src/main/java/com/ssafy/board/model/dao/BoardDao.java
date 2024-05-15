package com.ssafy.board.model.dao;

import java.util.List;

import com.ssafy.board.model.dto.Board;
import com.ssafy.board.model.dto.SearchCondition;

public interface BoardDao {
	// 전체 게시글을 조회
	public List<Board> selectAll(int id);

	// ID에 해당하는 게시글 하나 가져오기
	public Board selectOne(int r_id);

	// 게시글 등록
	public void insertBoard(Board board);

	// 게시글 삭제
	public void deleteBoard(int r_id);

	// 게시글 수정
	public void updateBoard(Board board);

	// 조회수 증가
	public void updateViewCnt(int r_id);
	
	// 검색 기능
	public List<Board> search(SearchCondition searchCondition);

	//파일 이름, ID 등 저장
	public void insertFile(Board board);
	
	public String getUserId(int r_id);

}
