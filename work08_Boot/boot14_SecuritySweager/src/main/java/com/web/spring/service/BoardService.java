package com.web.spring.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.spring.dto.BoardReq;
import com.web.spring.dto.BoardRes;
import com.web.spring.domain.Board;
import com.web.spring.exception.BoardSearchNotException;
import com.web.spring.exception.DMLException;
import com.web.spring.repository.BoardRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {
	final BoardRepository boardRepository;
	
	@Transactional
	public Board addBoard(BoardReq boardReq) {
		System.out.println("BoardReq==>"+boardReq);
		Board board=boardReq.toBoard(boardReq); //DTO--> Entity로 변경
		System.out.println("toBoard==>"+board);
		
		//save 하고나서 다시 Entity를 반환한다..
		return boardRepository.save(board);
	}
	
	/*
	 못찾는 경우에 예외처리를 한다.
	 찾으면 반환
	 만약에 못찾으면 예외를 발생해서 던진다.
	 */
	@Transactional(readOnly = true)
	public Board findBoard(Long id) throws BoardSearchNotException{
		return boardRepository.findById(id)
		.orElseThrow(()-> new BoardSearchNotException("글번호를 확인하세요", "Not Found BoardSearchById"));
	}
	
	@Transactional(readOnly = true)
	public List<BoardRes> getBoard(String memberId) throws BoardSearchNotException{
		List<Board> list =  boardRepository.getBoard(memberId);
		if(list==null || list.isEmpty())
				throw new BoardSearchNotException("특정 회원이 작성한 글이 없습니다.", "Not Found Board All");
		
		return list.stream().map(BoardRes::new).collect(Collectors.toList());
	}
	
	//이런 쿼리는 성능상 문제가 많다...사용자 쿼리를 그래서 사용해야 한다.
	@Transactional(readOnly = true)
	public List<BoardRes> findAllBoard() throws BoardSearchNotException {
		//List<Board> list = boardRepository.findAll();
		List<Board> list = boardRepository.boardList();


		//orders.stream().map(SimpleOrderDto::new).collect(Collectors.toList());
		//Lis<Board>
		System.out.println("--------------------------------------------");
		if(list ==null || list.isEmpty())
			throw new BoardSearchNotException("전체게시물이 없습니다.", "Not Found Board All");

		return list.stream().map(BoardRes::new).collect(Collectors.toList());
	}
	
	@Transactional
	public Board updateBoard(Long id,BoardReq board)  throws DMLException{

		Board boardEntity = boardRepository.findById(id)
				      .orElseThrow(()->new DMLException("글번호로 오류로 수정되지 않았습니다.", "Not Update"));
		
		boardEntity.setTitle(board.getTitle());
		boardEntity.setContent(board.getContent());
		return boardEntity;
	}
	
	@Transactional
	public String deleteBoard(Long id) {
		//오류가 터지면 예외를 탄다..신경쓰지 말고..
		System.out.println("id = " + id);
		boardRepository.findById(id).orElseThrow(()->
				 new DMLException("글번호 오류로 삭제 되지 않았습니다.", "Not DELETE" ,HttpStatus.BAD_REQUEST ));

		boardRepository.deleteById(id);

		return "ok";
	}
}
























