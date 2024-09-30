package spring.service.member;

import java.util.List;

import org.apache.catalina.User;

import spring.service.domain.MemberVO;

public interface MemberDAO {
	
	int registerMember(MemberVO member);
	int deleteMember(String id);
	int updateMember(MemberVO member);
	
	List<MemberVO> showAllMember();
	List<MemberVO> getMember(MemberVO member);
	
	boolean idExist(String id);
	boolean login(MemberVO member);
}
