package com.edu.array.test1;
/*
 * 
Scanner 를 사용해서 맨 처음 입력받는 값으로 배열의 크기를 받아오자
int size  = sc.nextInt();//3
3칸짜리 String 배열을 생성
향상된 for 문을 통해서 3명의 고객명을 배열의 요소값으로 입력

 */

import java.util.Scanner;

public class BasicArrayTest4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("배열의 사이즈 입력>>>");
		
		int size  = sc.nextInt();
		
		System.out.println("String 타입의 배열 생성");
		String[] names = new String [size] ;
		
		System.out.println("String 타입의 배열 초기화");
		
		for(int i = 0 ; i<names.length ; i++)
			names[i] = sc.next();
		
		System.out.println("\n이름들을 출력");
		for(String name : names) System.out.print(name+" ");
	}

}
