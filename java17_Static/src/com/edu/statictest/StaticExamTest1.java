package com.edu.statictest;
/*
static 키워드 특징
1. static한 성질의 멤버는 객체생성 과정없이 메모리에 올라간다.
2. 컴파일 / 실행 
	실행단계 "class file loader" 단계에서 미리 메모리에 올라간다.
3. 클래스이름.static 멤버
	System.out
	System.in
	Integer.parseInt()
	EmployeeService.getInstance()
	Math.random()
	main()
4. !!!!!!!!static한 멤버는 생성된 객체들이 다 공유하는 성질의 것이다!!!!!!!!!!!!!
5. Member Level에서 사용된다. local level에서는 사용 못한다. 메소드 내에서 사용 불가하다는 말
6. static은 static끼리 통한다.(메모리에 올락가는 시점이 다름)
 */

class Member{
	int ssn = 1234;
	static String name  = "길동";
	static int age = 19;
	
	public static void memberInfo() {
		System.out.println("우/유/빛/깔/"+name);
	}
}
public class StaticExamTest1 {
	public static void main(String[] args) {
		
//		static int count = 0;//local level 불가
		
		
		Member m = new Member();
		System.out.println(m.name);
		m.memberInfo();

	}

}
