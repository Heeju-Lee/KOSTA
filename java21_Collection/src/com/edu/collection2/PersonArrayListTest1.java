package com.edu.collection2;

import java.util.ArrayList;

import com.edu.vo.Person;

public class PersonArrayListTest1 {

	public static void main(String[] args) {
		ArrayList list = new ArrayList();//<> 제너릭: 안에 저장된 객체의 타입을 알려주는 역할
		
		//add
		list.add(new Person(11, "AA"));
		list.add(new Person(22, "BB"));
		list.add(new Person(33, "CC"));
		list.add(new Person(44, "DD"));
		list.add(new Person(55, "EE"));
		
		System.out.println(list);//
		System.out.println(list.size());//
		list.trimToSize();//size 와 capa가 같아지게 하는 것. 기본사이즈가 10인데 capa를 5로 수정함
		
		//리스트에 있는 사람 중에서 2번째 사람의 정보를 출력.
		Person secondPerson =(Person)list.get(1);//해당 인덱스에 들어있는 객체를 가져오는 기능
		System.out.println(secondPerson);
		
		//리스트에 들어있는 사람들의 평균 나이를 구하라.
		int sum = 0;
		for(Object o : list) {
				sum+=((Person) o).getAge();
			
			System.out.println("평균연령은 "+sum/list.size());
		}
		
	}

}
