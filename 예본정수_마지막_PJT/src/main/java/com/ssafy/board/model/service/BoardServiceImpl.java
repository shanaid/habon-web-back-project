package com.ssafy.board.model.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.board.model.dao.BoardDao;
import com.ssafy.board.model.dto.Board;
import com.ssafy.board.model.dto.SearchCondition;

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
	public List<Board> getBoardList(int id) {
		return boardDao.selectAll(id);
	}

	@Override
	public Board readBoard(int r_id) {
		System.out.println(r_id + "번 게시글을 읽어옵니다.");
		boardDao.updateViewCnt(r_id);
		return boardDao.selectOne(r_id);
	}

	@Transactional
	@Override
	public void writeBoard(Board board) {
		System.out.println("게시글 작성합니다.");
		boardDao.insertBoard(board);
	}

	@Transactional
	@Override
	public void removeBoard(int r_id) {
		System.out.println(r_id + "번 게시글을 삭제하겠습니다.");
		boardDao.deleteBoard(r_id);
	}

	@Transactional
	@Override
	public void modifyBoard(Board board) {
		System.out.println("게시글 수정");
		boardDao.updateBoard(board);
	}

	@Override
	public List<Board> search(SearchCondition searchCondition) {
		return boardDao.search(searchCondition);
	}

	@Override
	public String getUserId(int r_id) {
		return boardDao.getUserId(r_id);
	}

	
	
//	@Override
//	public void fileBoard(MultipartFile multipartFile, Board board) {
//		if (multipartFile != null && multipartFile.getSize() > 0) {
//			try {
//				String fileName = multipartFile.getOriginalFilename();
//				String fileId = UUID.randomUUID().toString();
//				
//				board.setFileId(fileId);
//				board.setFileName(fileName);
//				
//				Resource resource = resourceLoader.getResource("classpath:/static/img");
//				multipartFile.transferTo(new File(resource.getFile(), fileId));
//				
//				boardDao.insertBoard(board);
//				boardDao.insertFile(board);
//				
//			} catch (IllegalStateException e) {
//				e.printStackTrace();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//			
//			
//			
//			
//		}
//	}

}
