package com.ssafy.board.model.service;

import java.util.List;

import com.ssafy.board.model.dto.Board;
import com.ssafy.board.model.dto.Elements;
import com.ssafy.board.model.dto.Worldcup;

public interface WorldcupService {

	public List<Worldcup> selectAll();
	
	public int currentAttempts(int w_id,String u_id);

	public List<Elements> getelements(int w_id, int cnt); 
	
	
	
}
