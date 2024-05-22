package com.ssafy.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.board.model.dto.ElementsRank;
import com.ssafy.board.model.service.CommentService;
import com.ssafy.board.model.service.DataResetService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "dataReset")
public class DataResetController {

	private final DataResetService dataResetService;

	@Autowired
	public DataResetController(DataResetService dataResetService) {
		this.dataResetService = dataResetService;
	}

	@Scheduled(cron = "0 0 0 * * SUN")
	public void resetData() {

		dataResetService.resetData();
		
		System.out.println("일요일이 되었습니다. Ranking을 초기화 합니다.");

	}

}
