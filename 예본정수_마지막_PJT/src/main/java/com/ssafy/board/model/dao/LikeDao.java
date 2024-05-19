package com.ssafy.board.model.dao;

import java.util.Map;

import com.ssafy.board.model.dto.Recommendation;

public interface LikeDao {

	public Recommendation checkLike(Map<String, Object> map);

	public void delectLike(Map<String, Object> map);

	public void insertLike(Map<String, Object> map);

	public void downdate(Map<String, Object> map);

	public void update(Map<String, Object> map);
	
	
}
