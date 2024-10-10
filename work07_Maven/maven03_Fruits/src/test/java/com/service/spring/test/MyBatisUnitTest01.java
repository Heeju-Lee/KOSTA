package com.service.spring.test;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.service.spring.domain.Item;

/* MyBatis-fruits-mapping.xml sql구문이 잘 만들어졌는지
   MyBatis 프레임워크 부분이 잘 연결되었는지....여부를 점검하는 테스트...
   
     이 부분이 완벽해야 persistence 레이어로 연결할 수 있다.
   SqlSessionFactory
   SqlSession
   
   CRUD 를 확인한다.... 이때는 commit() 해야한다.
*/
public class MyBatisUnitTest01 {

	public static void main(String[] args) throws Exception {
		Reader r =Resources.getResourceAsReader("config/SqlMapConfig.xml");
		
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		
		SqlSession session = factory.openSession();
		
		//쿼리문 실행
		System.out.println("======================= getItemList =======================");
		List<Item> list = session.selectList("ns.sql.FruitsMapper.getItemList");
		for(Item i : list) System.out.println(i);
		
		System.out.println("======================= getItem =======================");
		Item item = session.selectOne("ns.sql.FruitsMapper.getItem",2222);
		System.out.println(item);		
		
	}//main
}//class
