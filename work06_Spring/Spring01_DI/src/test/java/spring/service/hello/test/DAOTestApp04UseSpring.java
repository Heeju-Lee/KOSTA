package spring.service.hello.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

import spring.service.dao.MemberDAO;

public class DAOTestApp04UseSpring {

	/// main method
	public static void main(String[] args) {
		
		//1. 주문서를 읽어서 빈을 생성
		// 1)new MemberDAOImpl를 dao라는 이름으로 생성 2)저장)
		BeanFactory factory =
				new XmlBeanFactory( new FileSystemResource
				("./src/main/resources/config/dao.xml") );
		
		System.out.println("=======================================");
		//2. Container 로 부터 dao 의 name 을 갖는 instance return 받기  
		MemberDAO dao = (MemberDAO)factory.getBean("dao");
		dao.register("이희주","인천");
		dao.delete("jeolmi","1234");
		
	}//main
	
}//end of class