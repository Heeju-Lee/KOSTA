package com.edu.statictest;
/*
static한 변수는 생성된 객체들에서 공유하는 값이다.
 */
class Car{
	int serialNumber;//field
	static int counter;//static
	
	Car(){
		counter++;
		serialNumber=counter;
	}
}

public class StaticExamTest2 {

	public static void main(String[] args) {
		Car car1 = new Car();
		Car car2 = new Car();
		Car car3 = new Car();
		
		System.out.println("============== field Value ==============");
		System.out.println(car1.serialNumber);
		System.out.println(car2.serialNumber);
		System.out.println(car3.serialNumber);
		
		System.out.println("============== static Value ==============");
		System.out.println(car1.counter);//같은 값을 공유한다. 
		System.out.println(car2.counter);
		System.out.println(car3.counter);
		System.out.println(Car.counter);
		
	}

}
