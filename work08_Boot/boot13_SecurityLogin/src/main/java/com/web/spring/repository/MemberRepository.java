package com.web.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.web.spring.domain.Member; 
import java.util.List;
import java.util.Optional;


public interface MemberRepository extends JpaRepository<Member, Long>{


	@Query(value = "SELECT m FROM Member m WHERE m.id= ?1")
	Member duplicateCheck(String id);
	
	Member findById(String id);//id에 해당하는 멤버를 검색 query method
	
//	Optional<Member> findById(Long memberNo);//상속되어져 있는 함수 

	Boolean existsById(String id);//id에 해당하는 멤버가 있는지 여부를 확인
	
}
