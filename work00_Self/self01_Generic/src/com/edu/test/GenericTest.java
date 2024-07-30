package com.edu.test;

class EverythingBox<T>{
	
	public T type;
	
	public EverythingBox(T t) {
		this.type = type;
	}
	
	public T getType() {
		return type;
	}
	
	//인스턴스 메소드
	public T addBox(T x, T y) {
		return null;
	}
	public static <T> T addBoxStatic(T X, T y) {
		return null;
	}

}
public class GenericTest {

	public static void main(String[] args) {
		EverythingBox<String> stringBox = new EverythingBox<>(""); 
		EverythingBox.addBoxStatic("안녕","잘가");
		EverythingBox.addBoxStatic(156489,578974);
		

	}

}
