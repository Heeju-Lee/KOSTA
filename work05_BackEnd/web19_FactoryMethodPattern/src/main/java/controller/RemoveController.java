package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RemoveController implements Controller {
	
	private static RemoveController register = new RemoveController();
	private RemoveController() {};
	public static RemoveController getInstance() {
		return register;
	}
	
	@Override
	public String handle(HttpServletRequest request, HttpServletResponse response) {
		/*
		* 폼값 받아서
		* DAO 비즈니스 로직 리턴받고...
		* 데이타 바인딩
		* 네비게이션
		*/
		System.out.println("RemoveController...remove 비즈니스로직 호출..");
		return "remove_result.jsp";
	}
}
