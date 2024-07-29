package step2;
/*
 최종처리 연산자
 
 findFirst
 collect
 forEach
 anyMatch
 count
 */
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stream03ProcessMethod {

	public static void main(String[] args) {
		List<String> strings = List.of("I","am","a","list","String");
		
		//
		Stream<String> stream = strings.stream();
		stream = stream.limit(4);//중간처리연산자 limit 
		
		// System.out.println(stream);// 데이타 안나온다.
		
		//1. stream 에서 첫번째 데이타를 찾아서 바로 출력
//		System.out.println(stream.findFirst().get());// findfirst() 최종처리
		
		//2. stream안에 있는 스트링 데이타의 개수를 출력
//		System.out.println(stream.count());
		
		//3. stream 안에 있는 모든 스트링 데이타를 출력
//		stream.forEach(i->System.out.print(i+" "));
		
		//4. steram 안에 있는 스트링 데이타를 수집...collect
		List<String> result = stream.collect(Collectors.toList());
		System.out.println(result);
	}
}
