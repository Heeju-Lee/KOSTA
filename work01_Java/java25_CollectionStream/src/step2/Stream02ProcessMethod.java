package step2;

import java.util.Arrays;

public class Stream02ProcessMethod {

	public static void main(String[] args) {
		int[] intArr = {1,2,3,4,5};
		System.out.println("============1. 중간처리 연산자 잘못 사용하는 경우===========");
		Arrays.stream(intArr)
				.filter(i->i%2==0)
				.peek(System.out::println);// 최종처리가 없으면 출력이 안됨.(중간연산자는 지연된 연산을 한다.)
		
		System.out.println("============2. 중간처리 연산자 peek을 제대로 사용하는 경우===========");
		int sum = Arrays.stream(intArr)
				.filter(i->i%2==0)
				.peek(i->System.out.print(i +" "))
				.sum();//최종처리
		
		
		System.out.println("\nResult : "+sum);
		
	}
}
