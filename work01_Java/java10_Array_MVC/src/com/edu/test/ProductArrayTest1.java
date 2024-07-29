package com.edu.test;

import com.edu.vo.Product;

public class ProductArrayTest1 {

	public static void main(String[] args) {
		Product[] products = {
				new Product("신라면", 1200, 5, "농심"),
				new Product("삼다수 생수", 1000, 10, "농심"),
				new Product("하이타이", 14000, 1, "엘지"),
				new Product("짐빔", 130000, 1, "JIM")
		};
		
		System.out.println("상품정보를 출력합니다......");
		System.out.println("========================");
		for(Product product : products) {
			System.out.println(product.getDetails());
			System.out.println("========================");

			///제품중에서 제품명이 "하이타이"인 것을 찾아서 가격 -2000 가격을 출력해라.
			if(product.getMaker().equals("하이타이")) {
				int price = product.getPrice()-2000;
				System.out.println("하이타이 2000원 할인된 가격은 "+price+"원입니다.");
			}//if
		}//for					
	}//main
}//class
