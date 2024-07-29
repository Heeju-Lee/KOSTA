package com.kosta.test;

import com.kosta.vo.Movie;

public class MovieMgr {
	
	Movie[] movies;
	private int index;
	
	public MovieMgr(int size) {
		movies = new Movie[size];
	}	
	
	//Singleton 과정
	private static MovieMgr mgr = new MovieMgr();
	private MovieMgr() {}
	public static MovieMgr getInstance() {
		return mgr;		
	}
	//영화 추가하는 기능
	public void addMovie(Movie m) {
		if(index==movies.length)
			System.out.println("현재 영화 추가는 불가능합니다.");
		else {
			movies[index++] = m;
			System.out.println(m.getTitle()+"영화 추가가 완료되었습니다.");
		}
	}
	
	//영화를 감독으로 검색하는 기능
	/*
	 * public Movie searchMovie(String title) { Movie movie = null; for(Movie m :
	 * movies) { if(m=null) continue; if(m.getTitle().equals(title)) movie=m;
	 * if(m.getTitle().equals(title)) movie=m; if(m.getTitle().equals(title))
	 * movie=m;
	 * 
	 * } }
	 */
	//영화를 감독으로 검색하는 기능
	/*
	 * public void serchAllMovie(String mov) { ; }
	 * 
	 * //영화를 감독으로 검색하는 기능 public void serchAllMovie(String mov) {
	 * 
	 * }
	 */
		
		
		
	//정보를 출력하는 기능을 추가
	public void printInfo() {
		for(Movie m : movies) {
			if(m==null) break;
			System.out.println(m.toString());
		}
	}
}
	
	
