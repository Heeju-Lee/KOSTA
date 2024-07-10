package com.edu.capsul.test;
//month에 의해서 day가 
import java.util.Scanner;

import com.edu.capsul.MyDate;

public class MyDateTest {

	public static void main(String[] args) {

		MyDate md = new MyDate();
			
		//필드에 직접적으로 꽂는 행위 X, 외부 Class에서 direct로 꽃히면 정확하지 않은 값이 꽂혀도 구제방법이 X, 프로그램 X,*/

		//md.month = 13; direct로 field에 넣으면 부정확한 값 구제불가
		//md.day= 33;
		Scanner sc =new Scanner(System.in);
		System.out.println("월 입력>>");
		int month = sc.nextInt();
		
		System.out.println("날짜 입력>>");
		int day =sc.nextInt();
		
		
		md.setMonth(month);//111
		md.setDay(day);
/*		if(md.getMonth() != 0 && md.getDay() != 0) {좋지 않은 코드*/ 
		System.out.println("Today is "+md.getMonth()+"월 "+md.getDay()+"일 입니다.");
		
	}//main

}//class
