package com.ssafy.board.model.service;

import java.util.List;

import com.ssafy.board.model.dao.VideoDao;
import com.ssafy.board.model.dto.Video;

public interface VideoService {

	
	public List<Video> selectAll();

	public List<Video> selectCon(String con);

	public Video selectOne(int id);

}
