package com.ssafy.board.model.dao;

import java.util.List;

import com.ssafy.board.model.dto.Video;

public interface VideoDao {
	public List<Video> selectAll();

	public List<Video> selectCon(String con);

	public Video selectOne(int id);
	
	public void updateVideoViewCnt(int id);
}
