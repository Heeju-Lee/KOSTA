package com.service.mybatis.unit;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.service.mybatis.vo.MySawon;

public class MySawonUnitTest2 {

	public static void main(String[] args) throws IOException {

		
		
		SqlSessionFactory factory = FactoryService.getFactory();
		
		//3) SqlSession 이 factory로부터 생성된다.
		SqlSession session =factory.openSession();
		
		System.out.println("SqlSession..Creating...");
		
		//4)
		session.selectList("SawonMapper.sawonList")
				.forEach(c->System.out.println(c));
	
		session.commit();
		session.close();		
	}
}
