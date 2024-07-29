package com.edu.oop.test;

import com.edu.oop.NoteBook;

/*
 필드에 직접 값을 할당하지 않고, 
 setxxx(0,0,0)기능을 호출해서 필드초기화를 구동
 */
public class NoteBookAppTest2{
	public static void main(String[] args) {
		//객체 생성 코드 , n= reference variable, instance variable
		NoteBook n = new NoteBook();//메모리올리고 == 객체생성
				
/* 필드에 최종적인 값으로 채워지는 것: 필드초기화
인자값,값 순서대로 매개변수로 꽂힘.
 */
		n.setNoteBookField(123, "LG Gram", 1700000);//호출
				//n.printNoteBookInfo();
		System.out.println(n.getNoteBookInfo());//호출
	}
		
}
	
		
		
		
		
		
		
		