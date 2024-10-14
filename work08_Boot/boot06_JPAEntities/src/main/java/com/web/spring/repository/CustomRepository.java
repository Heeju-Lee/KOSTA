package com.web.spring.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.web.spring.entity.Custom;

/**
 * Spring Data JPA Repository...이전의 DAO와 같은 역할
 * 인터페이스가 나오면 해당 인터페이스를 구현한 실체 클래스를 다시 상속받아서 작성해야 하지만
 * Spring Data JPA 기술은 인터페이스를 구현하는 빈 클래스를 자동으로 생성시켜준다. 즉, 안해도 된다.
 */
public interface CustomRepository extends JpaRepository<Custom, Integer>{
	//아무것도 작성하지 않아도 기본적인 CRUD가 다 들어있다.
	
	//JPA Query Method...추가
	/*
	 JPA Query Method
	 1. 대부분 findBy로 시작
	 2. 이름 규칙만 잘 정해주면 자동으로 SQL 구문이 실행
	 3. ORM 방식이기 때문에 함수명은 CamelCase가 기본이다.
	 */
	
	Optional<List<Custom>> findByName(String name);
	Optional<Custom> findByNameAndEmail(String name, String email);
	List<Custom> findByNameOrEmail(String name, String email);
	List<Custom> findByCustomIdBetween(int start, int end);
	List<Custom> findByCustomIdLessThan(int customId);
	List<Custom> findByRegDateAfter(LocalDateTime yesterday);
	List<Custom> findByRegDateBefore(LocalDateTime yesterday);
	List<Custom> findByNameIsNull();
	List<Custom> findByNameIsNotNull();
	List<Custom> findByNameLike(String name);
	List<Custom> findByNameEndingWith(String name);
	List<Custom> findByOrderByCustomIdDesc();
	List<Custom> findByOrderByCustomId();
	List<Custom> findByCustomIdGreaterThanOrderByCustomIdDesc(int customId);
	List<Custom> findByCustomIdIn(List<Integer> ids);
	List<Custom> findByNameNot(String name);
}
