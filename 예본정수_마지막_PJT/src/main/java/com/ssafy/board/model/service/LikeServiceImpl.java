package com.ssafy.board.model.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.board.model.dao.LikeDao;
import com.ssafy.board.model.dto.Recommendation;

@Service
public class LikeServiceImpl implements LikeService {
	
	private final LikeDao likeDao;

	@Autowired
	public LikeServiceImpl(LikeDao likeDao) {
		this.likeDao = likeDao;
	}
	
	
	@Override
	public boolean checkLike(String u_id, String type, int c_id) {
		Map<String, Object> map = new HashMap<>();
		
		map.put("type",type);
		map.put("u_id", u_id);
		map.put("c_id", c_id);
		Recommendation rec = likeDao.checkLike(map);
		if (rec==null) {
			return false;
		}
		return true;
	}


	@Override
	public void clickLike(String u_id, String type, int c_id) {
		Map<String, Object> map = new HashMap<>();
		
		map.put("type",type);
		map.put("u_id", u_id);
		map.put("c_id", c_id);
		
		if(checkLike(u_id, type, c_id)) {//있다면
			
			likeDao.delectLike(map); 
			
			likeDao.downdate(map);
			
		}else{//없다면
			
			likeDao.insertLike(map);
			
			likeDao.update(map);}
	}
	
	
	



}
