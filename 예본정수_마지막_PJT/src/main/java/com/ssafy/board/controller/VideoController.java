package com.ssafy.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.board.model.dto.Video;
import com.ssafy.board.model.service.VideoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api-video")
@Tag(name = "VideoRestController", description = "비디오관리")
@CrossOrigin("http://localhost:5173")
public class VideoController {
	private final VideoService videoService;

	@Autowired
	public VideoController(VideoService videoService) {
		this.videoService = videoService;
	}

	@GetMapping("/video")
	@Operation(summary = "비디오 조회", description = "id별로 정렬")
	public ResponseEntity<List<Video>> list() {

		List<Video> list = videoService.selectAll();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/video/{order}")
	@Operation(summary = "비디오 조회", description = "'조회수' 면 조회수별 정렬, '부위별' 이면 부위별 정렬")
	public ResponseEntity<List<Video>> list(@Parameter(description = "정렬조건") @PathVariable("order") String con) {

		if (con.equals("조회수") || con.equals("부위별")) {
			List<Video> list = videoService.selectCon(con);
			return new ResponseEntity<>(list, HttpStatus.OK);
		}

		else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}
	
	@GetMapping("/video/detail/{id}")
	public ResponseEntity<Video> getVideo(@PathVariable("id") int id){
		Video video = videoService.selectOne(id);
		
		return new ResponseEntity<Video>(video, HttpStatus.OK);
		
	}
}
