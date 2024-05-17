package com.ssafy.board.model.dao;

import java.util.List;

import com.ssafy.board.model.dto.Board;
import com.ssafy.board.model.dto.SearchCondition;

public interface BoardDao {
	
	// 해당하는 게시물 선택
	public Board selectOne(int id);

	// 게시글 수정
	public void updateBoard(Board board);

	// 게시글 삭제
	public void deleteBoard(int id);
	
	//게시글 작성
	public void insertBoard(Board board);

	// 조회수 증가
	public void updateViewCnt(int id);
	
	// 검색 기능
	//public List<Board> search(SearchCondition searchCondition);

	//파일 이름, ID 등 저장
//	public void insertFile(Board board);
	
	//아이디 비교를 위한 것
	public String getUserId(int id);
	
	//월드컵 아이디 따오기
	public String getWorldcupId(int id);

}
