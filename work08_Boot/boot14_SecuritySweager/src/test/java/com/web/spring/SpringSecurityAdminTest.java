package com.web.spring;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Commit;

import com.web.spring.domain.Member;
import com.web.spring.repository.MemberRepository;

import jakarta.transaction.Transactional;

@SpringBootTest
@Transactional
@Commit
public class SpringSecurityAdminTest {
	@Autowired
	private MemberRepository memberRepository;	
	@Autowired
	private PasswordEncoder passwordEncoder;	
	@Test
	void adminInsert() {
		String encPwd=passwordEncoder.encode("admin");
		memberRepository.save(Member.builder()
								.id("admin")
								.pwd(encPwd)
								.role("ROLE_ADMIN")
								.address("뉴욕")
								.name("제임스")
								.build());
	}
}
