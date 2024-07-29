package com.edu.overloading.test;
//vo 클래스....table과 mapping//entity(table명)=Employee
//DB는 "_" 사용


class Employee{
	private int empno;
	private String name;
	private double salary;
	private String address;
	//추가..
	public static final double BASIC_SALARY = 100.0;
	public static final String BASIC_ADDR = "NY";
	
	//모든 클래스에서는 생성자가 1개 이상이다.
	Employee(){}// 아무일도 하지 않음

	public Employee(int empno, String name, double salary, String address) {
		this.empno = empno;
		this.name = name;
		this.salary = salary;
		this.address = address;
	}	
	
	public Employee(int empno, String name) {
		this(empno,name,BASIC_SALARY,BASIC_ADDR);
	}
	/*
	this  키워드
	1) this.empno = empno;
	==> 필드와 로컬변수의 이름이 같을 때 둘을 구분하기 위해서 필드앞에 지정
	2) this(empno,name,BASIC_SALARY,BASIC_ADDR);
	==> 생성자 앞에 this는 같은 클래스 내에서 또다른 생성자(인자값이 꽉찬 명시적 생성자)를 호출할 때 사용. 
	 */
	
	//필드값을 리턴하는 기능
	public String toString() {
		return empno+","+name+","+salary+","+address;
	}
}
public class OverloadingTest {

	public static void main(String[] args) {
		Employee e1 = new Employee(7369, "SCOTT", 30000, "Texas");
		Employee e2 = new Employee(7521, "SCOTT", 30000, "Texas");
		Employee e3 = new Employee(7899, "BlAKE");
	
		/*
		 * 생성자 오버로딩
		 * 필수정보만으로 객체생성을 할 수 있어야 한다.
		 * 객체를 생성할 때 인자값을 달리 입력해서 객체생성하는 기법
		 */

		System.out.println(e1);//toSting이 생략되어있음.
		System.out.println(e2);
		System.out.println(e3);

	}

}
