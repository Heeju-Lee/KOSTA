package com.edu.condition.test1;
/*
 * switch는 분기문임, "break" 는 해당하는 조건을 빠져나가고 switch문 전체에서 완벽히 빠져나간다.
	switch(조건에 해당하는 변수){
	 case 100: xx (가능)
	 case 90~100: error
	 
	 case 95:
	 case 90:
	 	//실행문
	 	
	 break; //반드시
	 
	 
	 case 80:
	 case 85: 
	 	//실행문
	 break;
	 
	 default:
	 	//실행문
	}
 */
public class GradeSwitchTest3 {

	public static void main(String[] args) {
		int grade =750;
		switch (grade) {
		case 90:
		case 95:
			System.out.println("A Grade~~");
			break;
			
		case 80:
		case 85:
			System.out.println("B Grade~~");
			break;
			
		case 70:
		case 75:
			System.out.println("C Grade~~");
			break;

		default:
			System.out.println("Nuts~~!!");
		}//switch
		
	}//main

}//class
