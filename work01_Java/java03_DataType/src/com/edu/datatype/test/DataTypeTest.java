package com.edu.datatype.test;

public class DataTypeTest {

	public static void main(String[] args) {
		//값의 범위로 비교
		float salary=100;
		System.out.println(salary);

		//data 타입 비교, - long, float, double 은 값뒤에 무조건 타입이 지정된 값임.

		double salary1=100.0;//<- 기본으로 d가 붙어있음.
		System.out.println(salary1);
		
		float salary2=100.0F;//<-f 대소문자 구분 없음.
		System.out.println(salary2);
	
		long salary3=123423423l;//l 꼭 붙여줘야 함. 
		System.out.println(salary3);
		System.out.println("===================");
		
		//int 이하에서 사칙연산이 일어나면 int로 승격됨.
		short a,b ;
		a = 1; b = 2;
		short c = (short)(a+b);//<-short로 꼭 해야겠다면 (short)붙여주기
		System.out.println(c);
		
		
	}
}
