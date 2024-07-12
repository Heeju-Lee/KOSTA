package com.edu.collection3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class SortTest1 {

	public static void main(String[] args) {
		System.out.println("List 정렬하기");
		
		List<Integer> list = new ArrayList<>();
		list.add(11);
		list.add(9);
		list.add(3);
		list.add(33);
		
		//입력한 순서대로 나올 것임. 컨벤션: 출력 시, 정렬이 필요함
		System.out.println(list);
		
		System.out.println("=========== 오름차순 정렬 ===========");
		Collections.sort(list);
		
		Iterator<Integer> it = list.iterator();//한번 쓴 interator는 사용불가
		while(it.hasNext()) {
			System.out.println(it.next());
		}
				
		System.out.println("=========== 내림차순 정렬 ===========");
		Collections.sort(list, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1;//큰수-작은수...양수...내림차순 정렬
			}
		
		});//내림차순 정렬
		
		Iterator<Integer> it2 = list.iterator();
		while(it2.hasNext()) {
			System.out.println(it2.next());
		}
		
		
	}

}
