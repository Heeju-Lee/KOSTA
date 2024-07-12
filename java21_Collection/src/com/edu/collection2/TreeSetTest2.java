package com.edu.collection2;

import java.util.Set;
import java.util.TreeSet;

/*
	Set
	 |
	HashSet
	 |
	TreeSet(중복 x, 순서 x, sort 기능 추가)
 */
public class TreeSetTest2 {

	public static void main(String[] args) {
		Set set = new TreeSet();
//		set.add("BBB");
//		set.add("CCC");
//		set.add("AAA");
//		set.add("PPP");
//		
//		System.out.println(set);
		
		set.add(11);//Boxing
		set.add(22);
		set.add(3);
		set.add(10);
		set.add(20);
		set.add(100);

		System.out.println(((TreeSet) set).higher(10));//11
		System.out.println(((TreeSet) set).lower(100));//20
		System.out.println(((TreeSet) set).headSet(20));//20포함안됨.20 기준 앞으로
		System.out.println(((TreeSet) set).tailSet(20));//20포함 뒤까지
		
	}

}
