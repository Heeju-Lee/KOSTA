package com.web.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.web.spring.entity.Board;
import com.web.spring.repository.BoardRepository;
import com.web.spring.repository.CustomRepository;
import com.web.spring.repository.RoleRepository;

import jakarta.transaction.Transactional;

@SpringBootApplication
public class Boot06JpaEntitiesApplication implements CommandLineRunner{

	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private CustomRepository customRepository;
	
	@Autowired
	private BoardRepository boardRepository;
	
	@Override
	@Transactional
	public void run(String... args) throws Exception {
		//1. 모든 Role 정보를 받아온다.
//		roleRepository.findAll()
//			.forEach(c->System.out.println(c));
		
		//2. 모든 Custom 정보를 받아온다.
//		customRepository.findAll()
//						.forEach(c->System.out.println(c));
		
		//3.
		/*
		 findAll() = select * from custom; //한번의 쿼리로 전체 Custom을 받아온다.
		 c.getRoles() --> select * from custom_role join role where custom_id=? //아이디 개수가 n개면 n번 돈다.
		 
		 이런 문제상황을 우리는 N + 1 문제라고 한다.
		 만약에 Custom 레코드 수가 많다면 심각한 성능 저하에 빠진다.
		 
		 연관관계가 설정된 엔터티를 조회할 경우,  findAll로 조회할 경우 데이터의 갯수(n)만큼의 join select절이 계속적으로 실행된다.
		 
		 
		 Custom --> custom_role --> role 여기안에 있는 데이타를 한번의 쿼리문으로 받아올 수 없는건가?    
		 */
//		customRepository.findAll()
//						.forEach(c->{
//							System.out.println(c);
//							System.out.println(c.getRoles());
//						});
		
		//3. 모든 Board 정보를 받아온다.
		//findAll 에서는 Board 정보만 받아오고 싶지만 fetchType:EAGER로 잡혀져 있어서 함께 나온다......LAZY로 변경하면 된다.
//		boardRepository.findAll()
//					   .forEach(b->System.out.println(b));
		
		//4. Custom정보를 별도로 받아오겠다.
//		boardRepository.findAll()
//						.forEach(b->{
//							System.out.println(b);
//							System.out.println(b.getCustom());
//							System.out.println("-------------------------------");
//						});
		
		//5. 
		/*
		 * findAll인 경우 - fetchType EAGER, LAZY 방식 모두다 조인이 안걸린다.
		 * 하지만 한건의 데이타를 가지고 오는 경우 ...findById()....
		 * EAGER 방식에서 LEFTJOIN이 걸린다.
		 * 
		 * 전체검색 / 한건 검색이 서로 다르게 동작한다......
		 * 
		 * 엔터티가 결합ㄷ괸 관계에서 굳이 함께 가져와야 하는 필요가 없는 경우!!
		 * LAZY 방식으로 가져온다.(성능해결가능)
		 * 반면에 데이터를 함께 가져와하는 경우에는 (게시판 글정보와 함께 글쓴이 정보)에는 
		 * 특히 한건의 데이터를 직접적으로 받아와야하는 경우에는 EAGER
		 * 
		 */
		Board board = boardRepository.findById(1L).get();
		System.out.println(board);
		System.out.println(board.getCustom());
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(Boot06JpaEntitiesApplication.class, args);
	}



}
