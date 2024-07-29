package test3;

import java.util.List;

abstract class Animal{
	public void eat() {
		System.out.println("Animal eating...");
	}
}

class Dog extends Animal{
	//eat(){} 당근 물려받음
	@Override
	public void eat() {
		System.out.println("Dog eating...");
	}
	void bark() {
		System.out.println("Dog Bark..");
	}
}

class Cat extends Animal{
	//eat(){} 당근 물려받음
	@Override
	public void eat() {
		System.out.println("Cat eating...");
	}
	void meow() {
		System.out.println("Cat Meow..");
	}
}

public class GenericWildCardTest4 {

	public static void main(String[] args) {
		List<Animal> animals=List.of(new Dog(), new Cat(), new Dog());
		takeAnimals(animals);
		
		List<Dog> dogs=List.of(new Dog(), new Dog());
		takeAnimals(dogs);
		
//		//wild card 적용하는 기능 정의
//		public static void takeAnimals(List<Animal> animals) {
//			for(Animal a:animals) a.eat();			
//		}
//		위에 takeAnimals를 사용하면 에러난다.dogs인데 animals에 할당 되어야 하지 않나.? 다형성 아닌가? 왜 에러가 나는가
//		다형성과 전혀 상관없지 않지만 다르다.
//		왜냐하면 애니멀타입의 컨테이너에 dog은 들어갈 수 있지만 dog 타입의 컨테이너는 들어갈 수 없다.
//		다형성처럼 사용하기 위해서는 와일드카드를 사용해줘야한다.
		
	}
	
	//wild card 적용하는 기능 정의
	//List<T>
	public static void takeAnimals(List<? extends Animal> animals) {
		for(Animal a:animals) a.eat();			
	}
	
	
}
