package com.web.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.web.spring.entity.Board;
import com.web.spring.entity.BoardIF;

public interface BoardRepository extends JpaRepository<Board, Long>{
	
	//자동적으로 findAll()...모든 게시글 받아오기..
	
	/*
	 * JPQL을 사용
	   JPQL은 SQL과 비슷하지만 SQL이 아니다. 객체지향 언어이다.
	   JPQL에서 FROM 절 뒤에는 테이블 명이 아니라 엔터티 이름이 나온다!!!
	 */
	
	//Board 엔터티는 board테이블과 매핑된 객체이기 때문에 결과적으로 board 테이블에 있는 모든 것을 조회
	//@Query(value = "SELECT b FROM Board b")//1. 조인으 사용해야 한번에 연결된 정보를 함께 가져온다.
	//@Query(value = "SELECT b FROM Board b JOIN b.custom")//2. 조인사용
	@Query(value = "SELECT b FROM Board b JOIN FETCH b.custom")//3.조인하면서 연관된 정보를 바로 받아오려면 fetch를 바로 적용해야 한다.
	
    //4. 일반적인 쿼리문은 성능저하를 막을 수 없다.
	//@Query(value = "SELECT b FROM Board b JOIN Custom c ON b.custom.customId=c.customId")//4. 일반적인 조인구문
	//@Query(value = "SELECT b FROM Board b JOIN FETCH Custom c ON b.custom.customId=c.customId")//4. 일반적인 조인구문
	List<Board> getBoards();
	
	//전체 게시글 갯수를 반환하는 쿼리
	@Query(value = "SELECT count(b) FROM Board b") //boardId는 상관없지만 board_id 에러발생
	Long getBoardCount();
	
	//관리자 권한을 가지는 사람이 작성한 게시글 보기
	//@Query(value = "SELECT b FROM Board b JOIN b.custom c JOIN c.roles r WHERE r.name = :roleName")
	//@Query(value = "SELECT b FROM Board b JOIN FETCH b.custom c JOIN c.roles r WHERE r.name = :roleName")
	@Query(value = "SELECT b, c FROM Board b JOIN b.custom c JOIN c.roles r WHERE r.name = :roleName")
	List<Board> getBoards(@Param("roleName")String roleName);
	
	
	/*
	 Native Query
	 DB로 바로 접근한다.
	 벤더 종속적이다. Oracle, MySQL, MSServer
	 복잡한 쿼리라서 JPA로 나타내기 힘든 경우 해법이 될 수 있다.
	 >> board 테이블의 모든 컬럼을 다 받아와야 한다...project 알리야스 적용 안됨.
	 */
	//어떤 사람이 어떤 게시글을 작성했는지 다 볼 수 있는 기능
	@Query(value = "SELECT b.board_id, b.title, b.content, b.regDate, b.custom_id, b.count,"
			+ " c.name FROM board b, custom c WHERE b.custom_id=c.custom_id", nativeQuery = true)
	List<Board> getBoardsNative();
	
	
	//Native Query에서 내가 원하는 project만 지정해 가져오려면 ... Board 사용 못함
	//SELECT절에 나오는 Project를 받아오는 vo를 별도로 작성해야함...>>>>인터페이스로
	@Query(value = "SELECT b.board_id, b.title, b.custom_id, c.name FROM board b, custom c"
			+" WHERE b.custom_id=c.custom_id", nativeQuery = true)
	List<BoardIF> getBoardsNative2();
	
}
