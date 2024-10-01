package com.service.mybatis.unit;

import java.io.IOException;
import java.io.Reader;

import javax.annotation.Resource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.service.mybatis.vo.MySawon;

public class MySawonUnitTest1 {

	public static void main(String[] args) throws IOException {
		//사원 추가하는 로직을 호출
		//1. 폼으로부터 사원정보를 받아와야하는데.....받았다고 치고
		MySawon pvo = new MySawon();
		pvo.setId("mybatis");
		pvo.setPwd("mybatis");
		pvo.setName("James");
		pvo.setAge(33);
		
		//2. MyBatis 라이브러리 사용해서 작업을 진행...
		/*
		 * 1) SqlMapConfig.xml 을 먼저 읽어들인다.(MyBatis)
		 * 2) SqlSessionFactory를 생성.....1)을 입력 
		 * 3) SqlSession을 생성 !!!!!!(제일중요함)
		 * 4) SqlSession에 쿼리문을 실행하는 함수가 들어있다.
		 * 
		 * 		int		insert()
		 * 				Connection --> PreparedStatement --> 바인딩 --> executeUpdate
		 * 		int		delete()
		 * 		int		update()
		 *  	Object  selectOne()
		 * 		List	selectList()
		 */
		
		//1)
		Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		
		//2)
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		
		//3) 
		SqlSession session =factory.openSession();
		
		System.out.println("SqlSession..Creating...");
		
		//4)
		session.insert("SawonMapper.sawonAdd", pvo);
		System.out.println(pvo.getName()+"회원등록 성공*^_^*");
		
		session.commit();
		session.close();		
	}
}
