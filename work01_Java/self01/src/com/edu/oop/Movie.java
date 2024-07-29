package com.edu.oop;

	// 필드 선언
public class Movie {
	public String title;
	public String genre;
	public int rating;
	
	//명시적 생성자가 하나라도 있으면 컴파일러가 기본생성자를 대신 넣어주지 않음
	/*기본생성자를 반드시 넣어야 함.무조건 넣어라.*/
	public Movie() {};
		
	// 필드 주입의 통로1_명시적 생성자
	public Movie(String title, String genre, int rating) {
		//필드 초기화
		this.title = title;
		this.genre = genre;
		this.rating = rating;
	}
	
	public void playIt() {
		System.out.println("Playing the movie");
	}
	
	// 필드 주입의 통로2_setter(메소드) 
	public void setMovie(String title, String genre, int rating) {
			//필드 초기화
		this.title = title;
		this.genre = genre;
		this.rating = rating;
	}
	
	//set의 반대 get으로 반환
	public String getMovie() {
		return title+ "\t"+genre+"\t"+rating;
	}

}