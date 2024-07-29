package com.edu.array.test;

class Contact2{
	String name;
	//생성자 주입
	public Contact2(String name) {
		this.name = name;
	}
	
	public void printName() {
		System.out.println(name+"....print!!");
	}
}
//Kate's 
public class TonysArrayTest2 {

	public static void main(String[] args) {
		Contact2 contactRef = null;//선언
		int x = 0;
		while(x<10) {
			contactRef = new Contact2("PersonName...."+contactRef);//x개 생성
			System.out.println("Contact2 Reference...."+contactRef);
			x++;
		}
		contactRef.printName();
	}
	
}/// 결과 : 주소값이 각각 다름
