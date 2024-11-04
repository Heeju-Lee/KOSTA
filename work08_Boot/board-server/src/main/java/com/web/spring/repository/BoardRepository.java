package com.web.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.spring.domain.Board;

//@Repository적어야 스프링IOC에 빈으로 등록되는데..
//JpaRepository 상속받으면 어노테이션 생략하더라도 자동으로 빈으로 등록됨
//JpaRepository 는 CRUD함수를 그대로 들고 있다.
public interface BoardRepository extends JpaRepository<Board, Long>{

}
