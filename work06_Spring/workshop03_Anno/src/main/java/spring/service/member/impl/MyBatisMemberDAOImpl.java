package spring.service.member.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mysql.cj.Session;

import spring.service.domain.MemberVO;
import spring.service.member.MemberDAO;

@Repository
public class MyBatisMemberDAOImpl implements MemberDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public static final String NS = "MemberMapper.";
	
	@Override
	public int registerMember(MemberVO member) {
		int result = sqlSession.insert(NS+"registerMember",member);
		return result;
	}

	@Override
	public int deleteMember(String id) {
		int result = sqlSession.delete(NS+"deleteMember",id);
		return result;
	}

	@Override
	public int updateMember(MemberVO member) {
		int result = sqlSession.delete(NS+"updateMember",member);
		return result;
	}

	@Override
	public List<MemberVO> showAllMember() {
		List<MemberVO> list = sqlSession.selectList(NS+"showAllMember");
		return list;
	}

	@Override
	public List<MemberVO> getMember(MemberVO member) {
		List<MemberVO> list = sqlSession.selectList(NS+"getMember", member);
		return list;
	}

	@Override
	public boolean idExist(String id) {
		boolean result = false;
		MemberVO member = sqlSession.selectOne(NS+"idExist", id);
		
		if(member.getId()!=null) result=true;

		return result;
	}

	@Override
	public boolean login(MemberVO member) {
		boolean result = false;
		member = sqlSession.selectOne(NS+"login", member);
		
		if(member.getId()!=null) result=true;
		
		return result;
	}

}
