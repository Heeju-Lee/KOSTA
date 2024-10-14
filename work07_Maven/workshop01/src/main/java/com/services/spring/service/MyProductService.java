package com.services.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.services.spring.dao.MyProductDAO;
import com.services.spring.domain.MyProduct;

@Service
public class MyProductService {
	
	@Autowired
	MyProductDAO myProductDAO;
	
	public void addProduct(MyProduct myProduct) {
		myProductDAO.addProduct(myProduct);
	}
	
	public List<MyProduct> findProductByName(String name){	
		return myProductDAO.findProductByName(name);
	}
	
	public List<MyProduct> findProductByMaker(String maker){	
		return myProductDAO.findProductByName(maker);
	}
	
	public List<MyProduct> findProducts(){	
		return myProductDAO.findProducts();
	}
}
