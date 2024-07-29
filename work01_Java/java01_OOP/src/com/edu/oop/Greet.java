package com.edu.oop;
/*
 클래스의 구성요소 : 성질과 행위 
 field(변수) : 클래스의 특징
 method : 클래스를 통해서 하는 기능
 */
public class Greet {
	//필드 선언
	public String who;
	public String message;
	
	//메소드 정의(선언부 + 구현부)
	public void sayHello() {
		//콘솔창에 출력...누구에게 어떤 인삿말을 하는지...
		System.out.println(who+", "+message);
		
	}//sayHello(worker method)
	
}//class
