package workshop11;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class FuctionTest {

	public static void main(String[] args) {

		Consumer<String> c = x -> 
			System.out.printf("%s는 1개의 매개변수를 가지고 반환값은 없어요!!", x.toUpperCase());// 내가 못한 부분.
		c.accept("consumer");
		
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(new Employee(1, "SCOTT", 30000.0));
		employees.add(new Employee(2, "ADAMS", 25000.0));
		employees.add(new Employee(3, "SMITH", 21000.0));
		employees.add(new Employee(4, "KING", 50000.0));

		EmployeeService empS = new EmployeeService();

		System.out.println("\n===========1. 직원들의 인상급여 정보 출력===========");
//		employees.forEach(x->{
//			x.setSalary(Math.round(x.getSalary() * 1.15));
//			System.out.println(x);
//		});
		
		Consumer<Employee> c1 = x->System.out.println(x);
		empS.raiseSalary(employees, c1);
		
		System.out.println("\n===========2. 직원들의 인상급여 정보 출력===========");
		Consumer<Employee> consumer = x ->{
			x.setSalary(Math.round(x.getSalary() * 1.15)); // 직원들의 급여가 15% 인상된 급여로 수정
			System.out.println();
		};
		
		raiseSalary(employees, consumer.andThen(System.out::println));
		 
	}
	private static void raiseSalary(List<Employee> list, Consumer<Employee> c) {
		for(Employee e : list)
			c.accept(e);
	}
}
