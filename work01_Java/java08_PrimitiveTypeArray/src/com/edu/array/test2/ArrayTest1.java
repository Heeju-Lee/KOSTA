package com.edu.array.test2;
/*
 배열은 한번 잡은 사이즈는 바뀔 수 없다.
 사이즈를 변경하는 순간 새로운 배열이 만들어진다.
 */
public class ArrayTest1 {

	public static void main(String[] args) {
		int[] members = {1,2,3,4,5};//예를들어 주소값이 100이었다면, 
		
		members = new int[8];//새로운 배열 객체 생성+묵시적 초기화, 주소값이 200, 스택에 주소오버라이팅, 100이었던 객체는 GC가 처리함.
		
		//명시적 초기화ds
		members[5] = 6;
		members[6] = 7;		
		members[7] = 8;

		for(int member : members) 
			System.out.println(member);
		
	}

}
