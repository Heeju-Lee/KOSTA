package com.edu.oop.test;

import com.edu.oop.Movie;

public class MovieAppTest {
	
///생성자
	public static void main(String[] args) {
		Movie one = new Movie("Gone with the Stock","Traget",-2);
		Movie two = new Movie("Lost in Cubicle Space","Comedy",5);
		Movie three = new Movie("Byte Club","Tragic but ultimately uplifting",127);
	
		System.out.println(one.getMovie());
		System.out.println(two.getMovie());
		System.out.println(three.getMovie());
	}
}

