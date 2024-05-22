package com.ssafy.board.model.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.board.model.dao.WorldcupDao;
import com.ssafy.board.model.dto.Elements;
import com.ssafy.board.model.dto.ElementsRank;
import com.ssafy.board.model.dto.Participation;
import com.ssafy.board.model.dto.Photo;
import com.ssafy.board.model.dto.Rank;
import com.ssafy.board.model.dto.Worldcup;
import com.ssafy.board.model.dto.weeklyrank;

@Service
public class WorldcupServiceImpl implements WorldcupService {

	private final WorldcupDao worldcupDao;

	@Autowired
	public WorldcupServiceImpl(WorldcupDao worldcupDao) {
		this.worldcupDao = worldcupDao;
	}

	@Override
	public List<Worldcup> selectAll() {
		return worldcupDao.selectAll();
	}

	@Override // 월드컵 참여 횟수 가져오기.
	public int currentAttempts(int w_id, String u_id) {

		Map<String, Object> map = new HashMap<>();
		// 있는지 체크
		map.put("w_id", w_id);
		map.put("u_id", u_id);

		Participation participation = worldcupDao.findByUserIdAndWorldcupId(map);

		// 없다면 만들고 1로 올리고 돌려보내기
		if (participation == null) {

			participation = new Participation();

			participation.setUserId(u_id);
			participation.setWorldcupId(w_id);
			participation.setParticipationCount(1);

			worldcupDao.insertParticipation(participation);
			return 1;

		} else {

			worldcupDao.updateParticipationCount(map);

			return participation.getParticipationCount() + 1;
		}

	}

	@Override // 월드컵 리스트 갯수만큼 가져오기
	public List<Elements> getelements(int w_id, int cnt) {

		// 월드컵 가져오고
		Worldcup worldcup = worldcupDao.getWorldcup(w_id);

		// 해당 월드컵의 카테고리
		String categori = worldcup.getEleCategory();

		// 여기에 몽땅 담았슈 해당 카테고리에 맞는 선수들을
		List<Elements> list = worldcupDao.getAllElements(categori);

		if (list.size() < cnt) { // 근데 사이즈가 작다면..
			return list;
		}
		// 랜덤으로 섞음
		Collections.shuffle(list);

		List<Elements> cutedlist = list.subList(0, cnt);

		return cutedlist;
	}

	@Override
	public void updateRank(int w_id, int e_id) {

		Map<String, Object> map = new HashMap<>();
		// 있는지 체크
		map.put("w_id", w_id);
		map.put("e_id", e_id);

		Rank rank = worldcupDao.findRank(map);

		if (rank != null) {
			// rank가 존재해
			worldcupDao.updateRank(map);
//			worldcupDao.updateaccRank(map);
		} else {
			worldcupDao.insertRank(map);
		}

	}

	@Override
	public List<ElementsRank> worldcuprank(int w_id) {

		// 월드컵 가져오고
		Worldcup worldcup = worldcupDao.getWorldcup(w_id);

		// 해당 월드컵의 카테고리
		String categori = worldcup.getEleCategory();

		// 여기에 몽땅 담았슈 해당 카테고리에 맞는 선수들을!
		List<Elements> list = worldcupDao.getAllElements(categori);

		//RANK 새로 만들기
		for(Elements e : list) {
			int e_id = e.getId();
			Map<String, Object> map = new HashMap<>();
			map.put("w_id", w_id);
			map.put("e_id", e_id);
			worldcupDao.makeRankEachElements(map);
		}
		
		
		List<ElementsRank> ranklist = worldcupDao.getRankList(w_id);
		
		// 해당되는 선수 가져오기(모든 선수 RANK 만들기)

//		worldcupDao.getAllElements(w_id)

		// 순서대로 가져오기

		return ranklist;
	}

	@Override
	public int getpoint(String id) {
		Map<String, Object> map = new HashMap<>();
		
		Random random = new Random();
        int point = 100 + random.nextInt(401);
		
		map.put("id", id);
		map.put("point", point);
		
		worldcupDao.getPoint(map);
		
		return point;
	}

	@Override
	public String getWorldcupSubCategory(int w_id) {
		return worldcupDao.getWorldcupSubCategory(w_id);
	}
  @Override
	public List<ElementsRank> allworldcuprank(int w_id) {

		// 월드컵 가져오고
		Worldcup worldcup = worldcupDao.getWorldcup(w_id);

		// 해당 월드컵의 카테고리
		String categori = worldcup.getEleCategory();

		// 여기에 몽땅 담았슈 해당 카테고리에 맞는 선수들을!
		List<Elements> list = worldcupDao.getAllElements(categori);

		//RANK 새로 만들기
		for(Elements e : list) {
			int e_id = e.getId();
			Map<String, Object> map = new HashMap<>();
			map.put("w_id", w_id);
			map.put("e_id", e_id);
			worldcupDao.makeRankEachElements(map);
		}
		
		
		List<ElementsRank> ranklist = worldcupDao.getAllRankList(w_id);
		

		return ranklist;
	}

	@Override
	public List<Photo> postworldcuprank(int w_id) {
		
		List<weeklyrank> wlist = worldcupDao.getWeekList(w_id);
		List<Photo> list = new ArrayList<>();
		
		//리스트 1번 월드컵의 기록 싹 가져옴
		for(weeklyrank r : wlist) {
			
			Photo ph = new Photo();
			
			ph.setMonth(r.getMonth());
			ph.setWeek(r.getWeek());
			ph.setYear(r.getYear());
			
			Elements a = worldcupDao.getElements(r.getFirstEleId());	
			Elements b = worldcupDao.getElements(r.getSecondEleId());	
			Elements c = worldcupDao.getElements(r.getThirdEleId());	
			Elements d = worldcupDao.getElements(r.getFourthEleId());	
			Elements e = worldcupDao.getElements(r.getFifthEleId());	
			
			ph.setFn(a.getName());
			ph.setFi(a.getImg());
			ph.setSn(b.getName());
			ph.setSi(b.getImg());
			ph.setTn(c.getName());
			ph.setTi(c.getImg());
			ph.setFon(d.getName());
			ph.setFoi(d.getImg());
			ph.setFin(e.getName());
			ph.setFii(e.getImg());
			System.out.	println(ph.toString());
			list.add(ph);
			
		}
		System.out.println(list.toString());
		
		return list;
  }
}
