package com.edu.condition.test1;

import java.util.Random;

//Formating 출력하기 | 삼항 연산자
public class PrintFormatTest4 {
	public static void main(String[] args) {
		Random r = new Random();
		String result = "";
		
		System.out.println("=========큰 수? 혹은 작은 수?===========");
		int num = r.nextInt(100);//o~99사이의 정수
		
		if(num>50) result = "큰 수";
		else result = "작은 수";
		
		System.out.println(num+"은 "+result+"이다.");		
		System.out.printf("%d은(는) %s이다.%n",num,result);//%d=정수,%s=string,%n=new Line

		System.out.println("\n###########삼항 연산자###########");		
		System.out.println("===========짝수? 혹은 홀수?===========");
		
		int num2 = r.nextInt(10);//0~9 임의의 정수 랜덤.
		/*
		 * if(num2 % 2==0) result = "짝수"; else result = "홀수";
		 */
		
		result=(num2 % 2==0) ? "짝수" : "홀수";//result = 조건 = true값 : false 값
		System.out.printf("%d은(는) %s이다.%n",num2, result);
				
	}

}
