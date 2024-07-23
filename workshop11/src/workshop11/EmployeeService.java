package workshop11;

import java.util.List;
import java.util.function.Consumer;

public class EmployeeService {

	public void raiseSalary(List<Employee> employees, Consumer<Employee> c) {
		Employee[] list = null;
		
		for(Employee e: list) {
			e.setSalary((Math.round(e.getSalary()*1.15)));
			c.accept(e);
		}

	}
}