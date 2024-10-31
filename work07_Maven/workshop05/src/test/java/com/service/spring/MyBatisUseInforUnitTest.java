package com.service.spring;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.service.spring.domain.User;


public class MyBatisUseInforUnitTest {
	
	private static final String NS = "ns.sql.UserMapper.";

	
	@Test
	public void getUser() throws Exception{
		Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		SqlSession session = factory.openSession();
		
		User pvo1 = new User();
		pvo1.setUserId("kosta");
		pvo1.setPassword("1234");

		System.out.println((User)session.selectOne(NS+"getUser",pvo1));
		
		System.out.println("=========================================================");
		
		User pvo2 = new User();
		pvo2.setUserId("admin");
		System.out.println((User)session.selectOne(NS+"getUser",pvo2));
		
		System.out.println("=========================================================");
		User pvo3 = new User();
		pvo3.setUserId("hahaha");
		pvo3.setPassword("7777");
		pvo3.setName("공지영");
		pvo3.setEmail("kong@google.com");
		System.out.println(session.insert(NS+"addUser",pvo3));
	}
}
