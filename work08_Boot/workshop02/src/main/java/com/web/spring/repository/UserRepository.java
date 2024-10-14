package com.web.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.spring.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
	
	//findByName
	List<User> findByName(String name);
	
	//findByPasswordContaining
	List<User> findByPasswordContaining(String symbols);
	
	//findByNameIn
	List<User> findByNameIn(List<String> names);
	
}
