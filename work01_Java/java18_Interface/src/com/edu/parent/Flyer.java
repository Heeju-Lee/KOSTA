package com.edu.parent;
/*
 인터페이스는 추상메소드들의 집합 + public static final 상수값
 ==
 public abstract 메소드와 public static final 상수값으로 구성되었다. 
 
 Template 기능 위주의 모듈
 필드는 제공되지 않는다.
 
 >>>완벽한 미완의 설계도
 > 인스턴스 생성불가 이것으로 제품을 생산할 수는 없다.
 > new의 불가, type으로는 가능 
 */
public interface Flyer {
	int MAX_SPEED = 200;//public static final 이 무조건 앞에 생략되어져 있다. static은 인스턴스를 뛰어넘어 사용됨.
	
	public abstract void fly(); // " ; " 의 기능 문장의 종결
	void land();//public abstract이 무조건 생략되어 있다.(Interface이기 때문)
	void take_off();
}
