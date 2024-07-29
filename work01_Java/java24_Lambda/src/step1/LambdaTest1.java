/*
람다, 람다식
::
함수형 프로그래밍
자바는 자바8버전부터 함수형 프로그래밍인 람다식을 제공
::
1) 익명함수(함수명이 없다.)
2) 코드가 간결하고 성능적으로는 불리한 부분이 있다.
3) 병렬처리 가능하다.
::
<일반적인 함수 형식>
public int max(int a, int b){//max 함수명 / () 매개변수 {} 구현부(리턴값있음)
	return a>b ? a:b;
}
<람다식>
"매개변수 -> 구현부"
(int a, int b) -> {return a>b ? a:b;}
(int a, int b) -> a>b ? a:b; (return 생략가능 ; 생략불가)
(a, b) -> a>b ? a:b; (매개변수 타입도 생략가능)
-------------------------------------------------------------------------
@FunctionalInterface의 구현체를 우리는 람다식으로 만들어야 한다.
그렇기 때문에 @FunctionalInterface는 단 하나의 추상메소드만 가져야 한다.
*/
package step1;

@FunctionalInterface //어노테이션, 안해도 에러는 안나지만 하는게 좋음. why? 마킹을 하게되면 컴파일 시에 추상메소드가 하나인지 아닌지를 checking 해줌.
interface MyFunction{ //추상 메소드가 단 하나인 인터페이스 -> functional interface
	int max(int a, int b); // 2개의 수중 더 큰 수를 반환하는 기능의 template
}

public class LambdaTest1{

	public static void main(String[] args) {
		//1. 익명클래스로 구현
		MyFunction f = new MyFunction() {//new 와 myfunction 사이에 선언된 익명의 클래스 무언가가 max를 가지고 있음. 
			@Override
			public int max(int a, int b) {
				return a>b?a:b;
			}
		};
		
		int result1 = f.max(5, 3);//anonymous에 접근하는 방법...
		System.out.println("Result1=>"+result1);	
		
		//2. 람다식으로 구현(매개변수 -> 구현부;)
		MyFunction f2 = (a,b)->a>b?a:b;
		int result2 = f2.max(5, 3);
		System.out.println("Result2=>"+result2);	
	}
}
