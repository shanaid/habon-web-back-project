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

import com.ssafy.board.model.dao.LikeDao;
import com.ssafy.board.model.dto.Board;
import com.ssafy.board.model.dto.User;
import com.ssafy.board.model.service.BoardService;
import com.ssafy.board.model.service.LikeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api-like")
@Tag(name = "LikeController", description = "좋아요 관리")
@CrossOrigin("http://localhost:5173")
public class LikeController {

	private final LikeService likeService;

	@Autowired
	private ResourceLoader loader;

	@Autowired
	public LikeController(LikeService likeService) {
		this.likeService = likeService;
	}

	// 보드 댓글 -> 떙겨올 수 있어 -> 내가 한지 모르잖아
	// 빨간 하트가 나오고
	// 데이터가 있으면 좋아요 누른거고, 없으면 안누른거잖아.
	// 그럼 데이터를 보여주는거 하나, 데이터 작동하는거 하나를 만들어야 하는거 아닌가?
	// Recommendating

	@GetMapping("likecheck/{type}/{id}")
	@Operation(summary = "추천되어 있나?, type에는 board, comment 만 들어갈 수 있어요" )
	public ResponseEntity<Boolean> likecheck(@PathVariable("type") String type, @PathVariable("id") int c_id,
			HttpSession session) {
		if (session.getAttribute("loginUser") != null) {
			User login = (User) session.getAttribute("loginUser");

			boolean likeIs = likeService.checkLike(login.getId(), type, c_id);

			if (likeIs) {
				return new ResponseEntity<Boolean>(true, HttpStatus.OK);
			} else {
				return new ResponseEntity<Boolean>(false, HttpStatus.OK);
			}

		} else {// 만약 안되어 있다면!
			return new ResponseEntity<Boolean>(false, HttpStatus.OK);
		}
	}
	
	@GetMapping("likeclick/{type}/{id}")
	@Operation(summary = "추천/추천취소")
	public ResponseEntity<?> likeButton(@PathVariable("type") String type, @PathVariable("id") int c_id,
			HttpSession session) {
		if (session.getAttribute("loginUser") != null) {
			User login = (User) session.getAttribute("loginUser");
			
			likeService.clickLike(login.getId(), type, c_id);
			
			return new ResponseEntity<String>("성공",HttpStatus.OK);
			
		} else {// 만약 안되어 있다면!
			String msg = "로그인이 필요합니다";
			return new ResponseEntity<String>(msg, HttpStatus.BAD_REQUEST);
		}
	}
	
	
	
	

//	@DeleteMapping("board/{id}")
//	@Operation(summary = "게시물 삭제", description = "작성자와 유저가 같다면 삭제 가능하다.")
//	public ResponseEntity<?> delectboard(@PathVariable("id") int id, HttpSession session) {
//
//		User login = (User) session.getAttribute("loginUser");
//
//		if (login != null) {
//
//			if (login.getId() != null && login.getId().equals(boardService.getUserId(id))) {
//
//				boardService.removeBoard(id);
//				return new ResponseEntity<>(HttpStatus.OK);
//
//			} else {
//				String msg = "자기 글만 지울수 있어요";
//				return new ResponseEntity<String>(msg, HttpStatus.BAD_REQUEST);
//			}
//
//		} else {
//			String msg = "로그인이 필요합니다";
//			return new ResponseEntity<String>(msg, HttpStatus.BAD_REQUEST);
//		}
//	}
//
//	@PostMapping("board/{id}")
//	@Operation(summary = "게시물 등록", description = "로그인시 글을 올릴 수 있다.")
//	public ResponseEntity<?> insertboard(@PathVariable("id") int w_id, @RequestBody Board board, HttpSession session) {
//
//		if (session.getAttribute("loginUser") != null) {
//			User login = (User) session.getAttribute("loginUser");
//
//			board.setUserId(login.getId());
//			board.setWorldcupId(w_id);
//			board.setWriter(login.getNickname());
//			boardService.writeBoard(board);
//			return new ResponseEntity<Board>(board, HttpStatus.OK);
//
//		} else {
//			String msg = "로그인이 필요합니다";
//			return new ResponseEntity<String>(msg, HttpStatus.BAD_REQUEST);
//		}
//	}

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
