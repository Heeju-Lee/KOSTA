package step3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

/*
 Optional은 java 8에서 추가된 기능으로 값이 존재하지 않는 경우(null)를 다루는데 사용되는 클래스 
 이 클래스 값이 있을수도 있고 값을 반환받지 못하는 상황을 중재하는 일종의 컨테이너 역할을 한다. 
 그럼으로써 NullPointException 발생을 방지하는 효과가 있다. 
 */
public class OptionalStreamTest {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();//값이 없는 리스트를 일단 생성
		//List<Integer> list = Arrays.asList(1,2,3,4,5);
		
		// 값이 없으면 터진다. 
		// 예외발생 : NoSuchElementException
		//이를 방지하기 위해 나온것이 OPTIONAL이다.

//		double average = list.stream()
//			.mapToInt(i->i.intValue())
//			.average()
//			.getAsDouble();
//		System.out.println("average :"+average);
		
		//방법 1
		OptionalDouble optional=list.stream()
		.mapToInt(Integer::intValue) // i = integer 클래스 , i ->i.intValue()
		.average();
		
		if(optional.isPresent())
			System.out.println("방법 1_평균 : "+optional.getAsDouble());
		else
			System.out.println("방법 1_평균 : 0.0");
		
		//방법 2
		double avg = list.stream()
			.mapToInt(Integer::intValue) // integer 를 사용해 int 값으로 새로운 스트림 생성함
			.average()
			.orElse(0.0);
		System.out.println("방법 2_평균 : "+avg);
		
		//방법 3 
		list.stream()
		.mapToInt(Integer::intValue)
		.average()
		.ifPresent(i->System.out.println("방법 3_평균 : "+i));//값이 있을때만 출력, 값이 없으면 실행조차 안함.
	}

}
