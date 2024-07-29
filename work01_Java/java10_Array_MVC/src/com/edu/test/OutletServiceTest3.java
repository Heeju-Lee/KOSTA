package com.edu.test;

import com.edu.service.OutletService;
import com.edu.vo.Customer;
import com.edu.vo.Product;

public class OutletServiceTest3 {

	public static void main(String[] args) {
		Product[] products1 = {
				new Product("신라면", 1200, 5, "농심"),
				new Product("삼다수 생수", 1000, 10, "농심"),
				new Product("하이타이", 14000, 1, "엘지"),
				new Product("짐빔", 1300000, 1, "JIM")
		};
		
		Product[] products2 = {
				new Product("Terra", 2200, 1, "농심"),
				new Product("맥심커피", 20000, 10, "농심"),
				new Product("휘센 에어컨", 334000, 1, "대우")
		};
		
		Customer c1 = new Customer(111, "이정재", "방배동");
		Customer c2 = new Customer(222, "정우성", "신사동");
		Customer c3 = new Customer(333, "제니", "방배동");//아울렛에서 구매한 물건은 x
		
		Customer[] customers = {c1, c2, c3};
		
		customers[0].buyProducts(products1);
		customers[1].buyProducts(products2);
		
		OutletService service = new OutletService();
		
		//1
		System.out.println("========"+customers[0].getName()+"님이 구매하신 상품 정보입니다.========");
		Product [] pros = service.getAllProduct(customers[0]);
		for(Product product : pros) 
			System.out.println(product.getDetails());
		
		//2
		System.out.println("========"+customers[0].getName()+"님이 구매하신 상품 MAKER입니다.========");
		String[] makers=service.getAllProductMaker(customers[0]);
		for(String maker : makers) System.out.println(maker);
		
		//3
		System.out.println("========222 고객님 검색 결과 입니다.========");
		Customer customer = service.findCustomer(customers, 222);
		System.out.println(customer.getCustomerInfo());
		
		//4
		System.out.println("========같은 동네 거주하는 고객 정보입니다.========");
		Customer[] addCustomers = service.findCustomer(customers, "방배동");
		for(Customer c : addCustomers ) {
			if(c==null) break;//옆에 null이면 정상적인 시스템 종료가 되도록. 
			System.out.println(c.getCustomerInfo());
		}
			
		//5
		System.out.println("========"+customers[0].getName()+"구매한 물건 중 가장 비싼 물건의 가격 정보입니다.========");
		
		
		
		

		//6 모든 고객이 구입한 물건 중 특정 가격 이상이 되는 제품들을 반환하는 기능	
		System.out.println("======== 고객들이 구입한 물품 중 1만원 이상에 해당하는 제품 정보입니다 =========");
				
		Product[] pros2 = service.getMorePriceProduct(customers, 10_000);
		for(Product p: pros2) {
			if(p == null) break;
			System.out.println(p.getDetails());
		}
	}
}	
	
