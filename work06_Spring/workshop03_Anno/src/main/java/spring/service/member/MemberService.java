package spring.service.member;

import java.util.List;

import org.apache.catalina.User;

import spring.service.domain.MemberVO;

//데이타 가공과 연관되는 레이어..
public interface MemberService {
	
	int registerMember(MemberVO member);
	int updateMember(MemberVO member);
	
	List<MemberVO> showAllMember();
	List<MemberVO> getMember(MemberVO member);
}
