package com.ssafy.board.model.dao;

import java.util.List;
import java.util.Map;

import com.ssafy.board.model.dto.Elements;
import com.ssafy.board.model.dto.ElementsRank;
import com.ssafy.board.model.dto.Participation;
import com.ssafy.board.model.dto.Rank;
import com.ssafy.board.model.dto.Worldcup;
import com.ssafy.board.model.dto.weeklyrank;

public interface WorldcupDao {

	List<Worldcup> selectAll();
	
	Participation findByUserIdAndWorldcupId(Map map);

	void insertParticipation(Participation participation);
	
	void updateParticipationCount(Map map);
	
	Worldcup getWorldcup(int id);

	List<Elements> getAllElements(String categori);

	Rank findRank(Map<String, Object> map);

	void updateRank(Map<String, Object> map);

	void updateaccRank(Map<String, Object> map);
	
	void insertRank(Map<String, Object> map);

	void makeRankEachElements(Map<String, Object> map);

	List<ElementsRank> getRankList(int w_id);

	List<ElementsRank> getAllRankList(int w_id);

	void getPoint(Map<String, Object> map);


	String getWorldcupSubCategory(int w_id);

	List<weeklyrank> getWeekList(int w_id);

	Elements getElements(int id);

	
}
