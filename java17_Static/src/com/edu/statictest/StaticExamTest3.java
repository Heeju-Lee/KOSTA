package com.edu.statictest;
/*
	main이 실행----->
	객체생성 ==> 명시적 생성자 주입 필드초기화
	
 */
public class StaticExamTest3 {
	static int i ;
	
	public static void main(String[] args) {
		System.out.println("1. main method block....."+i);
	}
		
	//static initialization block(static 초기화 블락)
	//Global한 초기화 = ready-on 초기화
	static {
		i = 300;
		System.out.println("2. static method block....."+i);
	}
	
}//class
