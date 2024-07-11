package com.edu.oop;
/*
 * Notebook의 정보를 저장하고 있는 클래스
 */
public class NoteBook {
	//field 선언 
	public int serialNumber;
	public String brand;
	public double price;
	
	public NoteBook() {  }//기본 생성자
	
	//명시적 생성자
	public NoteBook(int serialNumber, String brand, double price) {
		//필드 초기화
		this.serialNumber = serialNumber;
		this.brand = brand;
		this.price = price;
	}
	
	//기능 추가___필드에 값을 할당,주입,setter(inject),write,set,pack
		
	/*필드와 로컬변수의 이름이 같으면 필드앞에 this.을 붙여줌
	 this는 해당 객체의 주소값을 참조하고 있다.
	 */

	//Setter (메소드)
	public void setNoteBookField(int serialNumber, String brand, double price) {
		this.serialNumber = serialNumber;
		this.brand = brand;
		this.price = price;
			
	}

	// 주입된 값을 받아오는 것 : get, read, unpack
	// 정수와 string이 concat 되면 string으로 변환되어 반환됨.
	public String getNoteBookInfo() {
		return serialNumber+ ", "+brand+", "+price+"정보";
	}
	
	//method 정의 (선언문 + 구현부)
	//void : 반환타입 - 해당 기능을 수행한 후에 반환되는 데이터 x 의미
	public void printNoteBookInfo() {
		System.out.println(serialNumber+","+brand+","+price);
	
	}
	
}
