package com.ssafy.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.board.model.dto.Board;
import com.ssafy.board.model.dto.Worldcup;
import com.ssafy.board.model.service.NoticeboardService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api-Noticeboard")
@Tag(name = "Noticeboard Controller", description = "게시판 조회")
@CrossOrigin("http://localhost:5173")
public class NoticeboardController {
	
	private final NoticeboardService noticeboardService;
	
	@Autowired
	private ResourceLoader loader;

	@Autowired
	public NoticeboardController(NoticeboardService noticeboardService) {
		this.noticeboardService = noticeboardService;
	}
	
	@GetMapping("/noticeboard")
	@Operation(summary = "게시판 전체 목록 가져오기", description = "월드컵 정보를 땅겨옴")
	public ResponseEntity<List<Worldcup>> selectAllNoticeboard(){
		List<Worldcup> list = noticeboardService.selectAll();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@GetMapping("/noticeboard/{id}") // 월드컵 id
	@Operation(summary = "해당 월드컵 주제에 따른 게시판 (게시물 다 땅겨옴)")
	public ResponseEntity<List<Board>> get(@PathVariable("id") int w_id) {
			List<Board> list = noticeboardService.selectWorldcupBoard(w_id);
			return new ResponseEntity<List<Board>>(list, HttpStatus.OK);
	}
	

	
	
}
