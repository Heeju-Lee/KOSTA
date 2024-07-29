package com.edu.singletone.test;

//DB연결을 하지는 않지만
class EmployeeDAO{
	
	//1. private static으로 객체 생성
	private static EmployeeDAO dao = new EmployeeDAO();
	
	//2. 생성자 앞에 private
	private EmployeeDAO() {
		System.out.println("싱글톤으로 객체 하나만 일단 생성");///생성자가 한번 돌았음을 알 수 있음
	}
	
	//3. public static한 성질로 만든 객체를 반환하는 기능을 정의
	public static EmployeeDAO getIstance() {
		return dao;
	}
	
	
	public void register(String name) {
		System.out.println("Register Service....."+name+".....Register Success!!!");
	}
	
	public void search() {
		System.out.println("Search Service.....OK!!!");
	}
	
	
}
//Client side....BLAKE, SCOTT, SMITH 세명의 직원이 사내사이트 접속.... 직원가입을 요청
public class EmployeeDAOTest {
	
	public static void main(String[] args) {
		EmployeeDAO.getIstance().register("BLAKE");
		EmployeeDAO.getIstance().register("SCOTT");
		EmployeeDAO.getIstance().register("SMITH");//생성자가 한번밖에 돌지 않았음.

	}

}
