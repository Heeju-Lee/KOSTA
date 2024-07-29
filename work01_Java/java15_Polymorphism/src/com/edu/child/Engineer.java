package com.edu.child;

import com.edu.parent.Employee;
import com.edu.util.MyDate;

public class Engineer extends Employee{
	
	//기본적으로 Employee의 멤버를 물려받는다.
	//자기 자신만의 멤버만 추가하면 된다.
	private String tech;
	private int bonus;
	
	public Engineer() {}
	
	//명시적 생성자 추가
	public Engineer(String name, double salary, MyDate birthDate,String tech,int bonus) {
		super(name, salary, birthDate);
		this.tech = tech;
		this.bonus = bonus;
	}
	
	//부모가 물려준 기능을 받아서   ..1step...선언부는 그대로
	//자신만의 것으로 고쳐서 사용한다..2step...구현부 다르게
	//===>Method Overriding (메소드 재정의)
	
	
	public String getTech() {
		return tech;
	}

	public void changeTech(String tech) {
		this.tech = tech;
	}

	public int getBonus() {
		return bonus;
	}

	public void changeBonus(int bonus) {
		this.bonus = bonus;
	}
	
	 @Override
	public String toString() {//선언부는 못고쳐
		return super.toString()+", tech: "+tech+", bonus: "+bonus;//구현부는 고쳐
	}

}
