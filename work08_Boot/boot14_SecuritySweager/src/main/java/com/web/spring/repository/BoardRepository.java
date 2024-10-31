package com.web.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.web.spring.domain.Board;

public interface BoardRepository extends JpaRepository<Board, Long>{
 
	// 모든 게시글 정보 받아오기....작성자 정보도 함께..findAll
	@Query(value = "select b from Board b join fetch b.member")
	List<Board> boardList();
	
	//특정한 작성자가 쓴 모든 게시물 정보를 검색...id
	//@Query(value = "select b from Board b join fetch b.member m where m.id=?1")
	@Query(value = "select b from Board b join fetch b.member m where m.id= :id")
	List<Board> getBoard(@Param("id") String id);
}













