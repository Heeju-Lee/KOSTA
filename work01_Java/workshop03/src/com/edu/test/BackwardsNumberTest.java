package com.edu.test;

import java.util.Scanner;

public class BackwardsNumberTest {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.print("1이상의 숫자를 입력하세요 :");
			int userInput = sc.nextInt();
				
			if(userInput<1) {
				System.out.println("1이상의 숫자를 입력해주세요");
			}else {
		        for (int i = userInput ; i >= 1; i--) 
		            System.out.print(i +"\t");
		        
		     break;
			}
		}
	}
}
		
		/*
 * 실행 시 사용자로부터 값 하나를 입력 받아 
 * 1부터 그 숫자까지 모든 숫자를 거꾸로 출력합니다
	단 입력한 수는 1보다 크거나 혹은 같아야 합니다.
1) 1 이상의 숫자 입력 시 해당 숫자부터 1까지 거꾸로 출력합니다.

2) 1 미만의 숫자 입력 시 “1 이상 숫자를 입력하세요“ 라는 메시지와 함께 다시 사용자가
숫자를 입력할 수 있도록 코드를 작성합니다
*/

