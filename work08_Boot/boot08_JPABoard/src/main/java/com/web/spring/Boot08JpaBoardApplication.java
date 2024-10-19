package com.web.spring;


import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import com.web.spring.entity.Member;
import com.web.spring.repository.BoardRepository;
import com.web.spring.repository.MemberRepository;
import com.web.spring.service.MemberService;

@SpringBootApplication
public class Boot08JpaBoardApplication implements CommandLineRunner{

	@Autowired
	MemberRepository memberRepository;
	
	@Autowired
	MemberService memberService;
	
	@Autowired
	BoardRepository boardRepository;
		
	@Override
	@Transactional
	public void run(String... args) throws Exception {
	
//		//1. Builder 패턴으로 member 생성
//		Member m = Member.builder()
//				         .id("hong")
//				         .pwd("1234")
//				         .address("종각")
//				         .name("홍종각")
//				         .regDate(LocalDateTime.now()).build();
		

//		Member loginM1 = memberRepository.login(m);
//		System.out.println("login 한 회원 1>>>"+loginM1);
		
		//2. 아이디가 hong인 사람검색
//		Member findM = memberRepository.duplicateCheck("kim");
//		System.out.println("아이디가 hong>>>"+findM);
		
		//3. 아이디가 hong이고 패스워드 1234인 사람을  검색
//		Member loginM2 = memberRepository.login(findM);
//		System.out.println("login 한 회원 2>>>"+loginM2);

		//4. 
//		Member m = Member.builder()
//					.id("hong")
//			        .pwd("1234").build();
//        
//		memberService.signUp(m);
		
		//5. 모든 게시물 검색...이때 작성자 정보도 함께 검색
//		boardRepository.boardList()
//						.forEach(b->{
//							System.out.println(b);
//							System.out.println(b.getMember());
//						});
		
//		boardRepository.findAll()
//						.forEach(b->{
//						System.out.println(b);
//						System.out.println(b.getMember());
//					});
		
		//6. 특정한 작성자가 쓴 게시물 검색
//		boardRepository.getBoard("hong")
//						.forEach(b->{
//						System.out.println(b);
//						System.out.println(b.getMember());
//					});
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Boot08JpaBoardApplication.class, args);
		
	}



}
