package com.edu.statictest;
/*
Access Modifier ::: public < protected < private
Usage  Modifier ::: static, final, abstract

static + final 주로 함께 많이 쓰인다. (순서는 중요치 않음)
***
final ::::: " 내가 마지막이야~!!!!!!!" 라는 의미를 가지는 키워드
final + 변수 -- > "내가 마지막 변수야 ~!!!!!!"  --> 상수값 지정
final + 클래스 --> "내가 마지막 클래스야 ~!!!!!!" --> 상속 금지(sub 클래스 그만 만들어)
final + 메소드 --> "내가 마지막 메소드야 ~!!!!!!" --> 오버라이딩 금지(상속 시 자식은 고쳐쓰지마)
 */
public class StaticExamTest4 {

class A{
	public final static int BASE_SALARY = 4000;//상수
	public final String test() {
		return "Overriding 금지";
	}
}

final class B{//상속 금지
	
}

class D extends A{
//	public final String test() {//고치려는 시도 모두를 막아버림.
//		return "Overriding 금지";
}


/*
 * class C extends B{//B에 FINAL 붙어있음. 불가
 * 
 * }
 */

	public static void main(String[] args) {
		//A.BASE_SALARY = 500; final 이라 값변경 안됨.
	}

}
