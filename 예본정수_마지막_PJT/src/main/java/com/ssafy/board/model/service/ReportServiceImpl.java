package com.ssafy.board.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ssafy.board.model.dao.ReportDao;
import com.ssafy.board.model.dto.Report;

@Service
public class ReportServiceImpl implements ReportService {

	private final ReportDao reportDao;

	public ReportServiceImpl(ReportDao reportDao) {
		this.reportDao = reportDao;
	}

	@Override
	public List<Report> selectAll() {
		return reportDao.selectAll();
	}

	@Override
	public String getContent(String type, int c_id) {
		Map<String, Object> map = new HashMap<>();

		map.put("type", type);
		map.put("c_id", c_id);
		return reportDao.getContent(map);
	}

	@Override
	public Report getReport(int id) {
		return reportDao.getReport(id);
	}

	@Override
	public void insertReport(Report report) {
		reportDao.insertReport(report);
	}
}
