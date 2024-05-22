package com.ssafy.board.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.board.model.dao.DataResetDao;
import com.ssafy.board.model.dao.WorldcupDao;
import com.ssafy.board.model.dto.Elements;
import com.ssafy.board.model.dto.ElementsRank;

import java.util.*;

@Service
public class DataResetServiceImpl implements DataResetService {

//	private final BoardDao boardDao;
	private final WorldcupDao worldcupDao;
	private final DataResetDao dataResetDao;

	@Autowired
	public DataResetServiceImpl(DataResetDao dataResetDao, WorldcupDao worldcupDao) {
		this.dataResetDao = dataResetDao;
		this.worldcupDao = worldcupDao;

	}

	@Override
	public void resetData() {
		List<Integer> cnt = dataResetDao.getNum();
		
		for (int worldId:cnt) {
			
		List<ElementsRank> list = worldcupDao.getRankList(worldId); //여기를 가져올꺼야
		
		Map<String, Object> map = new HashMap<>();
		map.put("w_id", worldId);
		map.put("fir", list.get(0).getElementsId());
		map.put("sec", list.get(1).getElementsId());
		map.put("thi", list.get(2).getElementsId());
		map.put("fou", list.get(3).getElementsId());
		map.put("fif", list.get(4).getElementsId());
				
		dataResetDao.update(map);
		dataResetDao.reset(worldId);
		}
					
	}

}
