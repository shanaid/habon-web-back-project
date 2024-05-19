package com.ssafy.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.board.model.dto.Board;
import com.ssafy.board.model.dto.User;
import com.ssafy.board.model.service.BoardService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api-board")
@Tag(name = "BoardController", description = "게시물 CRUD")
@CrossOrigin("http://localhost:5173")
public class BoardRestController {
	private final BoardService boardService;

	@Autowired
	private ResourceLoader loader;

	@Autowired
	public BoardRestController(BoardService boardService) {
		this.boardService = boardService;
	}

	@GetMapping("/board/{id}")
	@Operation(summary = "게시물 고르기", description = "id는 보드 즉 게시물의 고유 PK 아이디 입니다.")
	public ResponseEntity<Board> selectAll(@PathVariable("id") int id) {
		Board Board = boardService.getBoard(id);
		return new ResponseEntity<Board>(Board, HttpStatus.OK);
	}

	@PutMapping("board/{id}")
	@Operation(summary = "게시물 수정", description = "아이디에 접근해 put로 접근시 로그인아이디와 게시글 아이디 비교하고 올린다.")
	public ResponseEntity<?> updateboard(@PathVariable("id") int id, @RequestBody Board board, HttpSession session) {

		if (session.getAttribute("loginUser") != null) {
			User login = (User) session.getAttribute("loginUser");

			if (login.getId().equals(boardService.getUserId(id))) {
				// 여기가 좀 햇길린다.
				board.setId(id);
				boardService.modifyBoard(board);
				return new ResponseEntity<Board>(board, HttpStatus.OK);

			}
			String msg = "타인이 쓴 글에 접근할 수 없습니다.";
			return new ResponseEntity<String>(msg, HttpStatus.BAD_REQUEST);

		} else {
			String msg = "로그인이 필요합니다";
			return new ResponseEntity<String>(msg, HttpStatus.BAD_REQUEST);
		}

	}

	@DeleteMapping("board/{id}")
	@Operation(summary = "게시물 삭제", description = "작성자와 유저가 같다면 삭제 가능하다.")
	public ResponseEntity<?> delectboard(@PathVariable("id") int id, HttpSession session) {

		User login = (User) session.getAttribute("loginUser");

		if (login != null) {

			if (login.getId() != null && login.getId().equals(boardService.getUserId(id))) {

				boardService.removeBoard(id);
				return new ResponseEntity<>(HttpStatus.OK);

			} else {
				String msg = "자기 글만 지울수 있어요";
				return new ResponseEntity<String>(msg, HttpStatus.BAD_REQUEST);
			}

		} else {
			String msg = "로그인이 필요합니다";
			return new ResponseEntity<String>(msg, HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("board/{id}")
	@Operation(summary = "게시물 등록", description = "로그인시 글을 올릴 수 있다.")
	public ResponseEntity<?> insertboard(@PathVariable("id") int w_id, @RequestBody Board board, HttpSession session) {

		if (session.getAttribute("loginUser") != null) {
			User login = (User) session.getAttribute("loginUser");

			board.setUserId(login.getId());
			board.setWorldcupId(w_id);
			board.setWriter(login.getNickname());
			boardService.writeBoard(board);
			return new ResponseEntity<Board>(board, HttpStatus.OK);

		} else {
			String msg = "로그인이 필요합니다";
			return new ResponseEntity<String>(msg, HttpStatus.BAD_REQUEST);
		}
	}
	

//	@GetMapping("/board/review/{review_id}")
//	public ResponseEntity<Board> selectOne(@PathVariable("review_id") int r_id) {
//		Board review = boardService.readBoard(r_id);
//		return new ResponseEntity<Board>(review, HttpStatus.OK);
//	}
//
//
//
//	
//	@DeleteMapping("board/{review_id}")
//	public ResponseEntity<?> delectReview(@PathVariable("review_id") int r_id, HttpSession session) {
//
//		if (session.getAttribute("loginUser") != null) {
//
//			User login = (User) session.getAttribute("loginUser");
//			if (login.getUserId().equals(boardService.getUserId(r_id))) {
//				boardService.removeBoard(r_id);
//				return new ResponseEntity<>(HttpStatus.OK);
//			} else {
//
//				String msg = "자기 글만 지울수 있어요";
//				return new ResponseEntity<String>(msg, HttpStatus.BAD_REQUEST);
//			}
//
//		} else {
//
//			String msg = "너 로그인 안됐어..";
//			return new ResponseEntity<String>(msg, HttpStatus.BAD_REQUEST);
//		}
//	}

}
