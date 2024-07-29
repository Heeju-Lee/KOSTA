package com.edu.loop.test;
/*
 * 반복문을 이용해서 1~100까지의 총합을 구하는 로직을 작성
 * 
 */
public class LoopingBreakTest2 {

	public static void main(String[] args) {
		int sum = 0;//for바깥...
		for(int i=1; i<=100; i++) {
			sum += i;
			
			if (sum > 500) break;///중간에 빠져나옴, continue와의 차이점 알아두기
			
		}
		System.out.println("총합 : "+sum);	
		
	}

}
