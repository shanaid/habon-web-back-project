package com.ssafy.board.model.dao;

import java.util.List;
import java.util.Map;

import com.ssafy.board.model.dto.Report;

public interface ReportDao {

	List<Report> selectAll();

	String getContent(Map<String, Object> map);

	Report getReport(int id);

	void insertReport(Report report);
	
}
