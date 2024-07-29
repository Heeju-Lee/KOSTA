package com.edu.oop.test;

import com.edu.oop.NoteBook;

/*
생성자
:: 객체가 생성될"때마다" 구동하는 것.

 */
public class NoteBookAppTest3{
	public static void main(String[] args) {
		//객체 생성 코드 , n= reference variable, instance variable
		NoteBook n = new NoteBook();//메모리올리고 == 객체생성
		NoteBook n2 = new NoteBook(999,"SAMSUNG",2200000.0);

				System.out.println(n.getNoteBookInfo());
				System.out.println(n2.getNoteBookInfo());
	}
}

		
	
		
		