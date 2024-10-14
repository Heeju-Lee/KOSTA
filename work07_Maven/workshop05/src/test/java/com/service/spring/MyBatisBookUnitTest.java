package com.service.spring;

import java.io.Reader;

import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.service.spring.domain.Book;


public class MyBatisBookUnitTest {
	
	private static final String NS = "ns.sql.BookMapper.";
	
	@Test
	public void getBooks() throws Exception{
		Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		SqlSession session = factory.openSession();
		
		Book book = new Book();
		List<Book> list = null;
		
		System.out.println("============================= searchByTitle ============================");
		list = session.selectList(NS+"searchByTitle","파이썬");
		for(Book b : list)
			System.out.println(b);
		
		
		System.out.println("============================= searchByPrice ============================"); 
		list = session.selectList(NS+"searchByPrice",4000); 
		for(Book b : list)
			System.out.println(b);
		
		System.out.println("============================= searchByPublisher ============================"); 
		list = session.selectList(NS+"searchByPublisher","한빛"); 
		for(Book b : list)
			System.out.println(b);
		
		System.out.println("============================= searchByIsbn ============================"); 
		book = session.selectOne(NS+"searchByIsbn","5555-124-484"); 
		System.out.println(book);
				
		System.out.println("============================= getIsbn ============================"); 
		book = session.selectOne(NS+"getIsbn","파이썬 정복하기"); 
		System.out.println(book);
		
		System.out.println("============================= getBooks ============================"); 
		list = session.selectList(NS+"getBooks"); 
		for(Book b : list)
			System.out.println(b);
	}
	@Test
	public void addBook() throws Exception{
		Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		SqlSession session = factory.openSession();
		
		Book book = new Book();
		System.out.println("============================= insertBook ============================");
		book = new Book("1233-457-123", "Maven 완전정복", "프로그래밍", "국내", "2022-10-29", "절미미디어", "이희주", 25000, "maven 정복해보세요");
		System.out.println(session.insert(NS+"insertBook",book)+"건 등록완료\n"+book.getTitle());
		session.commit();
	}
	
	@Test
	public void updateBook() throws Exception{
		Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		SqlSession session = factory.openSession();
		
		Book book = new Book();
		book.setIsbn("1233-457-123");
		book.setTitle("Maven 완전 정복하기2");
		book.setAuthor("절미");
		book.setDescription("정복 성공해봐");
		
		System.out.println("============================= update ============================"); 
		System.out.println(book.getTitle()+"---"+session.update(NS+"update",book)+"건 업데이트 완료");
		session.commit();
	}
	
	@Test
	public void deleteBook() throws Exception{
		Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		SqlSession session = factory.openSession();
		
		Book book = new Book();
		book = session.selectOne(NS+"getIsbn","파이썬 정복하기"); 
		
		System.out.println("============================= delete ============================"); 
		

		System.out.println(book.getTitle()+"---"+session.delete(NS+"delete",book)+"건 삭제 완료");
		session.commit();
	}
}
