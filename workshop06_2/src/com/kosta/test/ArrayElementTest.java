package com.kosta.test;

import java.util.Arrays;

public class ArrayElementTest {

	public static void main(String[] args) {
		double[] salalries = {300000.0,450000.0,570000.0};
		System.out.println(salalries);//toString 생략됨.
		System.out.println(salalries.toString());
		
		
		/*
		 * 배열안에 있는 여러개의 값들을 출력할 때 사용하는 라이브러리
		 *  Array.toString() 배열의 값 출력 for문 없이 
		 */
		System.out.println(Arrays.toString(salalries));
		
		
		
		
	}

}
