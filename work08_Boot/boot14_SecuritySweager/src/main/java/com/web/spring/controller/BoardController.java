package com.web.spring.controller;


import java.util.Base64;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.web.spring.domain.Board;
import com.web.spring.domain.Member;
import com.web.spring.dto.BoardReq;
import com.web.spring.dto.BoardRes;
import com.web.spring.jwt.JWTFilter;
import com.web.spring.security.CustomMemberDetails;
import com.web.spring.service.BoardService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@RestController
@Slf4j
public class BoardController {
	private final BoardService boardService;

	   /**
		* 전체 게시물 조회
		* */
		@GetMapping("/boards")
		public ResponseEntity<?> findAll(){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		log.info("authentication = {}" , authentication);

		//시큐리티에 저장된 정보 조회
		String name = authentication.getName();//아이디
		log.info("Authentication getName =  {} " , name);
		log.info("Authentication  authentication.getPrincipal() =  {} " ,  authentication.getPrincipal());
		if(name!=null && !name.equals("anonymousUser")) {
			CustomMemberDetails customMemberDetails = (CustomMemberDetails) authentication.getPrincipal();
			Member m = customMemberDetails.getMember();
			log.info("customMemberDetails =  {} ,{} ,{} ", m.getId(), m.getName(), m.getRole());


			Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

			Iterator<? extends GrantedAuthority> iter = authorities.iterator();
			while (iter.hasNext()) {
				GrantedAuthority auth = iter.next();
				String role = auth.getAuthority();
				log.info("Authentication role =  {} ", role);
			}

		}

			return new ResponseEntity<>(boardService.findAllBoard(),HttpStatus.OK);
		}

		/**
		 * 글번호에 해당하는 게시물 조회
		 * */
		@GetMapping("/boards/{id}")
		public ResponseEntity<?> findById(@PathVariable Long id){
			Board board = boardService.findBoard(id);

			//return new ResponseEntity<>(board ,HttpStatus.OK);
			/////////////////////////////////////////////////////
			BoardRes boardRes = new BoardRes(board);
			return new ResponseEntity<>(boardRes ,HttpStatus.OK);
		}
	    /**
		 * 게시물 등록
		 * */
		@PostMapping("/boards/board")
		public ResponseEntity<?> save(@RequestBody BoardReq board){
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			String name = authentication.getName();
			if(name!=null && !name.equals("anonymousUser")) {
				CustomMemberDetails customMemberDetails=(CustomMemberDetails) authentication.getPrincipal();
				Member m = customMemberDetails.getMember();
				if(m.getMemberNo()==board.getMemberNo()) {
					return new ResponseEntity<>(boardService.addBoard(board),HttpStatus.CREATED);//201
				}
			}
			return new ResponseEntity<>(boardService.addBoard(board),HttpStatus.FORBIDDEN);//403
		}

		/**
		 * 글번호에 해당하는 게시물 수정
		 */
		@PutMapping("/boards/{id}")
		public ResponseEntity<?> update(@PathVariable Long id,@RequestBody BoardReq board, @RequestHeader("Authorization") String jwtToken){
					
			System.out.println("id = " + id);
			Board updatedBoard = boardService.updateBoard(id, board);
			System.out.println("updatedBoard = " + updatedBoard);
			
			BoardRes br = BoardRes.builder()
					.title(updatedBoard.getTitle())
					.regDate(updatedBoard.getRegDate().toString())
					.content(updatedBoard.getContent())
					.id(updatedBoard.getId()).build();
			return new ResponseEntity<>(br,HttpStatus.OK);
		}
		/**
		 * 글번호에 해당하는 게시물 삭제
		 * */
		@DeleteMapping("/boards/{id}")
		public ResponseEntity<?> delete(@PathVariable Long id){		
			return new ResponseEntity<>(boardService.deleteBoard(id),HttpStatus.OK);
		}
	}




