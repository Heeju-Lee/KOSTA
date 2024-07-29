package com.edu.vo;
/*
 * Programmer가 여러대의 NoteBook을 구매하기 위해서는
 * 반드시 필드에 NoteBook 타입이 아닌 
 * NoteBook[] 선언되어야 한다. 
 * 	NoteBook[] noteBooks;/
 */
public class Programmer {
	//생성자 주입
	String name;
	String mainSkill;
	float salary;
	String address;
	int bonus;
	
	//////////////Has a Relation//////////////개발자가 노트북을 hasing/using
	//setter 주입
	NoteBook[] noteBooks;//변수명은 동일하게 
	
	public Programmer() {}
	
	public Programmer(String name) {
		this.name = name;
	}

	public void buyNoteBooks(NoteBook[] noteBooks) {
		this.noteBooks = noteBooks;
	}
	public NoteBook[] getNoteBooks() {
		return noteBooks;
	}



	public String getNoteBookInfo() {
		return name+","+mainSkill+","+salary;
	}
	
	///기능을 추가
	//개발자의 연봉을 리턴하는 기능
	public float getAnnualSalary() {
		return salary * 12 + bonus;
	}
	
	//개발자의 급여를 기존보다 50만원 더 인상하는 급여(return 없음)
	public void getRaiseSalary(int amount) {
		// 아래와 같은 의미_ salary = salary + amount;
		salary += amount;
	}
	
}///class

