package com.web.spring.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.spring.domain.Board;
import com.web.spring.service.BoardService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class BoardController {
	
	private final BoardService boardService;
	
	@CrossOrigin
	@PostMapping("/boards")
	public ResponseEntity<?> save(@RequestBody Board board){		
		return new ResponseEntity<>(boardService.addBoard(board),HttpStatus.CREATED);//201
	}
	
	//외부에서 들어오는 자바스크립트 요청을 허용한다.
	@CrossOrigin
	@GetMapping("/boards")
	public ResponseEntity<?> findAll(){		
		return new ResponseEntity<>(boardService.findAllBoard(),HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping("/boards/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id){		
		return new ResponseEntity<>(boardService.findBoard(id),HttpStatus.OK);
	}
	
	@CrossOrigin
	@PutMapping("/boards/{id}")
	public ResponseEntity<?> update(@PathVariable Long id,@RequestBody Board board){		
		return new ResponseEntity<>(boardService.updateBoard(id, board),HttpStatus.OK);
	}
	
	@CrossOrigin
	@DeleteMapping("/boards/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){		
		return new ResponseEntity<>(boardService.deleteBoard(id),HttpStatus.OK);
	}
}






