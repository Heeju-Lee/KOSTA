package com.web.spring;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import com.web.spring.entity.User;
import com.web.spring.repository.UserRepository;

import jakarta.transaction.Transactional;


@SpringBootApplication
public class Workshop02Application implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	@Transactional
	public void run(String... args) throws Exception {
		User user = new User();
		
		user.setId("jeolmi");
		user.setPassword("1234!");
		user.setName("절미");
		
		//저장 :: save() (v)
		userRepository.save(user);
		
		//검색 ::  findById() (v)
		//User rvo = userRepository.findById("kosta").orElseThrow();
		//System.out.println(rvo);
		
		//검색 ::   findAll() (v)
		//List<User> list = userRepository.findAll();
		//list.forEach(c->System.out.println(c));
		
		//삭제 ::   deleteById() (v)
		//userRepository.deleteById("admin");
		
		//삭제 ::   delete() (v)
		//User deleteU= userRepository.findById("kosta").orElseThrow();
		//userRepository.delete(deleteU);
		
		//수정 :: (v)
		//User rvo = userRepository.findById("kosta").orElseThrow();
		//rvo.setPassword("0000");
		
		System.out.println("============= Query Method 3개 추가 =============");
		//findByName
		//System.out.println(userRepository.findByName("절미"));
		
		//findByPasswordContaining
		userRepository.findByPasswordContaining("!")
					  .forEach(c->System.out.println(c));
		
		//findByNameIn
		userRepository.findByNameIn(List.of("절미","코스타","관리자"))
					  .forEach(c->System.out.println(c));
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Workshop02Application.class, args);
	}
}
