package spring.service.test;	

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

//SqlSessionFactory까지만 받아오는 기능을 여기에 담는다....
public class TestUtil {
	private static SqlSessionFactory factory = null;
	static {
		try {
			//1) 설정문서를 읽는다.
			Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
			//2) SqlSessionFactory 생성...설정문서 wiring
			factory = new SqlSessionFactoryBuilder().build(r);
		} catch (IOException e) {
			System.out.println(e);
		}
	}//static
	public static SqlSessionFactory getFactory() {
		return factory;
	}//getFactory
}//FactoryService
