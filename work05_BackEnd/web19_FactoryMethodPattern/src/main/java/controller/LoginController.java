package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginController implements Controller {
	
	private static LoginController register = new LoginController();
	private LoginController() {};
	public static LoginController getInstance() {
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
		System.out.println("LoginController...login 비즈니스로직 호출..");
		return "login_result.jsp";
	}
}
