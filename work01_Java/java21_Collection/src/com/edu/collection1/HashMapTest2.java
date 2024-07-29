package com.edu.collection1;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/*
				Map
				 |
			  HashMap
		Key      -     value 쌍으로 저장
	  (중복안됨)        (중복가능)
		 	순서는 없다.
 */
public class HashMapTest2 {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap();
		map.put("강호동", 90); //Boxing : 컴파일러가 알아서 wrap 해서 객체로 만들어버림. 
		map.put("이수근", 80); //보이는 것은 80을 넣은 것으로 보이지만 실제로는 new Integer(80)인 것.
		map.put("서장훈", 95);
		map.put("김희철", 60);		
		/*
		 1. 키값들을 봅아서
		 2. 반복물을 통해서 키값에 해당하는 점수를 뽑고 
		 3. 최종적으로 모든 성적의 합과 평균을 구해라.
		 */
		System.out.println("============= KeySet() =============");
		int total = 0 ;
		
		for(String key: map.keySet()) {
			int score = map.get(key);//Unboxing 해서 int로 
			total +=score;
		}
		System.out.println("모든 사람들의 성적의 총합은 "+total+"점 입니다.");
		System.out.println("모든 사람들의 성적의 평균은 "+total/map.size()+"점 입니다.");
		
		System.out.println("============= values() =============");
		int sum = 0;
		for(int v: map.values()) sum +=v;
		System.out.println("모든 사람들의 성적의 총합은 "+sum+"점 입니다.");
		System.out.println("모든 사람들의 성적의 평균은 "+sum/map.size()+"점 입니다.");
		
		System.out.println("============= Collections =============");//값을 핸들링하기 유용한 것들이 들어있음.
		System.out.println("최고 성적은 "+Collections.max(map.values())+"점입니다.");
		System.out.println("최저 성적은 "+Collections.min(map.values())+"점입니다.");
		
		
	}
}
