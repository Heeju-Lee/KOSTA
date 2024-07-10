package com.edu.condition.test3;

import java.util.Scanner;

public class CatchAMouseTest {
	public static String solv(int a, int b, int m) {
		/*
		 * 이안에 로직 작성(조건문으로)
		 */
		if(Math.abs(m-a) > Math.abs(m-b))
			return "CatB Catch";
		else if(Math.abs(m-a) == Math.abs(m-b))
			return "Mouse Escapes!!";
		else 
			return "CatA Catch!";
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Cat A의 위치, Cat B의 위치, Mouse의 위치를 순서대로 입력하시오");
		int catA = sc.nextInt();
		int catB = sc.nextInt();
		int mouse = sc.nextInt();
		
		String result=solv(catA,catB,mouse);//"(xxx)"<-argument list, call=string
		System.out.println(result);
		
	}

}
