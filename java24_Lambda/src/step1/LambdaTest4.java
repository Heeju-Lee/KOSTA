package step1;
/*
	LambdaTest2에서 기능의 매개변수로 인터페이스를 주입
	훨씬 더 간단한 코드로 다시 작성해보자.
	
	@FunctionalInterface
	
	0) 매개변수 x, 반환타입 x => Runnable void run() 별로 없음.
	1) 매개변수 o, 반환타입 x => Consumer void accept(o) set or sysoutprintln 값을 주입하거나 출력하고 끝남.
	2) 매개변수 x, 반환타입 o => Supplier T get() get, reading ex) ()->(int)(Math.random)
	3) 매개변수 o, 반환타입 o => Function T apply(T) // FunctionalInterface ex) i - > i * 100
	4) 매개변수 o, 반환타입 boolean Predicate boolean test(T) ex) i >-> i%2==0 true & false
	
 */

@FunctionalInterface
interface Calculable{
	void calculate(int a, int b);//하나의 추상메소드를 가진다. 매개변수 2 반환타입 x 1)번으로 작성
	
}
public class LambdaTest4{

	public static void main(String[] args) {
		//1. 함수형 인터페이스를 바로 사용....람다식....
		Calculable c = (a,b)->System.out.println(a+b);
		c.calculate(3, 4);
		
		//2.
		action((x,y)->{
			int result1 = x + y;
			System.out.println("result1 >"+result1);
		});
		
		action((x,y)->{
			int result2 = x * y;
			System.out.println("result2 >"+result2);
		});


		
		;}//main
	//2. Static 메소드 매개변수로 Hasing
	public static void action(Calculable cal) {
		
		System.out.println("action...method...");
		int a =11;
		int b =22;
		cal.calculate(a, b);
		
	}
	
	
	
	
}


