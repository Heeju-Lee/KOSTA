package test3;

class Person{	
}
class Worker extends Person{	
}
class Employee extends Person{
}
class Manager extends Employee{	
}
class Engineer extends Employee{
}

class Application<T>{//제한된 파라미터 타입 사용 못함. 클래스 타입에서는 적용될 수 없다. 
	T kind;

	public Application(T kind) {
		this.kind = kind;
	}	
}

class PersonService{
	public static void register1(Application<?> application) {
		System.out.println(application.kind.getClass().getSimpleName()+" 이 등록됨.");
	}
	public static void register2(Application<? super Worker> application) {
		System.out.println(application.kind.getClass().getSimpleName()+" 이 등록됨.");
	}
	public static void register3(Application<? extends Employee> application) {
		System.out.println(application.kind.getClass().getSimpleName()+" 이 등록됨.");
	}
}

public class GenericWildCardTest3 {

	public static void main(String[] args) {
//		PersonService.register1(new Application(new Employee()));//ok
//		PersonService.register2(new Application(new Manager()));//ok
		PersonService.register3(new Application(new Manager()));//ok
	}
}
