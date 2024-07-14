package com.edu.service;

import java.util.ArrayList;

import com.edu.repository.ProductRepository;
import com.edu.vo.Product;
import com.edu.vo.User;

public class ProductService {
	
	ProductRepository productRepository = new ProductRepository();
	
	//상품 등록()
	public void addProduct(User user, Product product) {

	}
	
	//상품 전체 조회()
	public ArrayList<Product> viewAllProduct() {
		
		return null;
	}
	
	//상품 상세 조회()
	public void viewProductDetail(Product product) {
		
	}
	
	//내가 등록한 상품 조회()
	public ArrayList<Product> myProduct(User user) {
		
		return null;
	}
	
	
	//상품 텍스트 검색()
	public ArrayList<Product> findProductByName(String name) {
		
		return null;
	}
	
	//상품 카테고리 검색()
	public ArrayList<Product> findProductByCategory(String category) {
		
		return null;
	}
	
	//나중에 시간 되면 가격 범위로 상품 검색()....
	
	//상품 수정()
	public void updateProduct(User user, Product product) {

	}
	
	//상품 삭제()
	public void deleteProduct(User user, Product product) {
		
	}
	
	//상품 구매
	public void buyProduct(User user, Product product) {
		
	}
	
	

}
