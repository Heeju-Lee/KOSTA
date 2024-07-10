package com.kosta.service;

import com.kosta.test.MovieMgr;
import com.kosta.vo.Movie;

public class MovieTest {


	public static void main(String[] args) {
		MovieMgr movieMgr = new MovieMgr(3);
		
		Movie m1 = new Movie("인사이드아웃2","켈시 만", 1,"애니메이션", "주인공 라일리가 13살이 되고 사춘기에 접어들자 감정 컨트롤 본부에 새로운 감정들이 등장하면서 일어나는 큰 변화를 다룬다.");
		Movie m2 = new Movie("범죄도시4","허명행", 2,"액션");
		Movie m3 = new Movie("그녀가 죽었다","김세휘", 3,"미스터리");
		Movie m4 = new Movie("그가 죽었다","김세휘", 3,"미스터리");
		
		//영화 추가 기능 호출
		System.out.println("=========영화를 추가합니다.=========");
		movieMgr.addMovie(m1);
		movieMgr.addMovie(m2);
		movieMgr.addMovie(m3);
		movieMgr.addMovie(m4);
		
		System.out.println("=====추가된 영화정보를 출력합니다.=====");
		movieMgr.printInfo();		
		
		

	}

}
