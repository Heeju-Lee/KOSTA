package spring.service.member.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.mysql.cj.Session;

import spring.service.domain.MemberVO;
import spring.service.member.MemberDAO;
import spring.service.member.MemberService;

@Service
public class MyBatisMemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDAO memberDAO;
	public void setMemberDAO(MemberDAO member) {
		this.memberDAO = member;
	}

	@Override
	public int registerMember(MemberVO member) {
		int result = memberDAO.registerMember(member);
		return result;
	}

	@Override
	public int updateMember(MemberVO member) {
		int result = memberDAO.updateMember(member);
		return result;
	}

	@Override
	public List<MemberVO> showAllMember() {
		List<MemberVO> list = memberDAO.showAllMember();
		return list;
	}

	@Override
	public List<MemberVO> getMember(MemberVO member) {
		List<MemberVO> list = memberDAO.getMember(member);
		return list;
	}

}
