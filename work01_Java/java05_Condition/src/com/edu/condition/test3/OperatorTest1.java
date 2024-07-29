package com.edu.condition.test3;

public class OperatorTest1 {

	public static void main(String[] args) {
	
		//선언과 동시에 할당
		int i = 5;//로컬변수는 값을 리터럴 값 할당
		int j = 3;
		/*
		 98
		 두자리수
		 십의 자리 : 9 
		 일의 자리 : 8		 
		 */
		// "%"  ..mod...숫자를 나눈 후 나머지 값
		System.out.println("연산자 % : "+i%j);//2
		System.out.println("연산자 / : "+i/j);//1

		int num = 98;
		System.out.println("십의 자리 : "+num/10);
		System.out.println("일의 자리 : "+num%10);
		
		//1 씩 증가 ++, 1 씩 감소 --	
		int k = 10;

		System.out.println(k++);//10
		System.out.println(k);//11
	
		int m = 10;

		System.out.println(++m);//11
		System.out.println(m);//11
	///////////////same/////////////////
		Operator1 o1 = new Operator1();//reference 객체
		Operator1 o2 = new Operator1();
			
		System.out.println(o1);
		System.out.println(o2);
		System.out.println(o1==o2);//false
		
		System.out.println(o1!=o2);//true "!=" 같지 않다.
		/////////////////short circuit/////////////
		System.out.println(o1.test1()|o1.test2());//true or false = true
		System.out.println("################");
		System.out.println(o1.test2() & o1.test1());//true or false = false
	
		System.out.println("==================");
		System.out.println(o1.test1()|o1.test2());
		System.out.println("################");
		System.out.println(o1.test2() && o1.test1());
		
		
		//equals() == 
		//equals는 주소값을 비교하는 건데 string에서는 문자열이 같을 때 
		System.out.println("=====Operator1 equals()============");
		System.out.println(o1.equals(o2));//false
		System.out.println(o1==o2);//false
		
		String msg1 = "Hello";
		String msg2 = "Hello";
		System.out.println("======String equals()============");
		System.out.println(msg1.equals(msg2));//true
		
	}
}//class

class Operator1{
	public boolean test1() {
		System.out.println("test1() calling.......");
		return true;
	}//method
	public boolean test2() {
		System.out.println("test2() calling.......");
		return false;
	}//method
}//class

class Operator2{
	public boolean test1() {
		System.out.println("test1() calling.......");
		return true;
	}//method
	public boolean test2() {
		System.out.println("test2() calling.......");
		return false;
	}//method
}//class
