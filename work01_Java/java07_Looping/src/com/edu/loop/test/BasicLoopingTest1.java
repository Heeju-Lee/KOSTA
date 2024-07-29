package com.edu.loop.test;
/*
	for | while | do while
	for(초기식 ; 조건식 ; 증감식)
	 
 */
public class BasicLoopingTest1 {

	public static void main(String[] args) {
		System.out.println("===========for===========\n");
		for(int i=0 ; i<10; i++)
			System.out.println("Hello for Looping    "+i);
		
		System.out.println("===========while===========\n");
		int i=10;
		while(i>0) {
			System.out.println("Hello while Looping    "+i);
			i--;
		}//안맞으면 실행 안됨.
		
		System.out.println("===========do while===========\n");
		int j=10;
		do {
			System.out.println("Hello do while Looping    "+j);
			j++;
		}while(j<10);
		
	}//무조건 실행이 됨.
		
}
