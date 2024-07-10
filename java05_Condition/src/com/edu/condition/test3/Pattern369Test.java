package com.edu.condition.test3;

import java.util.Scanner;

public class Pattern369Test {
	public static void solv(int number) {
		//코드구현
		String str ="";
		
		int tensDigit = number / 10;
		int onesDigit = number % 10;
		
		if(tensDigit%3==0) {
			str+="@";
			
			if(onesDigit%3==0) {
				str+="@";
			}
		}
		else {
			
			if(onesDigit%3==0) {
				str+="@";
			}
			else{
				System.out.println(number);
				System.exit(0);
			}
		}
		
		System.out.println(str);
		
	}
		
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("2자리 숫자입력>> ");
		int n = sc.nextInt();
		
		solv(n);
		
	}

}



///빠져나오고 싶을 때는 system.exit(0)