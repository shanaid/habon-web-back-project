package com.ssafy.board.model.dao;

import java.util.List;
import java.util.Map;

import com.ssafy.board.model.dto.Elements;
import com.ssafy.board.model.dto.Participation;
import com.ssafy.board.model.dto.Worldcup;

public interface WorldcupDao {

	List<Worldcup> selectAll();
	
	Participation findByUserIdAndWorldcupId(Map map);

	void insertParticipation(Participation participation);
	
	void updateParticipationCount(Map map);
	
	Worldcup getWorldcup(int id);

	List<Elements> getAllElements(String categori);
	
	
}
