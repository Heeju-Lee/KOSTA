package com.edu.array.test;

import com.edu.vo.NoteBook;
import com.edu.vo.Programmer;

//kate의 방식: 메모리는 효율적일지 몰라도 여러개의 값을 핸들링 불가능.
/*
 * bob의 방식으로 설계
 */
public class TonnysArrayTest3 {

	public static void main(String[] args) {
		NoteBook[] notebooks = { new NoteBook(111, "HP", 150), new NoteBook(222, "LG Gram", 170),
				new NoteBook(333, "SAMSUNG", 200) };

		Programmer bob = new Programmer("Bob");

		bob.buyNoteBooks(notebooks);// NoteBook[ ]//밥이 hasing
		System.out.println("Bob's NoteBook Information=====\n");
		NoteBook[] returns = bob.getNoteBooks();

		 for(NoteBook nb : returns) nb.printNoteBookInfo();
		
		 /*
		 * for(int i = 0; i<returns.length; i++)
		 	System.out.println(returns); 주소값이 반환됨...
		 */
	}
}
