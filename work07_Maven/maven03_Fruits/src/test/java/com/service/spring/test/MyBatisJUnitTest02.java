package com.service.spring.test;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.service.spring.domain.Item;

public class MyBatisJUnitTest02 {

	@Test
	public void unit() throws Exception{
		//1. 설정문서 읽고
		Reader r =Resources.getResourceAsReader("config/SqlMapConfig.xml");
		//2. SqlSessionFactory 생성
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		//3. SqlSession 생성
		SqlSession session = factory.openSession();
		
		//4. 쿼리문 실행
		System.out.println("======================= getItemList =======================");
		List<Item> list = session.selectList("FruitsMapper.getItemList");
		for(Item i : list) System.out.println(i);
		
		System.out.println("======================= getItem =======================");
		Item item = session.selectOne("FruitsMapper.getItem",2222);
		System.out.println(item);				
	}
}
