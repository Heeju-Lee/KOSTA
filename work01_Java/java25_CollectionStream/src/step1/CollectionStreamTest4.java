package step1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
	스트림 만드는 작업과정
	1. 스트림 생성 ... stream()
	2. 중간연산자
	3. 최종연산자
 */
public class CollectionStreamTest4 {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1,2,3,4,5);
		///////////1.. 스트림은 1회성이다. //////////////
		Stream<Integer> intStream =list.stream();
		//3.. 최종연산자
		intStream.forEach(System.out::print);
		
		System.out.println();
		
		intStream =list.stream();//추가...다시스트림을 연다.
		intStream.forEach(System.out::print);//error_stream has already been operated upon or closed
		
		System.out.println("------------------------------------------");
		// sum 기능은 없다. 이 기능은 IntStream에 있다.
		
		Stream<Integer> intStream2 = Stream.of(1,2,3,4,5);
		System.out.println("intStream2 count : "+intStream2.count());
//		
//		System.out.println("intStream2 sum : "+intStream2.sum()); 
		
		System.out.println("------------------------------------------");
		//IntStream
		int[] intArr = {1,2,3,4,5};
		IntStream intStream3 = Arrays.stream(intArr);
//		intStream3.forEach(System.out::print);
//		System.out.println(intStream3.sum());		
//		System.out.println(intStream3.average());	// 평균
		System.out.println(intStream3.findFirst());	// 첫번째
		
		
	}
}
