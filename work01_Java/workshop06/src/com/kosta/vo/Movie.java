package com.kosta.vo;

public class Movie {
	
	private String title;
	private String director;
	private int grade;
	private String genre;
	private String summary;
	
	public static final String BLANK_SUMMARY = "내용없음";

	//기본생성자
	public Movie(){}

	//생성자 주입(ALL)
	public Movie(String title, String director, int grade, String genre, String summary) {
		this.title = title;
		this.director = director;
		this.grade = grade;
		this.genre = genre;
		this.summary = summary;
	}
	//생성자 주입(summary 없음)
	public Movie(String title, String director, int grade, String genre) {
		this(title, director, grade, genre, BLANK_SUMMARY);
	}

	public String getTitle() {
		return title;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String toString() {
		return "title=" + title + ", director=" + director + ", grade=" + grade + ", genre=" + genre
				+ ", summary=" + summary + "  ";
	}
	
}
