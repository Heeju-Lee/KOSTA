package com.service.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.spring.dao.MemberDAO;
import com.service.spring.domain.Member;

@Repository
public class MemberService {
	
	@Autowired
	private MemberDAO memberDAO; //setter 필요없다.
	
	public Member selectUser(Member vo) {
		return memberDAO.selectUser(vo);
	}
}
