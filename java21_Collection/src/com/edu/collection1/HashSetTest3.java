package com.edu.collection1;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest3 {

	public static void main(String[] args) {
		Set<String> set = new HashSet<>();
		set.add("강호동");
		set.add("이수근");
		set.add("강호동");//중복
		set.add("서장훈");
		set.add("김희철");
		
		System.out.println(set.size()+" 명입니다.");
		System.out.println(set);//Collection은 자체적으로 toString overriding -> 데이터 출력됨.
		
		//1. 서장훈씨가 포함되어져 있는지 확인.....
		boolean flag = set.contains("서장훈");
			System.out.println("서장훈님이 포함되어 있나요?" + flag);
		//2. 현재 Collection 안이 비어있는지 확인.....
		System.out.println("데이터가 비어져있나요?"+set.isEmpty());
		//3. 이수근을 삭제하고 ... 나머지 사람들을 출력.....
		
		set.remove("이수근");
		System.out.println(set);
		
		//4. set안에 들어있는 모든 데이터를 삭제
		set.clear();//모두 삭제하는 것은 clear
		
		//5. 정말로 비워졌는지 확인
		System.out.println("데이터가 비어져있나요?"+set.isEmpty());
	}
}
