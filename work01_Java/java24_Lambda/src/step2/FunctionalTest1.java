/*
자주 사용되는 다양한 함수형 인터페이스 제공
 ::
 Runnable      run()                       매개변수 X, 반환값 X
 Supplier<T>   T get()              공급자   매개변수 X, 반환값 O
 Consumer<T>   void accept(T t)     소비자   매개변수 O, 반환값 X
 Function<T,R>  R apply(T t)        함수 .  매개변수 O, 반환값 O
 Predicate<T>   boolean test(T t)   조건식.  매개변수 O, 반환값 O boolean
----------------------------------------------------------------------------------------------------
 매개변수가 2개인 함수형 인터페이스
 BiConsumer<T,U>   void accept(T t, U u)   2개의 매개변수가 있고 반환값이 없음
 BiFunction<T,U, R>  R apply(T t, U u)       2개의 매개변수를 받아서 하나의 결과를 반환
 BiPredicate<T,U>   boolean test(T t, U u)   매개변수는 2개, 반환값은 boolean
 */
package step2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalTest1 {

	public static void main(String[] args) {
		System.out.println("\n---------------Supplier---------------");
		Supplier<Integer> s = () -> (int) (Math.random()*100)+1;// 1~100사이의 난수
		
		List<Integer> list = new ArrayList<Integer>();
		makeRandomList(s, list);
		System.out.println(list);
		
		System.out.println("\n---------------Consumer---------------");
		Consumer<Integer> c = i -> System.out.print(i+" ");
		
		System.out.println("\n---------------Predicate---------------");
		Predicate<Integer> p = i -> i%2==0;//짝수인지의 여부		
		
		System.out.println("\n---------------PrintEvenNumber---------------");
		printEvenNumber(p, c, list);
		
		System.out.println("\n---------------Function---------------");
		Function<Integer, Integer> f = i -> i/10 * 10;//i값의 일의 자리를 없애는 공식
		
		List<Integer> newList = doSomething(f, list);
		System.out.println(newList);
	}
	
	//makeRandomList
	public static void makeRandomList(Supplier<Integer> s, List<Integer> list) {
		for(int i =0; i <10; i++) {
			list.add(s.get());//supplier에서 1~100사이의 임의의 정수값을 받아서 list에 담는다.
		}
	}
	//printEvenNumber
	public static void printEvenNumber(Predicate<Integer> p, Consumer<Integer> c, List<Integer> list) {
		System.out.print("[");
		for(Integer i : list) {
			//만약에 i 값이 짝수라면
			//해당하는 값을 출력하도록
			if(p.test(i)) 
				c.accept(i);
		}System.out.print("]");	
	}
	
	public static List<Integer> doSomething (Function<Integer, Integer> f, List<Integer> list) {
		List<Integer> newList = new ArrayList<Integer>(list.size());
		for(Integer i : list) 
			newList.add(f.apply(i));//기존의 list 값을 변환해서(일의자리를 없애서 새로운 리스트를 생성)
		return newList;
	}
	
}
