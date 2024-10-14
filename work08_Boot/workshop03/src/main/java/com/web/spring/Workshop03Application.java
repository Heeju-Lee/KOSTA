package com.web.spring;

import org.hibernate.query.spi.Limit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.web.spring.entity.User;
import com.web.spring.entity.repository.ProductRepository;
import com.web.spring.entity.repository.UserRepository;

import jakarta.transaction.Transactional;

@SpringBootApplication
public class Workshop03Application implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ProductRepository productRepository;

	
	@Override
	@Transactional
	public void run(String... args) throws Exception {
		
		//1) 모든 상품의 개수를 받아오는 쿼리 메소드
		
		Long totalProduct = productRepository.countBy();
		System.out.println("검색하신 상품의 개수 :: "+totalProduct+"개");
		System.out.println("================================================");
	
		//2)  조회한 상품 중에 2건만 제한해서 받아오는 쿼리 메소드
		productRepository.findByMaker("애플",org.springframework.data.domain.Limit.of(2))
						 .forEach(p->System.out.println(p));
		System.out.println("================================================");
		
        // 모든 User 검색 
		userRepository.findAll()
					  .forEach(u->System.out.println(u));
		System.out.println("================================================");
        // 모든 User 정보와 함께 User들이 구입한 Product  정보도 검색 
		userRepository.findAll()
					  .forEach(u->{
						  System.out.println(u);
						  System.out.println(u.getProducts());
						System.out.println("================================================");
					  });
        // 특정 User 검색 
		User user = userRepository.findById(1).get();
		System.out.println(user);
		System.out.println("================================================");
		
		// 특정 User 검색과 함께 User가 구입한 Product 정보고 검색 
		User user1 = userRepository.findById(1).get();
		System.out.println(user1);
		System.out.println(user1.getProducts());
		System.out.println("================================================");
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(Workshop03Application.class, args);
	}



}
