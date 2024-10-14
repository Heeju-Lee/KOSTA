package com.web.spring;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import com.web.spring.entity.Custom;
import com.web.spring.repository.CustomRepository;

import jakarta.transaction.Transactional;

//CustomRepository를 주입.....Spring Data JPA가 생성하는 빈을 여기서 가져다 쓴다....
@SpringBootApplication
public class Boot05JpaRepositoryApplication implements CommandLineRunner{
	
	//주입된 해당 빈을 사용해서 crud 작업을 다 할수 있다.
	//트랜잭션 단위로...Entitymanager가 내부적으로 모든일을 처리할 것이다.
	@Autowired
	private CustomRepository customRepository;	
	
	@Override
	@Transactional//jpa메소드가 호출될 때 트랜잭션이 실행되고, 메소드가 종료될 대 트랜잭션이 끝난다.
	public void run(String... args) throws Exception {
//		Optional<Custom> ot = customRepository.findById(1);
//		System.out.println(ot);
//		Custom c = customRepository.findById(1).orElseThrow();
//		System.out.println("1번 고객에 대한 정보입니다 :: "+c);
		
		//1. CustomRepository를 실제로 구현하고 있는 구현체를 출력
		/*
		 * jdk.proxy7.$Proxy132
		 * ::
		 * proxy는 인터페이스를 구현하고 있는 객체를 동적으로 생성해주는 자바 기술이다.
		 * 모든 자바 프레임워크 구현체들은 Proxy 기술을 이용해서 만들어진다.
			System.out.println(customRepository.getClass().getName());
		 */
		//2. 새로운 custom을 추가
//		Custom c1 = new Custom();
//		//c1.setName("제시카");
//		c1.setEmail("kkk@google.com");
//		c1.setPassword("1234");
//		c1.setRegDate(LocalDateTime.now());
//		
//		customRepository.save(c1);
		
		//3. 방금 추가한 사람을 삭제 (select 하고 delete)
		// 1)과 2)의 차이 없음. 1차캐시 사용하면 2)가 오히려 좋을 수 있다. 
		//customRepository.deleteById(11); //1)
		
		//Custom deleteC=customRepository.findById(7).orElseThrow();
		//customRepository.delete(deleteC); //2)
		
		//4. 수정하기...update 함수는 따로 제공되지 않는다. (트랜잭션이 완료 감지가 되어야 함)
		//Entity 정보와 snapshot 정보가 다를 때 트랜잭션이 완료되는 시점에 이걸 감지하고 update가 자동으로 호출
//		Custom updateC=customRepository.findById(1).orElseThrow();
//		System.out.println("Update 하기전 >> "+updateC);//스냅샷에 저장된 정보
//		
//		updateC.setPassword("1234");//변경 entity 정보 변경
//		System.out.println("Update 한 후 >> "+updateC);//트랜잭션이 끝날 때 스냅샷 정보와 Entity정보를 감지
		
		//findByNameLike
//		customRepository.findByNameLike("%홍%")
//		.forEach(c->System.out.println(c));			
		
		//findByNameEndingWith
//		customRepository.findByNameEndingWith("종각")
//		.forEach(c->System.out.println(c));
		
//		customRepository.findByCustomIdGreaterThanOrderByCustomIdDesc(3)
//		.forEach(c->System.out.println(c));
//		
//		List<Integer> ids = new ArrayList<>();
//		ids.add(1);
//		ids.add(4);
//		ids.add(9);
//		
//		customRepository.findByCustomIdIn(ids)
//		.forEach(c->System.out.println(c));
		
		//findByNameNot
		customRepository.findByNameNot("김종각")
						.forEach(c->System.out.println(c));
		System.out.println("-------------------------------------------------------------------------");
		customRepository.findByCustomIdIn(List.of(1, 4, 9))
						.forEach(c->System.out.println(c));
		}
	
		
	
	public static void main(String[] args) {
		SpringApplication.run(Boot05JpaRepositoryApplication.class, args);
	}
}
