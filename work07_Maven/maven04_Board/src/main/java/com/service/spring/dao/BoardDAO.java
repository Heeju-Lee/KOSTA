package com.service.spring.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.spring.domain.Board;
import com.service.spring.domain.Member;

@Repository
public class BoardDAO {
	
	@Autowired
	private SqlSession sqlSession; //setter 필요없다.
	
	public static final String NS = "ns.sql.Board.";
	
	public void write(Board board) {
		sqlSession.insert(NS+"write",board);
	}
	
	public String selectByNoForDate(int no) {
		return sqlSession.selectOne(NS+"selectByNoForDate",no);
	}
	
	public List<Board> getBoardList(){
		List<Board> list = sqlSession.selectList(NS+"getBoardList");
		return list;
	}
	
	public Board showContent(int no) {
		Board board = sqlSession.selectOne(NS+"showContent",no);
		return board;
	}	
	
	public void deleteBoard(int no) {
		System.out.println(sqlSession.delete(NS+"deleteBoard",no)+"건 삭제완료");
	}
	
	public void updateCount(int no) {
		System.out.println(sqlSession.update(NS+"updateCount",no)+"count up");
	}
	
	public void updateBoard(Board board) {
		System.out.println(sqlSession.delete(NS+"updateBoard",board)+"건 수정완료");
	}
}

