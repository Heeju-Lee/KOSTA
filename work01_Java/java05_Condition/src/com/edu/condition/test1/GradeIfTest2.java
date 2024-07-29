package com.edu.condition.test1;

import java.util.Scanner;
/*
 *  GradeIfTest1 코드는 컴파일 시점에 실제값88이 입력되는 코드, 프로그램이 아니다.
 *  실행시점에 값이 입력되도록 Scanner를 생성해서 값을 입력 받을 것임
 *  
 * 	학생이름 | 해당 학생의 점수를 입력 
 * 	조건을 그대로 작성
 *  출력화면 : 하승현, C Grade 로직을 추가 
 */


public class GradeIfTest2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);//system.in(키보드로 입력된 값)
		System.out.println("당신의 이름과 성적을 입력하세요.");
		
		String name = sc.next();//next는 공백, enter로 가능; nextLine 개행별로 넣을 때(line인식이 필요할 때) 
		int grade = sc.nextInt();
		
		
		if(grade >=90 & grade  <=100) {
			System.out.println(name +", A Grade");
		}else if(grade >=80 & grade <90) {
			System.out.println(name +", B Grade");
		}else if(grade >=70 & grade <80) {
			System.out.println(name +", C Grade");
		}else {
			System.out.println(name +", Try Again");
		}

	}

}
