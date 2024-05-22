package com.ssafy.board.model.dao;

import java.util.List;
import java.util.Map;


public interface DataResetDao {
	

	public List<Integer> getNum();
	
	public void update(Map<String, Object> map);

	public void reset(int worldId);

}
