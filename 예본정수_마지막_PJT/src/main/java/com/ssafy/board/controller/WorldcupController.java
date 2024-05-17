package com.ssafy.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.board.model.dto.Board;
import com.ssafy.board.model.dto.Comment;
import com.ssafy.board.model.dto.Elements;
import com.ssafy.board.model.dto.User;
import com.ssafy.board.model.dto.Worldcup;
import com.ssafy.board.model.service.NoticeboardService;
import com.ssafy.board.model.service.WorldcupService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api-Worldcup")
@Tag(name = "Worldcup Controller", description = "월드컵 조회")
@CrossOrigin("http://localhost:5173")
public class WorldcupController {
	
	private final WorldcupService worldcupService;
//	
	@Autowired
	private ResourceLoader loader;
//
	@Autowired
	public WorldcupController(WorldcupService worldcupService) {
		this.worldcupService = worldcupService;
	}
	
	@GetMapping("/noticeboard")
	@Operation(summary = "게시판 전체 목록 가져오기", description = "월드컵 정보를 땅겨옴")
	public ResponseEntity<List<Worldcup>> selectAllNoticeboard(){
		List<Worldcup> list = worldcupService.selectAll();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@GetMapping("/noticeboard/{worldId}/{cnt}")
	@Operation(summary = "월드컵 선택")
	public ResponseEntity<?> get(@PathVariable("worldId") int w_id,@PathVariable("cnt") int cnt, HttpSession session) {
		
		if (session.getAttribute("loginUser") != null) {
			
			User login = (User) session.getAttribute("loginUser");
			
			//참여 횟수가져오기 & 검사 -> 유저가 이거 참여 가능?
			int partcnt = worldcupService.currentAttempts(w_id,login.getId());
			
			if(partcnt > 3) {//기회 3번 다 썻다면
				String msg = "이번주는 해당 월드컵 3번만 참여 가능합니다.";
				return new ResponseEntity<String>(msg, HttpStatus.BAD_REQUEST);
			}
			//기회가 남았다면
				
			// 그 카테고리에 속한 운동 선수 데려오고 -> 1,2군 생각해보기 가능한지
			List<Elements> list = worldcupService.getelements(w_id ,cnt);
			if(list.size()!=cnt) {
				String msg = "해당 수의 데아터가 없습니다. 적은 수의 월드컵을 이용하세요";
				return new ResponseEntity<String>(msg, HttpStatus.BAD_REQUEST);
			}

			return new ResponseEntity<List<Elements>>(list,HttpStatus.OK);
			
		} else {
			String msg = "너 로그인 안됐어!";
			return new ResponseEntity<String>(msg, HttpStatus.BAD_REQUEST);
		}

		
		
		
		// 엘리먼츠 리스트에 가져오기 -> 몇명인지 조사 하는데 여기서 사용자 입력이 들어가
		
		//, 랜덤으로 한번 정렬하기
		
		// 
		
		
//			List<Elements> list = worldcupService.selcetWorldcup(w_id);
//			return new ResponseEntity<List<Worldcup>>(list, HttpStatus.OK);
	}
	

	
	
}
