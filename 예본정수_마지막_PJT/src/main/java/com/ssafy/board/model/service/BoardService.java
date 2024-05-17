package com.ssafy.board.model.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ssafy.board.model.dto.Board;
import com.ssafy.board.model.dto.SearchCondition;

public interface BoardService {
	
	//게시물 선택
	public Board getBoard(int id);
	
	//게시글 수정
	public void modifyBoard(Board board);

	///게시글 삭제
	public void removeBoard(int id);

	//게시글 작성
	public void writeBoard(Board board);

	//게시판 조회수 증가
	public void readBoard(int id); //Dao -> 뷰카운트 +1 / 게시글 조회 
	
	//유저 아이디 따오기
	public String getUserId(int id);

	//월드컵 
	public String getWorldcupId(int id);

	//	//게시글 검색
//	public List<Board> search(SearchCondition searchCondition);
//	
//	public void fileBoard(MultipartFile multipartFile, Board board);

}
