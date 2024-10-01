package mybatis.services.user.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.services.domain.User;

/*
 * FileName : MyBatisTestApp08.java
  * ㅇ SqlMapConfig01.xml / mybatis-userservice-mapping08.xml
  * ㅇ MyBATIS Framework 이용 Dynamic query ( SELECT ) TEST | sql구문의 Module화
  * ㅇ TestUtil.java 을 이용 Test . 
  * 
  * ㅇ 다음은 MyBatisTestApp101.java : MyBatis Framework 단위 테스트
  */
public class MyBatisTestApp08 {
	///Main method
	public static void main(String[] args) throws Exception{
		SqlSession session = null;
		//==> TestUtil 의 getSqlSessionFactory()을 이용 SqlSessionFactory instance GET
		SqlSessionFactory factory = TestUtil.getSqlSessionFactory();
		session=factory.openSession();
		
		//==> Test 용 User instance 생성  
		User user = new User("user01","홍길동","user01",new Integer(30),1);
	
		//1. UserMapper08.getUserList01 Test ... 정적쿼리 실행
		System.out.println(":: 1. getUserList01(SELECT)  ? ");
		TestUtil.printList( (List)session.selectList("UserMapper08.getUserList01",user) );
		
		// 동적 쿼리 실행		
		
		//1. UserMapper08.getUserList01 Test 
		System.out.println(":: 1. getUserList(SELECT)  ? ");
		TestUtil.printList( (List)session.selectList("UserMapper08.getUserList",user) );		
		
		//2. UserMapper08.getUserList01 Test 
		System.out.println(":: 2. getUserList(SELECT)  ? ");
		user.setUserName(null);
		TestUtil.printList( (List)session.selectList("UserMapper08.getUserList",user) );
		
		//3. UserMapper08.getUserList01 Test 
		System.out.println(":: 3. getUserList(SELECT)  ? ");
		user.setUserName("홍길동");
		user.setAge(null);
		TestUtil.printList( (List)session.selectList("UserMapper08.getUserList",user));
	
		//4. UserMapper08.getUserList01 Test 
		System.out.println(":: 4. getUserList(SELECT)  ? ");
		user.setUserName(null);
		user.setAge(null);
		TestUtil.printList( (List)session.selectList("UserMapper08.getUserList",user) );
		
	}//end of main
}//end of class