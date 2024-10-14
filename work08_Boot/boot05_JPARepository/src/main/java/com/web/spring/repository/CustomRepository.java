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
	
	//findByLastnameAndFirstname
	Optional<Custom> findByNameAndEmail(String name, String email);
	
	//findByLastnameOrFirstname
	List<Custom> findByNameOrEmail(String name, String email);
	
	//고객의 아이디 값이 1~3 사이의 아이디를 가지는 고객을 검색
	List<Custom> findByCustomIdBetween(int start, int end);
	
	//고객의 아이디가 3보다 작은 아이디를 가지는 고객을 검색
	List<Custom> findByCustomIdLessThan(int customId);
	
	//고객의 등록일자가 어제(LocalDateTime) 이후로 등록한 고객을 검색
	List<Custom> findByRegDateAfter(LocalDateTime yesterday);
	List<Custom> findByRegDateBefore(LocalDateTime yesterday);
	
	//고객의 이름이 null값인 고객을 검색
	List<Custom> findByNameIsNull();
	List<Custom> findByNameIsNotNull();
	
	//SELECT custom_id, email, name, password, regDate FROM custom WHERE name LIKE ?
	//와일드 카드 X , 값에 % or _ 지정해줘야 한다.
	List<Custom> findByNameLike(String name);
	
	//SELECT custom_id, email, name, password, regDate FROM custom WHERE name LIKE '%종각'
	List<Custom> findByNameEndingWith(String name);

	//리스트 내림차순 & 오름차순
	List<Custom> findByOrderByCustomIdDesc();
	List<Custom> findByOrderByCustomId();
	
	//고객 아디디가 3보다 큰 아이디를 가지는 고객을 검색 + 아이디를 내림차순 정렬
	//이런식으로 조건검색 뒤에 OrderBy절은 다 붙일 수 있다.
	List<Custom> findByCustomIdGreaterThanOrderByCustomIdDesc(int customId);
	
	//고객 아이디가 1이거나 3이거나 5인 고객을 검색 ... IN
	List<Custom> findByCustomIdIn(List<Integer> ids);
	
	//Not은 null과 비교하지 않는다...null은 출력되지 않는다...!!
	List<Custom> findByNameNot(String name);
}
