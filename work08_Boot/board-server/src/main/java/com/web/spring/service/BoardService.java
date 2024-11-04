package com.web.spring.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.spring.domain.Board;
import com.web.spring.exception.BoardSearchNotException;
import com.web.spring.exception.DMLException;
import com.web.spring.repository.BoardRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BoardService {
	
	private  final BoardRepository boardRepository;
	
	@Transactional//함수가 종료될때 commit, rollback할지 관리
		public Board addBoard(Board board) {		
		//save하고나서 저장한 엔터티를 다시 리턴한다. 소스 확인
		return boardRepository.save(board);
	}
	
	/*
	 못찾는 경우에 예외처리를 한다.
	 찾으면 반환
	 만약에 못찾으면 예외를 발생해서 던진다.
	public Board findBoard(Long id) {				
		return boardRepository.findById(id)
				.orElseThrow(new Supplier<IllegalArgumentException>() {

					@Override
					public IllegalArgumentException get() {						
						return new IllegalArgumentException("ID를 확인해주세여");
					}
				});
	}
  */
	
	
	//IllegalArgumentException -> BoardSea~~ 변경
	@Transactional(readOnly = true)
	public Board findBoard(Long id) {				
		return boardRepository.findById(id)
				.orElseThrow(()->new BoardSearchNotException("글번호를 확인해주세여", "Not Found Number!"));
	}
	
	@Transactional(readOnly = true)
	public List<Board> findAllBoard() {
		List<Board> list =  boardRepository.findAll();
		if(list==null || list.isEmpty())
			throw new BoardSearchNotException("전체 게시물이 없습니다.", "Not Found Board All!");
		return list;
	}
	
	@Transactional
	public Board updateBoard(Long id,Board board) {
		//더티체킹
		//boardEntity는 영속화 컨텍스트..스프링 내부 메모리 공간에 저장되어 있다.별도로
		//이걸 영속성 JPA라 한다. 이걸 다시 수정해서 리턴한다.
		//updateBoard 함수가 종료될떄 즉 트랜잭션이 종료될때 영속화된 객체를 디비로 다시 갱신해준다
		//이것이 바로 Flush
		//함수종료 ==> 트랜잭션종료 => 영속화 되어있는 데이타를 디비로 갱신(flush)===>더티체킹
		Board boardEntity = boardRepository.findById(id)
				      .orElseThrow(()->new DMLException("작성 글 수정이 실패했습니다.","Update Board Fail~!!"));
		
		boardEntity.setTitle(board.getTitle());
		boardEntity.setAuthor(board.getAuthor());
		return boardEntity;
	}
	
	@Transactional
	public String deleteBoard(Long id) {
		boardRepository.findById(id)
			.orElseThrow(()->new DMLException("작성 글 삭제에 실패했습니다.","Delete Board Fail~!!"));
				
		boardRepository.deleteById(id);
		return "ok";
	}
}
