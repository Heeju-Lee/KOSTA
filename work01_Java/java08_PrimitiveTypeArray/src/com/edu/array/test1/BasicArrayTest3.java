package com.edu.array.test1;
/*
 * 배열 : Same Data Type
 * 선언 + 생성 + 초기화 == 동시에 한번에 하는 경우
 * 한번에 진행되더라도 묵시적 초기화가 진행됨.
 * 진행 후 주소값 할당 ==> 스택에 할당 ==> 레퍼 ==> 오버라이팅
 */
public class BasicArrayTest3 {

	public static void main(String[] args) {

		int[] scores = {95, 78, 66, 90, 87};

		//향상된 for 문을 이용해서 성적들의 총합 / 평균값을 각각 출력
		
		int sum = 0;//총합 값을 저장할 로컬변수 선언
		
		for(int score : scores) sum+= score;
		
		System.out.println("성적들의 총합 :"+sum);
		System.out.println("평균 성적 :" + sum/scores.length);
		
		
	}

}
