package com.web.spring.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.spring.dto.BoardReq;
import com.web.spring.dto.BoardRes;
import com.web.spring.entity.Board;
import com.web.spring.service.BoardService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class BoardController_mine {
	private final BoardService boardService;
	

	//전체 게시물 조회 (v)
	@GetMapping("/boards")
	public List<BoardRes> findAll(){	
		return boardService.boardList();
	}

	//글번호에 해당하는 게시물 조회 (v)
	@GetMapping("/boards/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id){
		BoardRes board = boardService.findBoard(id);
		return ResponseEntity.ok(board);		
	}
	

	//게시물 등록 (v)
	@PostMapping("/boards") 
	public ResponseEntity<?> save(@RequestBody BoardReq boardReq){
		Board board1 = boardService.addBoard(boardReq);
		return ResponseEntity.ok(board1);
	}

	//글번호에 해당하는 게시물 수정 (v)
	@PutMapping("/boards/update/{id}")
	public ResponseEntity<?> update(@RequestBody BoardReq boardReq, @PathVariable Long id){
		BoardRes board2 = boardService.updateBoard(id,boardReq);
		return ResponseEntity.ok(board2);		
	}

	//글번호에 해당하는 게시물 삭제 (v)
	@GetMapping("/boards/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		String message = boardService.deleteBoard(id);
		return ResponseEntity.ok(message);
	}
}
