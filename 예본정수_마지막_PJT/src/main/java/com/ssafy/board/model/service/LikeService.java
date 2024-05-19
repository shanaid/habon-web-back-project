package com.ssafy.board.model.service;

public interface LikeService {
	
	boolean checkLike(String u_id, String type, int c_id);
	
	void clickLike(String u_id, String type, int c_id);
	
}
