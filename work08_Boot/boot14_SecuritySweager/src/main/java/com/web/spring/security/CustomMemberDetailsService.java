package com.web.spring.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.web.spring.domain.Member;
import com.web.spring.repository.MemberRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomMemberDetailsService implements UserDetailsService{

	private final MemberRepository memberRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//디비연결...MemberRepository 호출
		log.info("UserDetailsService loadUserByUsername...username :: {}",username);//id
		
		Member findMember=memberRepository.findById(username);
		if(findMember != null) {
			log.info("findMember...찾았다!! :: {}",findMember);
			return new CustomMemberDetails(findMember);
		}
		return null;
	}

}


















