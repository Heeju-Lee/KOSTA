package com.edu.dice.play;

import com.edu.dice.Dice;
import com.edu.dice.DiceA;
import com.edu.dice.DiceB;
//DiceA, DiceB, DiceC를 직접적으로 연결하면 재사용성이 떨어지는 코드가 된다.
//Player02 <------------Dice 연결
public class Player02 {
	
	///Field
	private Dice dice;
	private int totalValue;
	
	///Constructor Method
	public Player02() {
	}
	public Player02(Dice dice) {
		this.dice = dice;
	}
	
	///Method (getter/setter)
	public Dice getDice() {
		return dice;
	}
	public void setDice(Dice dice) {
		this.dice = dice;
	}
	public int getTotalValue() {
		return totalValue;
	}
	public void setTotalValue(int totalValue) {
		this.totalValue = totalValue;
	}
	
	//==> count 만큼 주사위를 굴려서 합을 후하는 행위
	public void playDice(int count){
		
		System.out.println("==>"+getClass().getName()+".playDice() start....");

		for (int i = 0; i < count; i++) {
			dice.selectedNumber();
			System.out.println("::[ "+dice.getClass().getName()+" ] 의 선택된수 : "+dice.getValue());
			totalValue += dice.getValue(); 
		}
		
		System.out.println("==>"+getClass().getName()+".playDice() end....");
	}

}//end of class