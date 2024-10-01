package spring.service.test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import spring.service.domain.MemberVO;


public class MyBatisMemberTestApp {

	public static void main(String[] args) throws IOException {

		MemberVO member = new MemberVO();
		member.setId("jeolmi5");
		member.setPassword("1234");
		member.setName("절미5");
		member.setAddress("종각");
		
		//1&2 설정문서 읽고 factory 생성
		SqlSessionFactory factory = TestUtil.getFactory();
		
		//3) SqlSession 이 factory로부터 생성된다.
		SqlSession session = factory.openSession();
		
		System.out.println("SqlSession..Creating...");
		System.out.println("================  memberAdd  ================");
		
		//4)
		session.insert("MemberMapper.memberAdd",member);
		System.out.println(member.getName()+"님 생성완료");
		
		System.out.println("================  memberList  ================");
		session.selectList("MemberMapper.memberList")
				.forEach(c->System.out.println(c.toString()));
		
		System.out.println("===============  getMember  =================");
		List<MemberVO> list = session.selectList("MemberMapper.getMember", "j");
							  list.forEach(c->System.out.println(c));
		
		System.out.println("===============  deleteMember  =================");
		int deleteResult = session.delete("MemberMapper.deleteMember", "jeolmi5");
		System.out.println(deleteResult+"건 진행완료");
	
		System.out.println("================  memberList  ================");
		session.selectList("MemberMapper.memberList")
				.forEach(c->System.out.println(c.toString()));
		
		session.commit();
		session.close();		
	}
}
