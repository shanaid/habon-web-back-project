package com.ssafy.board.model.service;

import java.util.List;

import com.ssafy.board.model.dto.User;

public interface UserService {
	// id가 등록되었나 확인
	public User checkUser(User user);
	//사용자 등록하기
	public void insertUser(User user);
	//로그인 하기
	public User userLogin(String id, String password);
	
	public void updateUser(User user);
	
	public void updateImg(String id);
	
	public String getImg(String type, int c_id);


}
 