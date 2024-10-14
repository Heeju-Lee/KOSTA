package com.web.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.spring.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Long>{
	
	
}
