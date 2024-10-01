package spring.service.test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import spring.service.domain.MemberVO;


public class MyBatisMemberTestApp {

	public static void main(String[] args) throws IOException {

		MemberVO member = new MemberVO();
		member.setId("jeolmi3");
		member.setPassword("1234");
		member.setName("절미3");
		member.setAddress("종각");
		
		//1&2 설정문서 읽고 factory 생성
		SqlSessionFactory factory = TestUtil.getFactory();
		
		//3) SqlSession 이 factory로부터 생성된다.
		SqlSession session = factory.openSession();
				
		System.out.println("================  registerMember  ================");
		session.insert("MemberMapper.registerMember",member);
		System.out.println(member.getName()+"님 생성완료");
		
		System.out.println("================  deleteMember  ================");
		System.out.println(session.delete("MemberMapper.deleteMember","jeolmi3")+"건 삭제 완료");
		
		System.out.println("===============  updateMember  =================");
		member.setId("jeolmi4");
		member.setPassword("12345");
		System.out.println(session.update("MemberMapper.updateMember",member)+"건 업데이트 완료");;
		
		System.out.println("===============  showAllMember  =================");
		List<MemberVO> list = session.selectList("MemberMapper.showAllMember");
						list.forEach(c->System.out.println(c));
	
		System.out.println("================  getMember  ================");
		member.setName(null);
		
		list = session.selectList("MemberMapper.getMember",member);
						list.forEach(c->System.out.println(c.toString()));
		
		System.out.println("================  idExist  ================");
		member= session.selectOne("MemberMapper.idExist","jeolmi5");
		if(member.getId()==null) System.out.println("해당하는 아이디는 사용 가능합니다.");
		else System.out.println("해당하는 아이디는 이미 등록된 아이디 입니다.");		
		
		System.out.println("================  login  ================");
		member.setId("jeolmi5");
		member.setPassword("1234");
		member = session.selectOne("MemberMapper.login", member);
		
		if(member.getId()==null) System.out.println("로그인에 실패하였습니다.");
		else System.out.println(member.getName()+"님 로그인 성공~~!!!");
		
		session.commit();
		session.close();		
	}
}
