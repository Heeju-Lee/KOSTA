package com.edu.vo.test;

import com.edu.vo.NoteBook;
import com.edu.vo.Programmer;

/* Test class 에서 하는 일
 * 1. 객체생성
 * 2. 메소드 호출
 */
public class ProgrammerTest {

	public static void main(String[] args) {
		/*
		 * 1. james라는 개발자를 생성
		 *    tomas 라는 개발자를 생성
		 */ 
	Programmer james = new Programmer("james","JAVA",3000,"ABC",2500);
	Programmer tomas = new Programmer("tomas","JAVA",4000,"BCD",2000);
	
		// 2. james가 HP노트북을 구매
		// tomas 가 LG노트북을 구매
	
		/* 아래처럼 코딩하지 않기. 간단하게
		 * NoteBook nb1 = new NoteBook(111,"HP",170);
		 *  james.buyNoteBook(nb1);
		 */

	james.buyNoteBook(new NoteBook(111,"HP",170));
	tomas.buyNoteBook(new NoteBook(222,"LG",270));
		
		 // 3. tomas가 구매한 노트북의 가격과 브랜드명을 출력
	System.out.println("===tomas가 구입한 노트북 정보입니다===");
	NoteBook tomasNoteBook=tomas.getNoteBook();
	System.out.println(tomasNoteBook.getNoteBookInfo());
	
		 //4. james의 연봉을 출력
	System.out.println("===james의 연봉 정보입니다===");
	System.out.println(james.getAnnualSalary());
		 
		 // 5. tomas의 급여를 인상.....최종적인 연봉을 출력
	System.out.println("===tomas의 급여인상을 반영한 연봉 정보입니다===");
	tomas.getRaiseSalary(50);
	System.out.println(tomas.getAnnualSalary());
	
	}
}
