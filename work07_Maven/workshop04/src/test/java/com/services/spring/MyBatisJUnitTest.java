package com.services.spring;

import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.services.spring.domain.MyProduct;

public class MyBatisJUnitTest {
	
	private static final String NS = "ns.sql.ProductMapper.";
	
	@Test
	public void unit() throws Exception{
		Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		SqlSession session = factory.openSession();
		
		MyProduct myProduct;
		List<MyProduct> list = new ArrayList<MyProduct>();
		
		
		System.out.println("========== addProduct ==========");
		myProduct = new MyProduct("통돌이세탁기5", "LG", 5555776);
		System.out.println(session.insert(NS+"addProduct",myProduct)+"건 등록 완료");
		session.commit();
		
		System.out.println("========== findProductByName ==========");
		list = session.selectList(NS+"findProductByName","통돌");
		for(MyProduct p: list) System.out.println(p);
		
		System.out.println("========== findProductByMaker ==========");
		list = session.selectList(NS+"findProductByMaker","LG");
		for(MyProduct p: list) System.out.println(p);
		
		System.out.println("========== findProducts ==========");
		list = session.selectList(NS+"findProducts");
		for(MyProduct p: list) System.out.println(p);
		
		session.close();
	}
	
}
