package com.service.spring;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.services.spring.dao.MyProductDAO;
import com.services.spring.domain.MyProduct;
import com.services.spring.service.MyProductService;

public class MyBatisDITest {
	
	ApplicationContext factory =
			new ClassPathXmlApplicationContext("/bean/beans.xml");
	
	//myBatis와 DI연동 부분의 단위테스트...빈 설정문서를 읽어야 함.
	@Test
	public void addTest() throws Exception{

		//IOC로부터 MyProductDAO, MyProductService 객체를 반환
		//어노테이션을 했기 때문에 경로가 아닌 클래스명
		MyProductDAO dao = (MyProductDAO) factory.getBean("myProductDAO");
		MyProductService service = (MyProductService) factory.getBean("myProductService");
		MyProduct pvo = new MyProduct("공기청정기3","LG",2000000);
		
		System.out.println("========== addProduct ==========");
		dao.addProduct(pvo);//sqlSession의 insert()호출 --> DB 작업함.
		
	}
	
	@Test
	public void findTest() throws Exception{
		MyProductService service = (MyProductService) factory.getBean("myProductService");
		System.out.println("========== findProductByName ==========");
		List<MyProduct> list = service.findProductByName("세탁기");
		for(MyProduct p: list) System.out.println(p);
		
		System.out.println("========== findProductByMaker ==========");
		List<MyProduct> list2 = service.findProductByMaker("LG");
		for(MyProduct p: list2) System.out.println(p);
		
		System.out.println("========== findProducts ==========");
		List<MyProduct> list3 = service.findProducts();
		for(MyProduct p: list3) System.out.println(p);
	}
}
