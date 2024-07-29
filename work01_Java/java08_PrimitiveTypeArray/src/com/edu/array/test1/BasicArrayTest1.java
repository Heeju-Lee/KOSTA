package com.edu.array.test1;
/*
 * 배열
 * 1) 선언	
 * 2) 생성 -------- 반드시 배열의 사이즈가 명시되어야 함.	 
 * 3) 초기화
 */
public class BasicArrayTest1 {

	public static void main(String[] args) {
		//1)선언
		int[] arr;
		
		//2)생성
		arr = new int[3];//size 명시, 생성과 동시에 default value 가짐
		System.out.println("배열 Container의 주소값:: "+arr);
		System.out.println("\n=======배열 Container 각각의 요소값=======");
		
		for(int i=0; i<3 ; i++) System.out.print(arr[i]+" ");
	
		//3)초기화
		arr[0] = 11; arr[1] = 22; arr[2] =33;
		System.out.println("\n=======배열 Container 각각의 요소값=======");
		for(int i=0; i<arr.length ; i++) System.out.print(arr[i]+" ");
	}

}
