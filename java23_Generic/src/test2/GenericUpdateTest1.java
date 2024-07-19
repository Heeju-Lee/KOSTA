package test2;

import java.util.ArrayList;
import java.util.List;

//해당 코드에서는 Generic 기법을 사용
/*
 * 1. 뭐든지 담을 수 있다. box에 
 * 2. Object casting이 필요없게
 */
class Box<T>{//T라는 클래스는 실제로 존재하지 않지만 Type을 의미한다.
	T content; //box에는 T타입의 내용물이 담겨진다. T타입은 나중(객체생성, 사용시)에 구체적인 타입으로 대체될 것이다.
	
	public T selectContent() {
		return content;
	}
}

public class GenericUpdateTest1 {

	public static void main(String[] args) {
		Box<String> box = new Box<>();//사용시에 타입을 지정해 줌.
		box.content = "곰돌이인형";
		String bear = box.selectContent();
		
		System.out.println("박스안의 내용물을 .... "+bear);//Object casting이 필요없다.
		
		List<Integer> list = new ArrayList<>();
		
		list.add(10);//Auto Boxing 
		list.add(20);
		list.add(30);
		
		System.out.println(list);//10, 20, 30 Unboxing		
	}
}
