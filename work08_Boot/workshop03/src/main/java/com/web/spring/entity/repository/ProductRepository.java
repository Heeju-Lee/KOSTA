package com.web.spring.entity.repository;

import java.util.List;

import org.hibernate.query.spi.Limit;
import org.springframework.data.jpa.repository.JpaRepository;

import com.web.spring.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

	//1) 모든 상품의 개수를 받아오는 쿼리 메소드 
	Long countBy();
	
	//2)  조회한 상품 중에 2건만 제한해서 받아오는 쿼리 메소드
	List<Product> findByMaker(String Maker, org.springframework.data.domain.Limit limit);
}
