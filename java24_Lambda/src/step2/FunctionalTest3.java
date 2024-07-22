/*
	collection :: 객체를 저장하는 방법론
	List | Map | Set | Iterable
	
	8버전 이후에 함수형 인터페이스를 hasing하면서 제공되는 기능이 추가됨.
	
	Collection : boolean removeIf (Predicate ate p)
	List : void replaceAll()
	Map : compute(), forEach(!!!!!!!), merge
	
 */

package step2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class FunctionalTest3 {

	public static void main(String[] args) {
		//List 생성(1,2,3,4,5,6,7,8,9,10 값 담김)
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i=0; i<10; i++) list.add(i);
		
		//Map 생성
		Map<Integer, String> map = new HashMap<>();
		map.put(111, "SCOTT");
		map.put(222, "BLAKE");
		map.put(333, "KING");
		
		//1.  리스트에 담긴 객체를 뽑아서 정보를 출력한다.
		/*
		 * Iterator<Integer> it=list.iterator(); while(it.hasNext()) {
		 * System.out.println(it.next()); }
		 */		
		System.out.println("1. 리스트에 담긴 객체를 뽑아서 정보를 출력 ===> forEach()");
		list.forEach(i -> System.out.print(i+" "));//forEach는 그냥 소비하는 것임. 그래서 consumer가 있음. 반환 x
		//list.forEach(System.out::print);
		
		//2. list에 담긴 값중에서 2의배수 혹은 3의 배수를 제거한 후 출력
		/*
		 * System.out.println("2. 리스트에 2의배수 혹은 3의 배수를 제거한 후 출력 ===> removeIf()");
		 * list.removeIf(i-> i%2==0 || i%3==0); System.out.println(list);
		 */
		System.out.println("3. 리스트의 모든 값들을 10 곱한다. ===> replaceAll()");
		list.replaceAll(i -> i*10);
		System.out.println(list);
		
		//2.  맵에 담긴 객체를 뽑아서 정보를 출력한다.
		
		System.out.println("------------------Map------------------");
		System.out.println("\n4. Map에 있는 모든 key, value 값을 출력 ===> interator()");
		Iterator<Integer> it = map.keySet().iterator();
		while(it.hasNext()) {
			int key = it.next();
			System.out.println("key : "+key+", value : "+map.get(key)+" ");
		}
		
		
		
		System.out.println("\n5. Map에 있는 모든 key, value 값을 출력 ===> forEach()");
		map.forEach((a,b) -> System.out.println("Key :"+a+", Value :"+b));
		
	}
	
}
