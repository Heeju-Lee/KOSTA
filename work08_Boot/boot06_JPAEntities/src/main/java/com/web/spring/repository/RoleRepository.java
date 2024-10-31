package com.web.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.spring.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{
	//save, findById, findAll, delete, deleteById.....
	// 부트 서버를 가동해서 Role 테이블 생성... update
}
