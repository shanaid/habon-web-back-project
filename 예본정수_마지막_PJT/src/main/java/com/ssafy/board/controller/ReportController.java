package com.ssafy.board.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.board.model.dto.Report;
import com.ssafy.board.model.service.ReportService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api-report")
@Tag(name = "ReportController", description = "신고 민원관리")
@CrossOrigin("http://localhost:5173")
public class ReportController {
	private final ReportService reportService;

	public ReportController(ReportService reportService) {
		this.reportService = reportService;
	}

	@GetMapping("/report")
	public ResponseEntity<List<Report>> getReports() {
		List<Report> list = reportService.selectAll();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("report/{id}")
	public ResponseEntity<Report> getReport(@PathVariable("id") int id) {
		Report report = reportService.getReport(id);

		return new ResponseEntity<>(report, HttpStatus.OK);

	}

	@PostMapping("report/{type}/{c_id}")
	public ResponseEntity<Report> insertReport(@PathVariable("type") String type, @PathVariable("c_id") int c_id,
			@RequestBody Report report) {
		report.setContentType(type);	
		report.setContentId(c_id);
//		report.setContentContent(reportService.getContent(type, c_id));
		System.out.println(report);
		reportService.insertReport(report);

		return new ResponseEntity<>(report, HttpStatus.OK);
	}
}
