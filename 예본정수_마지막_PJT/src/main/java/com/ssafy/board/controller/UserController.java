package com.ssafy.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.board.model.dto.User;
import com.ssafy.board.model.service.UserService;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api-user")
@Tag(name = "UserRestController", description = "유저 회원관리")
@CrossOrigin("http://localhost:5173")
public class UserController {

	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping("/user/regist")
	public ResponseEntity<?> registUser(@RequestBody User user) {
		User check = userService.checkUser(user);
		if (check == null) {
			userService.insertUser(user);
			return new ResponseEntity<String>("회원가입 성공",HttpStatus.OK);
		}
		String msg = "이미 있는 아이디입니다.";
		return new ResponseEntity<String>(msg, HttpStatus.BAD_REQUEST);
	}

	@PostMapping("/user/login")
	public ResponseEntity<?> login(@RequestBody User user, HttpSession session) {
//		System.out.println(user.toString());
		User login = userService.userLogin(user.getUserId(), user.getUserPassword());

		if (session.getAttribute("loginUser") == null) {
//			System.out.println(login.toString());
			if (login != null) {
				session.setAttribute("loginUser", login);
				return new ResponseEntity<User>(login, HttpStatus.OK);
			} else {
				String msg = "아이디 또는 비밀번호를 확인하세요!";
				return new ResponseEntity<String>(msg, HttpStatus.BAD_REQUEST);
			}
		} else {
			String msg = "어? 이미 로그인 되어 있는데?";
			return new ResponseEntity<String>(msg, HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/user/logout")
	public ResponseEntity<String> logout(HttpSession session) {
		// 세션에서 사용자 정보 삭제
		if (session.getAttribute("loginUser") != null) {
			session.removeAttribute("loginUser");
			return new ResponseEntity<String>("로그아웃 성공", HttpStatus.OK);
		} else {
			String msg = "로그인 안됐는데?";
			return new ResponseEntity<String>(msg, HttpStatus.BAD_REQUEST);
		}
	}
}
