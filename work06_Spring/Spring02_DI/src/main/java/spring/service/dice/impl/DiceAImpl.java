package spring.service.dice.impl;

import java.util.Random;

import spring.service.dice.Dice;

public class DiceAImpl implements Dice {

	private int value;
	
	
	public DiceAImpl() {
		System.out.println("::"+getClass().getName()+" 생성자....");
	}
	
	public DiceAImpl(int value) {
		this.value = value;
		System.out.println("::"+getClass().getName()+" 명시적 생성자....");
	}

	@Override
	public void selectedNumber() {
		value = new Random().nextInt(6) + 1;		
	}

	@Override
	public int getValue() {
		return value;
	}
}
