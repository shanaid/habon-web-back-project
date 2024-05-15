package com.ssafy.board.model.dao;

import java.util.List;
import java.util.Map;

import com.ssafy.board.model.dto.User;

public interface UserDao {
	public void insertUser(User user);
	
	public User checkUser(User user);

	public User userLogin(Map<String, String> info);
	
}