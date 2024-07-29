package com.edu.test;

class Unit{
	int currentHP; //유닛의 체력
	int x; //유닛의 x좌표
	int y; //유닛의 y좌표
}

interface Movable{
	void move(int x, int y);
	void jump(int height);
}

interface Attackable{
	void attack(Unit u);
}

interface Fightable extends Movable, Attackable{
	//template 기능 3개 들어있다.
}

//클래스와 인터페이스 동시 상속시 순서는 1. 클래스 2. 인터페이스(다중이 가능하기 때문임)
class Fighter extends Unit implements Fightable{

	@Override
	public void move(int x, int y) {
	}

	@Override
	public void jump(int height) {
	}

	@Override
	public void attack(Unit u) {
	}
}

public class InterfaceTest2 {

	public static void main(String[] args) {

		Fighter f = new Fighter();
		
		if(f instanceof Unit);
			System.out.println("f는 Unit의 자손입니다.");

		if(f instanceof Fightable);
			System.out.println("f는 Fightable의 자손입니다.");	
		
		if(f instanceof Movable);
		System.out.println("f는 Movable의 자손입니다.");	
			
		if(f instanceof Attackable);
		System.out.println("f는 Attackable의 자손입니다.");		
	
		if(f instanceof Object);
		System.out.println("f는 Object의 자손입니다.");		
	}
}
