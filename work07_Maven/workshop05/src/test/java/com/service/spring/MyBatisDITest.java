package com.service.spring;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.service.spring.domain.Book;
import com.service.spring.service.BookService;


public class MyBatisDITest {
	
	ApplicationContext factory =
			new ClassPathXmlApplicationContext("/beans/businessBean.xml");
	
	//myBatis와 DI연동 부분의 단위테스트...빈 설정문서를 읽어야 함.
	@Test
	public void addTest() throws Exception{

		//IOC로부터 MyProductDAO, MyProductService 객체를 반환
		//어노테이션을 했기 때문에 경로가 아닌 클래스명
		BookService service = (BookService) factory.getBean("bookService");

		System.out.println("==================== Test ====================");
		List<Book> list = service.searchByTitle("정복");
		for(Book b : list) System.out.println(b);
	}
}
