package step1;

@FunctionalInterface
interface Workable{
	String monthPayment(String ename, double weekSal);
}
//재사용성...LambdaTest4에서 확인!!!
class Employee{//Workable을 매개변수로 hasing
	public void work(Workable w) {//hasing으로 함수형 interface를 넣음
		String result = w.monthPayment("Smith", 2000.0); // 값을 넣어서 호출
		System.out.println("Result=>"+result);
	}
}

public class LambdaTest2{

	public static void main(String[] args) {
		Employee e = new Employee();
		//람다
		e.work((a,b) -> {
			//구현체를 작성
			double salary = b * 4 +100.0;
			return a+" 씨의 4주 급여는 "+salary;	
		});
	}
}
