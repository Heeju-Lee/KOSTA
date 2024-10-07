package com.service.spring.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.spring.dao.BoardDAO;
import com.service.spring.domain.Board;
import com.service.spring.domain.Member;

@Repository
public class BoardService {
	
	@Autowired
	private BoardDAO boardDAO; //setter 필요없다.
	
	
	public void write(Board board) { 
		boardDAO.write(board); 
	} 
	
	public String selectByNoForDate(int no) {
		return boardDAO.selectByNoForDate(no);
	}
	
	public List<Board> getBoardList(){
		return boardDAO.getBoardList();
	}
	
	public Board showContent(int no) {
		return boardDAO.showContent(no);
	}	
	
	public void deleteBoard(int no) {
		boardDAO.deleteBoard(no);
	}
	
	public void updateCount(int no) {
		boardDAO.updateCount(no);
	}
	
	public void updateBoard(Board board) {
		boardDAO.updateBoard(board);
	}
}

