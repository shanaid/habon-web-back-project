package com.ssafy.board.model.service;

import java.util.List;

import com.ssafy.board.model.dto.Board;
import com.ssafy.board.model.dto.Elements;
import com.ssafy.board.model.dto.Worldcup;
import com.ssafy.board.model.dto.ElementsRank;
import com.ssafy.board.model.dto.Photo;

public interface WorldcupService {

	public List<Worldcup> selectAll();
	
	public int currentAttempts(int w_id,String u_id);

	public List<Elements> getelements(int w_id, int cnt);

	public void updateRank(int w_id, int e_id);

	public List<ElementsRank> worldcuprank(int w_id);
	
	public List<ElementsRank> allworldcuprank(int w_id);

	public int getpoint(String id);

	public String getWorldcupSubCategory(int w_id); 

	public List<Photo> postworldcuprank(int w_id); 

	
	
	
}
