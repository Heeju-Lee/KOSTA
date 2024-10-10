package com.web.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.web.spring.entity.Custom;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;


//Spring Framework에서 bean으로 제공되는 것들을 사용하기 위해서는 CommandLineRunner!! 
@SpringBootApplication
public class Boot04JpaApplication implements CommandLineRunner{

	@Autowired
	private EntityManagerFactory entityManagerFactory;
	
	@Override
	public void run(String... args) throws Exception {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			
			//JPA 관련코드를 순서대로 작성
			
//			Custom c = new Custom();
//			c.setName("김종각2");
//			c.setPassword("4321");
//			c.setEmail("kim@google.com");			
//			
//			//persist = insert
//			entityManager.persist(c);
			
//			//find = select 검색
//			Custom find1 = entityManager.find(Custom.class, 1);
//			System.out.println("1번에 해당하는 고객 정보..."+find1);
			
//			// remove = delete
//			Custom find5 = entityManager.find(Custom.class, 5);
//			System.out.println("5번에 해당하는 고객정보 ..."+find5);
//			entityManager.remove(find5);
			
			//쿼리문 한번만 도는데 티persistence 와 연관되어 있다
			/*트랜잭션 내에서 같은 객체에 대해 여러번 SELECT 질의를 하는 경우 쿼리는 한 번만 발생된다.
			1차 캐시에 객체가 없다면 SELECT 쿼리 발생하여 가져온 객체를 1차 캐시에 저장한다.
			그 후 나머지 질의는 1차 캐시에 있는 객체를 그대로 반환하기 때문에 쿼리가 발생하지 않는다.
			*/
//			Custom find4 = entityManager.find(Custom.class, 4);
//			System.out.println("4번에 해당하는 고객정보 ..."+find4);
//			
//			Custom find44 = entityManager.find(Custom.class, 4);
//			if(find4==find44) System.out.println("동일한 객체입니다...");

			//persist + find (쿼리문이 하나 나옴)
//			Custom c = new Custom();
//			c.setName("James");
//			c.setPassword("7777");
//			c.setEmail("james@kosta.com");
//			
//			entityManager.persist(c);
//			
//			Custom find6 = entityManager.find(Custom.class, 6);
//			System.out.println("6번에 해당하는 고객정보 ..."+find6);
			
			//수정...UPDATE가 존재하지 않는다. 1차 캐시와 snapshot이 일치하지 않으면 update 진행
			//6번 고객의 정보를 수정
			Custom find6 = entityManager.find(Custom.class, 6);
			find6.setPassword("9999");
				
			System.out.println("6번 고객의 정보 "+find6);
			
			transaction.commit();			
		} catch (Exception e) {
			transaction.rollback();
		}finally {
			entityManager.close();
		}
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Boot04JpaApplication.class, args);
	}
}
