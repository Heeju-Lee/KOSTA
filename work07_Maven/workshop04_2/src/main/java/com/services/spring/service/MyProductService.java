package com.services.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.services.spring.dao.MyProductDAO;
import com.services.spring.domain.MyProduct;

//데이타 가공...SELECT문 / DELETE문
@Service
public class MyProductService {
	
	@Autowired
	private MyProductDAO myProductDAO;
	

	/*
	 * public void addProduct(MyProduct vo) throws Exception{
	 * myProductDAO.addProduct(vo); }
	 */
	
	public List<MyProduct> findProductByName(String name) throws Exception{
		return myProductDAO.findProductByName(name);
	}
	
	public List<MyProduct> findProductByMaker(String maker) throws Exception{
		return myProductDAO.findProductByMaker(maker);
	}
	
	public List<MyProduct> findProducts() throws Exception{
		return myProductDAO.findProducts();
	}
}
