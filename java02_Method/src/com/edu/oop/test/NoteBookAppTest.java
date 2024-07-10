package com.edu.oop.test;

import com.edu.oop.NoteBook;

/*
 * 1. NoteBook 객체생성 n
 * == Notebook의 멤버(필드(3)+메소드(1)="4")를 메모리에 올린다.
 * 2. 접근
 	필드 --> 값할당
 	메소드 --> 호출
 */
public class NoteBookAppTest {

	public static void main(String[] args) {
		//객체 생성 코드 , n= reference variable, instance variable
		NoteBook n = new NoteBook();
		
			n.serialNumber = 111;
			n.brand = "LG Gram";
			n.price = 1760000;

			n.printNoteBookInfo();
			
			// n에 할당된 주소값
			System.out.println(n);
			
			//--------------------------
			
			NoteBook n2 = new NoteBook();
					
			n2.serialNumber = 222;
			n2.brand = "SAMSUNG";
			n2.price = 1350000;
			
			n2.printNoteBookInfo();
			
			System.out.println(n2);}

}
