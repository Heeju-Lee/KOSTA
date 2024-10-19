//package com.web.spring.controller;
//
//import java.util.List;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.web.spring.dto.BoardReq;
//import com.web.spring.dto.BoardRes;
//import com.web.spring.service.BoardService;
//
//import lombok.RequiredArgsConstructor;
//
//@RestController
//@RequiredArgsConstructor
//public class BoardController_solve {
//	private final BoardService boardService;
//	
//		//전체 게시물 조회
//		@GetMapping("/boards")
//		public ResponseEntity<?> findAll(){
//			return new ResponseEntity<>(boardService.boardList(),HttpStatus.OK);
//		}
//		//특정한 사람이 작성한 게시물 조회
//		@GetMapping("/boards/member/{memberId}")
//		public ResponseEntity<?> getBoard(@PathVariable String memberId){
//			return new ResponseEntity<>(boardService.getBoard(memberId),HttpStatus.OK);
//		}
//		// 글번호에 해당하는 게시물 조회
//		@GetMapping("/boards/{id}")
//		public ResponseEntity<?> findById(@PathVariable Long id){
//			return new ResponseEntity<>(boardService.findBoard(id),HttpStatus.OK);
//		}
//	    //게시물 등록
//		@PostMapping("/boards")
//		public ResponseEntity<?> save(@RequestBody BoardReq board){
//
//			return new ResponseEntity<>(boardService.addBoard(board),HttpStatus.CREATED);//201
//		}
//
//		//글번호에 해당하는 게시물 수정
//		@PutMapping("/boards/{id}")
//		public ResponseEntity<?> update(@PathVariable Long id,@RequestBody BoardReq board){
//			System.out.println("id = " + id);
//			return new ResponseEntity<>(boardService.updateBoard(id, board),HttpStatus.OK);
//		}
//		//글번호에 해당하는 게시물 삭제		
//		@DeleteMapping("/boards/{id}")
//		public ResponseEntity<?> delete(@PathVariable Long id){		
//			return new ResponseEntity<>(boardService.deleteBoard(id),HttpStatus.OK);
//		}
//
//}
