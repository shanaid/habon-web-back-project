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

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api-board")
@Tag(name = "BoardRestController", description = "영상별 리뷰 CRUD")
@CrossOrigin("http://localhost:5173")
public class BoardRestController {
	private final BoardService boardService;

	@Autowired
	private ResourceLoader loader;

	@Autowired
	public BoardRestController(BoardService boardService) {
		this.boardService = boardService;
	}

	@GetMapping("/board/{video_id}")
	public ResponseEntity<List<Board>> selectAll(@PathVariable("video_id") int id) {
		List<Board> list = boardService.getBoardList(id);
		return new ResponseEntity<List<Board>>(list, HttpStatus.OK);
	}

	@GetMapping("/board/review/{review_id}")
	public ResponseEntity<Board> selectOne(@PathVariable("review_id") int r_id) {
		Board review = boardService.readBoard(r_id);
		return new ResponseEntity<Board>(review, HttpStatus.OK);
	}

	@PostMapping("/board/{video_id}")
	public ResponseEntity<?> insertReview(@PathVariable("video_id") int v_id, @RequestBody Board review,
			HttpSession session) {

		if (session.getAttribute("loginUser") != null) {
			User login = (User) session.getAttribute("loginUser");
			review.setUserId(login.getUserId());
			review.setVideoId(v_id);
			System.out.println(review);
			boardService.writeBoard(review);
			return new ResponseEntity<Board>(review, HttpStatus.OK);
		} else {
			String msg = "너 로그인 안됐어..";
			return new ResponseEntity<String>(msg, HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("board/{review_id}")
	public ResponseEntity<?> updateReview(@PathVariable("review_id") int r_id, @RequestBody Board review,
			HttpSession session) {

		if (session.getAttribute("loginUser") != null) {

			User login = (User) session.getAttribute("loginUser");

			if (login.getUserId().equals(boardService.getUserId(r_id))) {
				review.setReviewId(r_id);
				boardService.modifyBoard(review);
				return new ResponseEntity<Board>(review, HttpStatus.OK);
			}
			String msg = "음.. 당신이 쓴 글 아니잖아";
			return new ResponseEntity<String>(msg, HttpStatus.BAD_REQUEST);

		} else {

			String msg = "너 로그인 안됐어..";
			return new ResponseEntity<String>(msg, HttpStatus.BAD_REQUEST);
		}

	}

	@DeleteMapping("board/{review_id}")
	public ResponseEntity<?> delectReview(@PathVariable("review_id") int r_id, HttpSession session) {

	    User login = (User) session.getAttribute("loginUser");
	    
	    if (login != null) {
	        if (login.getUserId() != null && login.getUserId().equals(boardService.getUserId(r_id))) {
	            boardService.removeBoard(r_id);
	            return new ResponseEntity<>(HttpStatus.OK);
	        } else {
	            String msg = "자기 글만 지울수 있어요";
	            return new ResponseEntity<String>(msg, HttpStatus.BAD_REQUEST);
	        }
	    } else {
	        String msg = "너 로그인 안됐어..";
	        return new ResponseEntity<String>(msg, HttpStatus.BAD_REQUEST);
	    }
	}
	
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
