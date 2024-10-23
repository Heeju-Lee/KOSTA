package com.web.spring.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.spring.domain.Member;
import com.web.spring.exception.MemberAuthenticationException;
import com.web.spring.repository.MemberRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberService {

	private final MemberRepository memberRepository;
	private final PasswordEncoder passwordEncoder;
	
	// 회원가입, 중복체크, 
	@Transactional
	public void signUp(Member member) {
		if(memberRepository.existsById(member.getId()))
			throw new MemberAuthenticationException("중복된 아이디!!", "Duplicated ID!!");
		
		//비번 암호화
		String encPwd=passwordEncoder.encode(member.getPwd());
		log.info("encPwd ==> { }",encPwd);
		member.setPwd(encPwd);
		
		//Role 설정
		member.setRole("ROLE_USER");//지금은 앞부분에 ROLE_를 지정해주지 않는다!!
		
		Member savedMember=memberRepository.save(member);
		log.info("savedMember ==> { }",savedMember);
	}
	
	@Transactional(readOnly = true)
	public String duplicateCheck(String id) {
		Member rMember=memberRepository.duplicateCheck(id);
		log.info("rMember ==> { }",rMember);
		if(rMember==null || rMember.equals("")) return "아이디 사용 사능!!";
		else return "아이디 사용 불가!!";
	}
}






















