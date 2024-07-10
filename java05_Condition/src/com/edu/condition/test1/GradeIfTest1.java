package com.edu.condition.test1;
/* 
 조건문
 ::
 if(조건 A)/ else if (조건 B), else if (조건 C), ...../ else(나머지 모든 경우)
 
 if(조건 A){
 // 실행

 }else if(조건 B){
 //실행

 }else if(조건 C){
 //실행

 }else{
 //실행 

}
 */
public class GradeIfTest1 {

	public static void main(String[] args) {
		int grade = 88; // grade = local 변수, 기본값이 없기 때문에 반드시 초기화를 해야한다. "88"=실제값, Literal value
		
		if(grade >=90 & grade  <=100) {
			System.out.println("A Grade");
		}else if(grade >=80 & grade <90) {
			System.out.println("B Grade");
		}else if(grade >=70 & grade <80) {
			System.out.println("C Grade");
		}else {
			System.out.println("Try Again");
		}

	}

}
