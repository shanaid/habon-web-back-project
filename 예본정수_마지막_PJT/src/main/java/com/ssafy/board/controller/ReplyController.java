package com.ssafy.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.board.model.dto.Reply;
import com.ssafy.board.model.dto.User;
import com.ssafy.board.model.service.ReplyService;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api-reply")
@Tag(name = "replyController", description = "댓글의 대댓글 CRUD")
public class ReplyController {

	private final ReplyService replyService;

	@Autowired
	public ReplyController(ReplyService replyService) {
		this.replyService = replyService;
	}

	@GetMapping("/reply/{comment_id}")
	public ResponseEntity<List<Reply>> selectAll(@PathVariable("comment_id") int id) {
		List<Reply> replyList = replyService.getReplyList(id);
		return new ResponseEntity<List<Reply>>(replyList, HttpStatus.OK);
	}

	@PostMapping("/reply/{board_id}/{comment_id}")
	public ResponseEntity<?> registReply(@PathVariable("board_id") int b_id, @PathVariable("comment_id") int c_id, @RequestBody Reply reply,
			HttpSession session) {
		if (session.getAttribute("loginUser") != null) {
			User login = (User) session.getAttribute("loginUser");
			reply.setUserId(login.getId());
			reply.setWriter(login.getNickname());
			reply.setBoardId(b_id);
			reply.setCommentId(c_id);
			replyService.registReply(reply);
			System.out.println(reply);
			return new ResponseEntity<Reply>(reply, HttpStatus.OK);
		} else {
			String msg = "너 로그인 안됐어!";
			return new ResponseEntity<String>(msg, HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/reply/{id}")
	public ResponseEntity<?> updateReply(@PathVariable("id") int id, @RequestBody Reply reply, HttpSession session) {
		if (session.getAttribute("loginUser") != null) {
			User login = (User) session.getAttribute("loginUser");
			if (login.getId().equals(replyService.getUserId(id))) {
				reply.setId(id);
				replyService.updateReply(reply);
				return new ResponseEntity<Reply>(reply, HttpStatus.OK);
			}
			String msg = "음.. 당신이 쓴 댓글이 아니야..";
			return new ResponseEntity<String>(msg, HttpStatus.BAD_REQUEST);
		} else {
			String msg = "로그인이 안되어있어";
			return new ResponseEntity<String>(msg, HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/reply/{id}")
	public ResponseEntity<?> deleteReply(@PathVariable("id") int id, HttpSession session) {
		User login = (User) session.getAttribute("loginUser");

		if (login != null) {
			if (login.getId().equals(replyService.getUserId(id))) {
				replyService.deleteReply(id);
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
