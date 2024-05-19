package com.ssafy.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.board.model.dto.Comment;
import com.ssafy.board.model.dto.User;
import com.ssafy.board.model.service.CommentService;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api-comment")
@Tag(name = "CommentController", description = "게시판의 댓글 CRUD")
public class CommentController {
	private final CommentService commentService;

	@Autowired
	private ResourceLoader loader;

	@Autowired
	public CommentController(CommentService commentService) {
		this.commentService = commentService;
	}

	
	
	@GetMapping("/comment/{board_id}")
	public ResponseEntity<List<Comment>> selectAll(@PathVariable ("board_id") int id) {
		
		List<Comment> commentList = commentService.getCommentList(id);
		
		return new ResponseEntity<List<Comment>>(commentList, HttpStatus.OK);
	}

	
	
	
	@PostMapping("/comment/{board_id}")
	public ResponseEntity<?> registComment(@PathVariable("board_id") int b_id, @RequestBody Comment comment,
			HttpSession session) {
		if (session.getAttribute("loginUser") != null) {
			User login = (User) session.getAttribute("loginUser");
			comment.setUserId(login.getId());
			comment.setWriter(login.getNickname());
			comment.setBoardId(b_id);
			commentService.registComment(comment);
			System.out.println(comment);
			return new ResponseEntity<Comment>(comment, HttpStatus.OK);
		} else {
			String msg = "너 로그인 안됐어!";
			return new ResponseEntity<String>(msg, HttpStatus.BAD_REQUEST);
		}
	}
	

	@PutMapping("/comment/{id}")
	public ResponseEntity<?> updateComment(@PathVariable("id") int id, @RequestBody Comment comment,
			HttpSession session) {
		if (session.getAttribute("loginUser") != null) {
			User login = (User) session.getAttribute("loginUser");
			if (login.getId().equals(commentService.getUserId(id))) {
				comment.setId(id);
				commentService.updateComment(comment);
				return new ResponseEntity<Comment>(comment, HttpStatus.OK);
			}
			String msg = "음.. 당신이 쓴 댓글이 아니야..";
			return new ResponseEntity<String>(msg, HttpStatus.BAD_REQUEST);
		} else {
			String msg = "로그인이 안되어있어";
			return new ResponseEntity<String>(msg, HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/comment/{id}")
	public ResponseEntity<?> deleteComment(@PathVariable("id") int id, HttpSession session) {
		User login = (User) session.getAttribute("loginUser");

		if (login != null) {
			if (login.getId().equals(commentService.getUserId(id))) {
				commentService.deleteComment(id);
				return new ResponseEntity<String>("삭제 성공", HttpStatus.OK);
			} else {
				String msg = "당신의 댓글이 아닙니다.";
				return new ResponseEntity<String>(msg, HttpStatus.BAD_REQUEST);
			}
		} else {
			String msg = "로그인 안되어있어.";
			return new ResponseEntity<String>(msg, HttpStatus.BAD_REQUEST);

		}
	}

}
