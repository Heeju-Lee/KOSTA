package com.web.spring.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.web.spring.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long>{

	//1. 해당 아이디를 받아오는 기능.....id가 pk가 아닌 unique라서 jpa의 findById를 사용못함
	//JPQL을 사용해서 만들어 보기
	//@Query(value = "SELECT m FROM Member m WHERE m.id= :id")
	@Query(value = "SELECT m FROM Member m WHERE m.id= ?1")//첫번째 파라미터일 때 사용가능
	
	//Member duplicateCheck(@Param("id")String id);//이름이 같으면 @param 생략가능
	Member duplicateCheck(String id);

	//2.아이디가 000이고 패스워드가 000인 사람을 검색
	//JPQL을 사용
	@Query(value = "SELECT m FROM Member m WHERE m.id = :#{#member.id} AND m.pwd = :#{#member.pwd}")
	Member login(Member member);
}
