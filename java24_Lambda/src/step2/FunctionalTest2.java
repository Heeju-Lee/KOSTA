/*
 Predicate의 결합
 default method :: and(), or(), negate() 2개를 사용해서 하나의 predicate로 결합가능하다.
 
 함수형 인터페이스의 구성요소
 1) 추상메소드가 하나 있어야 함.
 ----------------------------
 2) static 메소드 
 3) default 메소드  
 하지만 가장 핵심은 추상메소드이다!!!!! 
 */
package step2;

import java.util.function.Predicate;

public class FunctionalTest2 {

	public static void main(String[] args) {
		Predicate<Integer> p = i -> i<100;//100보다 작은 수 
		Predicate<Integer> q = i -> i<200;//200보다 작은 수
		Predicate<Integer> r = i -> i%2==0;//짝수
		
		//default 함수의 결합
		Predicate<Integer> notP = p.negate();//i<=100
		Predicate<Integer> all = notP.and(q).or(r);//i>=100 && i<200 || i%2==0
		Predicate<Integer> all2 = notP.and(q.or(r));//i>=100 && (i<200 || i%2==0)
		
		//Predicate를 사용할 때는 test()사용한다.
		System.out.println(all.test(2));//true
		System.out.println(all2.test(2));//false
	}
	
}
