package com.edu.array.test2;
/*
배열은 사이즈는 불변하지만
다른 배열의 데이타를 카피해 사용할 수 있다.
System.arraycopy() 함수를 사용한다.
:: 
1. 여러개의 값을 하나로 묶는 기능.....전제조건 SameDataType
2. 배열은 사이즈 변경 불가 resizing 불가.
3. 사이즈가 다른 배열의 요소값을 copy해서 올 수는 있음.
4. 배열은 객체다......클래스가 제공되지 않는 객체다.
 */
public class ArrayTest2 {

	public static void main(String[] args) {
		int[] targets = {1,2,3,4,5,6};//사이즈가 6
		int[] sources = {10,9,8,7,6,5,4,3,2,1};//사이즈가 10
		
		// sources 데이터를 copy해서......[2]~[7] copy \ target 처음부터 끝까지....
		// target 1,2,3,4,5,6 ===> 8, 7, 6, 5, 4, 3
		// System.arraycopy()
		
		System.arraycopy(sources, 2, targets, 0, targets.length);//copy 진행되는 행
		
		for(int i : targets) System.out.print(i+" ");
				
	}

}
