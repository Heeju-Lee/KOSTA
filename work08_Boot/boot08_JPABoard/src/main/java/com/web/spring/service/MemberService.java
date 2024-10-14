package com.web.spring.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.spring.entity.Member;
import com.web.spring.exception.MemberAuthenticationException;
import com.web.spring.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

/*
 final 이 붙은 필드를 생성자로 자동주입하는 롬복 어노테이션 @RequiredArgsConstructor
 이 방법은 스프링에서 공식적으로 추천하는 ...라이프 사이클이 같을 때..주입하는 생성자 주입
 
 한번 주입받은 객체는 프로그램이 끝날때까지 변하지 않는 특징을 가지고 있으므로
 불변성....immutable 로 표시해주는 것이 정확하다....
 그래서 MemberRepository 앞에 final 키워드를 붙인다.
 */

@Service
@RequiredArgsConstructor
public class MemberService {
	
	
	private final MemberRepository memberRepository;
	
	// 회원가입, 중복체크, 로그인
	@Transactional
	public void signUp(Member member) {
		Member rMember = memberRepository.save(member);//동일한 ID가 입력되면 --> 중복에러 발생
		System.out.println("return Member ==> "+rMember);
	}
	
	@Transactional(readOnly = true)
	public String duplicateCheck(String id) {
		Member rMember=memberRepository.duplicateCheck(id);
		System.out.println("return Member ==> "+rMember);
		
		if(rMember==null) return "아이디 사용 가능!!";
		else return "아이디 사용 불가!!";
	}
	
	@Transactional(readOnly = true)
	public Member signIn(String id, String pwd) {
		Member rMember = memberRepository.duplicateCheck(id);
		if(rMember==null) 
			throw new MemberAuthenticationException("아이디를 다시 확인하세요", "Wrong ID~~!!");
		if(!rMember.getPwd().equals(pwd))
			throw new MemberAuthenticationException("비밀번호를 다시 확인하세요", "Wrong PWD~~!!");
		return rMember;
	}


}
