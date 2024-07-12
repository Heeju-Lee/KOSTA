package com.edu.collection2;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

import com.edu.vo.Customer;

public class HashMapTest3 {

	public static void main(String[] args) {
		HashMap<String, Customer> map = new HashMap<>();
		map.put("111", new Customer("111",11,"AAA"));
		map.put("222", new Customer("222",22,"BBB"));
		map.put("333", new Customer("333",333,"CCC"));
		
		//1. map 에 들어있는 사람중에서 222 인 사람을 맵에서 찾으려고 한다.
		System.out.println(map.get("222"));
		
		//2. 이름이 CCC인 사람을 찾아서 그사람의 나이를 콘솔로 출력
		for(Customer c : map.values()) {
			if(c.getName().equals("CCC"));
				System.out.println("CCC 님의 나이는 :"+c.getAge());
		}
//		
//		//3.  map에 있는 사람 중에서 최고연령과 최소연령의 사람을 각각 출력
//		for(Customer c : map.values()) {	
//			Integer maxValue = Collections.max(map.values());	
//			Integer minValue = Collections.min(map.values());
//		
//		System.out.println("최고 연령은 "+maxValue+"입니다.");
//		System.out.println("최저 연령은 "+minValue+"입니다.");		
//		}
//		
	}
}
