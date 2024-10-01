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
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.service.domain.MemberVO;
import spring.service.member.MemberDAO;
import spring.service.member.MemberService;
import spring.service.member.impl.MyBatisMemberDAOImpl;


public class MyBatisMemberTestApp3 {

	public static void main(String[] args) throws IOException {
		
		ApplicationContext context =
				new ClassPathXmlApplicationContext(
								new String[] {	"/bean/memberservice.xml"	 }
									                                                    );
		
		//==> IoC Container 로 부터 획득한 UserDAO 인스턴스 획득
		//default id = class name
		MemberService memberService = (MemberService) context.getBean("myBatisMemberServiceImpl");
		
		MemberVO member = new MemberVO("jeolmi3","1234","절미3","종각");
		
		System.out.println("================  registerMember  ================");
		if(memberService.registerMember(member)==0) System.out.println("회원가입된 회원이 없습니다.");
		else System.out.println(member.getName()+"님 생성완료");
		
		System.out.println("================  deleteMember  ================");
		MemberDAO dao = (MemberDAO) context.getBean("myBatisMemberDAOImpl");
		if(dao.deleteMember("jeolmi3")==1) System.out.println("정상적으로 삭제가 완료되었습니다.");
		
		System.out.println("===============  updateMember  =================");
		member.setId("jeolmi4");
		member.setPassword("12345");
		System.out.println(dao.updateMember(member)+"건 업데이트 완료");;
		
		System.out.println("===============  showAllMember  =================");
		List<MemberVO> list = dao.showAllMember();
						list.forEach(c->System.out.println(c));
	
		System.out.println("================  getMember  ================");
		member.setId(null);
		dao.getMember(member);
		list = session.selectList("MemberMapper.getMember",member);
						list.forEach(c->System.out.println(c.toString()));
		
		System.out.println("================  idExist  ================");
		if(dao.idExist("jeolmi5")) System.out.println("해당하는 아이디는 이미 등록된 아이디 입니다.");
		else System.out.println("해당하는 아이디는 사용 가능합니다.");		
		
		System.out.println("================  login  ================");
		member.setId("jeolmi5");
		member.setPassword("1234");
		if(dao.login(member)) System.out.println(member.getName()+"님 로그인 성공~~!!!");
		else System.out.println("로그인에 실패하였습니다.");
		
		session.commit();
		session.close();		
	}
}
