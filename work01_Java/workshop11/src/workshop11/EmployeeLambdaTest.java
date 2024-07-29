package workshop11;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class EmployeeLambdaTest {

	public static void main(String[] args) {

		List<Employee> employees = new ArrayList<Employee>();
		employees.add(new Employee(1, "SCOTT", 30000.0));
		employees.add(new Employee(2, "ADAMS", 25000.0));
		employees.add(new Employee(3, "SMITH", 21000.0));
		employees.add(new Employee(4, "KING", 50000.0));
		
		System.out.println("\n===========1. 직원들의 인상급여 정보 출력===========");
		
		Consumer<Employee> consumer = x -> {
			x.setSalary((Math.round(x.getSalary()*1.15)));
		};
		
		Consumer<Employee> consumer1 = x -> {
			x.setSalary((Math.round(x.getSalary()*1.5)));
		};
		
		raiseSalary(employees, consumer.andThen(System.out::println));
		
		System.out.println("============================================");
		
		raiseSalary(employees, consumer1.andThen(System.out::println));
		
		
	}//main
	
	private static void raiseSalary(List<Employee> list, Consumer<Employee> c) {
		for(Employee e: list) c.accept(e);
	}

}
