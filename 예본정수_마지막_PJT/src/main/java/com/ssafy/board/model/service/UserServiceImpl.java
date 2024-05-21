package com.ssafy.board.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.board.model.dao.UserDao;
import com.ssafy.board.model.dto.User;

@Service
public class UserServiceImpl implements UserService {

	private final UserDao userDao;

	@Autowired
	public UserServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public User checkUser(User user) {
		return userDao.checkUser(user);
	}

	@Override
	public User userLogin(String id, String password) {
		
		Map<String, String> info = new HashMap<>();
		info.put("id", id);
		info.put("password", password);
		
		return userDao.userLogin(info);
		
	}

	@Override
	public void insertUser(User user) {
		userDao.insertUser(user);
	}

	@Override
	public void updateUser(User user) {
		userDao.updateUser(user);
		
	}

	@Override
	public void updateImg(String id) {
		String img = userDao.randomImg();
		
		Map<String, String> map = new HashMap<>();
		map.put("img", img);
		map.put("id", id);
		
		userDao.setImg(map);
		
		userDao.delectPoint(id);
	}

}
