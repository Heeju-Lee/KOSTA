package com.web.spring;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import com.web.spring.entity.Board;
import com.web.spring.entity.Custom;
import com.web.spring.entity.Role;
import com.web.spring.repository.BoardRepository;
import com.web.spring.repository.CustomRepository;
import com.web.spring.repository.RoleRepository;



@SpringBootApplication
public class Boot07JpqlApplication implements CommandLineRunner{

	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	BoardRepository boardRepository;
	
	@Autowired
	CustomRepository customRepository;
	
	@Override
	@Transactional
	public void run(String... args) throws Exception {
		
		//1. 모든 게시글 검색...findAll()
//		boardRepository.findAll()
//					   .forEach(b->{
//						   System.out.println(b);
//						   System.out.println(b.getCustom());
//					   });
		
		//2. JPQL...getBoards
//		boardRepository.getBoards()
//					   .forEach(b->{
//					   System.out.println(b);
//					   System.out.println(b.getCustom());
//	   });
		
		//2. JPQL....getBoardCount
//		Long boardCount = boardRepository.getBoardCount();
//			System.out.println("전체 게시글의 갯수 ==> "+boardCount);

		//3. admin 권한을 가지는 사람이 작성한 게시글을 다 검색
//		Role role = roleRepository.findById(2).get();//role은 ADMIN 권한을 가지고 있다.
//		System.out.println("Role >>"+role);
		
//		Custom c = new Custom();
//		c.setName("한강");
//		c.setEmail("han@google.com");
//		c.setPassword("7777");
//		c.setRegDate(LocalDateTime.now());
//		c.setRoles(Set.of(role));//사용자의 권한을 주입..set으로
//		
//		customRepository.save(c);//사용자 생성
		
		//4. admin권한을 가지는 14번 사용자가 게시글을 작성하도록
//		Custom c =customRepository.findById(14).get();
//		Board b = new Board();
//		b.setCustom(c);
//		b.setTitle("관리자 권한 작성");
//		b.setContent("관리자 권한을 가지고 있어요.");
//		b.setCount(0);
//		b.setRegDate(LocalDateTime.now());
//		
//		boardRepository.save(b);
		
		//5 관리자 권한을 가지는 사람이 작성한 게시글 보기....	
//		boardRepository.getBoards("ROLE_ADMIN")
//					   .forEach(b->{
//					   System.out.println(b);
//					   System.out.println(b.getCustom());
//		});
		
//		boardRepository.getBoardsNative()
//					   .forEach(b->{
//					   System.out.println(b);
//					   System.out.println(b.getCustom());
//			});

		//proxy :: 인터페이스 기반으로 작성된 클래스를 동적으로(실체로 만들어주는) 생성해주는 자바 문법(reflect 기술 적용되어 있음)
		boardRepository.getBoardsNative2()
					   .forEach(b->{
					   System.out.println(b.getClass().getName());
					   System.out.println(b.getContent());
					   System.out.println(b.getTitle());
					   System.out.println(b.getCustomId());
					   System.out.println(b.getBoardId());
					   System.out.println(b.getName());
					   System.out.println("=================================================");
			});
		
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(Boot07JpqlApplication.class, args);
	}



}
