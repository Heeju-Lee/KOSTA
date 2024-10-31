package com.web.spring.service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException.BadRequest;

import com.web.spring.dto.BoardReq;
import com.web.spring.dto.BoardRes;
import com.web.spring.entity.Board;
import com.web.spring.exception.BoardSearchNotException;
import com.web.spring.exception.DMLException;
import com.web.spring.repository.BoardRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor /// final 로 주입시 필수
public class BoardService {
	private final BoardRepository boardRepository;
	
	//addBoard()
	@Transactional
	public Board addBoard(BoardReq boardReq) {
		System.out.println("BoardReq==>"+boardReq);
		
		Board board = boardReq.toBoard(boardReq);//DTO ==> entity로 전환
		System.out.println("toBoard==>"+board);
		
		//save 하고나서 다시 entity를 반환한다.
		return boardRepository.save(board);
	}
	
	//findBoard(Long id)
	/*
	 * 하나의 게시글을 못찾으면 예외처리 
	 * 찾으면 Board를 바로 반환
	 * 	최종적으로 리턴하기 전에 BoardRes 변환해서 반환
	 */
	@Transactional(readOnly = true)
	public BoardRes findBoard(Long id) throws BoardSearchNotException{
		Board board = boardRepository.findById(id)
									.orElseThrow(()->new BoardSearchNotException("게시글번호를 확인하세요", "Not Found BoardSearchNot"));
		return new BoardRes(board);
	}
	
	//getBoard(String memberId)
	/*
	 * 특정회원이 작성한 게시글을 못찾으면 예외처리...
	 * 찾으면 List<Board>를 바로 반환
	 * 
	 * 최종적으로 리턴하기 전에 BoardRes collection으로 변환해서 반환
	 * 
	 * ::
	 * 람다식 적용.
	 */
	@Transactional(readOnly = true)
	public List<BoardRes> getBoard(String memberId) throws BoardSearchNotException{
		List<Board> list =boardRepository.getBoard(memberId);
		
		if(list==null || list.isEmpty()) {
			throw new BoardSearchNotException("특정 회원이 작성한 글이 없습니다.","Not Found BoardAll");
		}
		return list.stream().map(BoardRes::new).collect(Collectors.toList()); 						
	}
	
	
	//findAll..... 성능상 안좋다.
	//boardList()
	@Transactional(readOnly = true)
	public List<BoardRes> boardList() throws BoardSearchNotException{
		List<Board> list = boardRepository.boardList();
		
		if(list==null || list.isEmpty()) {
			throw new BoardSearchNotException("전체게시글이 없습니다.","Not Found BoardAll");
		}
		return list.stream().map(BoardRes::new).collect(Collectors.toList()); 		
	}
	
	//updateBoard(Long id, BoardReq board)
	//하나의 게시물을 받아와서...필드 변경....entity 와 snapshot이 달라진다.
	//감지하면 변경됨.
	@Transactional
	public BoardRes updateBoard(Long id, BoardReq board) throws DMLException{
		Board boardEntity = boardRepository.findById(id)
							.orElseThrow(()->new DMLException("글번호 오류로 수정에 실패", "Not Update~~!"));	
		
		boardEntity.setTitle(board.getTitle());
		boardEntity.setContent(board.getContent());
		
		return new BoardRes(boardEntity);
	}
	
	
	//deleteBoard(Long id)......성공/ 실패
	@Transactional
	public String deleteBoard(Long id) {
		Board boardEntity = boardRepository.findById(id)
				.orElseThrow(()->new DMLException("글번호 오류로 삭제 실패", "Not Delete~~!",HttpStatus.BAD_REQUEST));	
		
		
		boardRepository.delete(boardEntity);
		
		return "OK";		
	}
}
