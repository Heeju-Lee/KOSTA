package step1;
/*
 스트림의 특징
 1. Read only - 스트림은 데이타소스로 부터 데이타를 읽어들이기만 할 뿐 변경하지 않는다. - 원본 변경x
 2. 일회용이다. Iterator처럼 일회용이다. 즉, 최종연산이 진행되면 닫힌다.(필요하면 재생성 필요)
 3. 최종연산전까지 스트림의 중간연산이 수행되지 않는다. - 지연된 연산.....최종연산 수행시 중간연산이 동시에 수행된다.
 4. 병렬처리 작업이 가능하다. - 멀티 스레드 지원
 	FP(함수형 언어)는 빅데이타(대용량 작업)를 빠르게 처리하기 위해서 발전되어온 기술이다. AI
 	그러기 위해서는 직렬적 작업보다는 병렬작업으로 많은 양의 데이터를 효율적으로 처리하는 기술이 필수.
 5. Stream<Integer>		VS 	 IntStream
 	Stream<Double>			 DoubleStream
 	Stream<Long>			 LongStream
 	Stream<Float>			 FloatStream
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CollectionStreamTest2 {

	public static void main(String[] args) {
		//1. 문자열 리스트 소스인 스트림을 생성
		List<String> fruits = new ArrayList<String>();
		fruits.add("Apple");
		fruits.add("Banana");
		fruits.add("Apple");
		fruits.add("Melon");
		fruits.add("Grape");
		fruits.add("Orange");		
		fruits.add("Melon");
		fruits.add("Grape");
		
		System.out.println("원본 리스트1 ::: "+fruits);
		Stream<String> s = fruits.stream();//1)스트림 생성
		s.distinct().limit(3).sorted().forEach(i->System.out.print(i+" "));
		System.out.println("===================================");
		System.out.println("\n원본 리스트2 ::: "+fruits);
		
		//2. 문자열 배열이 소스인 스트림
		String[] strArr = {"dd","aaa","CC","cc","b"};
		Stream strStream=Stream.of(strArr);
		strStream.forEach(System.out::println);//여기서 이미 최종연산 진행됐다. (스트림요소를 사용했다.)
		
		//long count =strStream.count();
		//System.out.println("남은 데이타 갯수 : "+count);//최종연산을 하면 스트림이 닫혀버린다. 다시 사용할 수 없다.
		
		//3.
		System.out.println("\n==================================");
		IntStream intStream = new Random().ints(1, 46);
		//intStream.forEach(i -> System.out.print(i+" ")); // 1~45가지의 값을 무한 반복함.
		intStream.distinct().limit(6).sorted().forEach(i -> System.out.print(i+" "));
		System.out.println("\n===================================");
		
		//4.
		String[] strArr2 = {"dd","aaa","CC","cc","b"};
		Stream<String> strStream2=Stream.of(strArr2);
		
		int sum = strStream2.parallel().mapToInt(p->p.length()).sum();
		System.out.println("\n모든 문자열의 길이의 합은 "+sum);
		
		
		
		}

}
