package com.edu.oop.test;

import com.edu.oop.Movie;

public class MovieAppTest2 {
	
//setter 
	public static void main(String[] args) {
		Movie one = new Movie();
		Movie two = new Movie();
		Movie three = new Movie();
	
		
		  one.setMovie("Gone with the Stock","Traget",-2);
		  two.setMovie("Lost in Cubicle Space","Comedy",5);
		  three.setMovie("Byte Club","Tragic but ultimately uplifting",127);
		 

		System.out.println(one.getMovie());
		System.out.println(two.getMovie());
		System.out.println(three.getMovie());
	}
}


