package com.edu.test;

import com.edu.child.Airplane;
import com.edu.child.Bird;
import com.edu.parent.Flyer;

public class InterfaceTest1 {

	public static void main(String[] args) {
		//abstract 가 있다면 객체생성의 대상이 될 수 없다.
		//대신에 타입으로서는 사용이 가능함. 
		//Flyer f = new Flyer();
		
		//같은 폴더 내에 있어야지만 import 안하고 컴파일 가능
		//아래의 경우 패키지가 다르니 import 필수, import의 대상은 class파일  
		Flyer f = new Bird();//Polymorphism : 부모타입으로 자식 생성
		
		//polymorphism 시 발생하는 두가지 현상
		System.out.println(((Bird) f).layEggs());//1 .object casting
		f.land();//2. virtual method invocation
			
		//////////////////////////////////////////////////////////
		
		Flyer f2 = new Airplane();
		f2.fly();
		f2.land();
		
		Flyer[] f3 = new Flyer[3];//타입으로는 가능한....
		
	}

}
