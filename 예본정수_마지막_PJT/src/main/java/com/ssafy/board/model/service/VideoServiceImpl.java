package com.ssafy.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.board.model.dao.VideoDao;
import com.ssafy.board.model.dto.Video;

@Service
public class VideoServiceImpl implements VideoService {

	private final VideoDao videoDao;

	@Autowired
	public VideoServiceImpl(VideoDao videoDao) {
		this.videoDao = videoDao;
	}

	@Override
	public List<Video> selectAll() {
		return videoDao.selectAll();
	}

	@Override
	public List<Video> selectCon(String con) {
		return videoDao.selectCon(con);
	}

	@Override
	public Video selectOne(int id) {
		videoDao.updateVideoViewCnt(id);
		return videoDao.selectOne(id);
	}



}
