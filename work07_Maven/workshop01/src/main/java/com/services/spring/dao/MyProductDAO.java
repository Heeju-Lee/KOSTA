package com.services.spring.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.services.spring.domain.MyProduct;

@Repository
public class MyProductDAO {
	
	private static final String NS = "ns.sql.ProductMapper.";
	
	@Autowired
	private SqlSession sqlSession;
	
	public void addProduct(MyProduct myProduct) {
		sqlSession.insert(NS+"addProduct",myProduct);
	}
	
	public List<MyProduct> findProductByName(String name){	
		return sqlSession.selectList(NS+"findProductByName",name);
	}
	
	public List<MyProduct> findProductByMaker(String maker){	
		return sqlSession.selectList(NS+"findProductByMaker",maker);
	}
	
	public List<MyProduct> findProducts(){	
		return sqlSession.selectList(NS+"findProducts");
	}
	
}
