package com.ssafy.board.model.service;

import java.util.List;

import com.ssafy.board.model.dto.Report;

public interface ReportService {

	List<Report> selectAll();

	String getContent(String type, int c_id);

	Report getReport(int id);

	void insertReport(Report report);

}
