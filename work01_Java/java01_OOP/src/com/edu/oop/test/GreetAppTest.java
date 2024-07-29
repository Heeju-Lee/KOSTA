package com.edu.oop.test;

import com.edu.oop.Greet;

//Test 클래스는 실행의 대상이 된다. 
public class GreetAppTest {
/*
 1. Greet클래스를 메모리에 올리고==객체생성
 2. 멤버에 접근하기 위해
 	필드 --> 값할당
 	메소드 --> 호출
 */
	public static void main(String[] args) {
		Greet g = new Greet();//객체생성 코드 class에 있는 것이 메모리에 올라감.
			g.who = "코스타";
			g.message = "자바교육";
			
			g.sayHello();//호출
			
	}

}
