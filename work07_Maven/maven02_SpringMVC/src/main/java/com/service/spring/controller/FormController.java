package com.service.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.service.spring.vo.User;

@Controller
public class FormController {
	//html의 폼의 값이 자동으로 컨트롤러에 바인딩하는 방법
	@RequestMapping("/form.do")
	public ModelAndView form(User user) {
		/*
		 1. 1) 폼값 받아서
		 	String name = request.getParameter("userName");
		 	String addr = request.getParameter("userAddr");
		 	String id = request.getParameter("id");
		 	
		 	2) pvo 생성
		 	  -> User pvo = new User(); 기본생성자로 생성 후 
		 	  	 pvo.set(); :: setter로 주입한다.생성자 주입 x
		 	
		 2. DAO 리턴받고 비즈니스 로직 호출
		 3. (데이타 바인딩-->ServletRequest에 자동 바인딩)
		 4. (네비게이션--> forwarding)
		 .....1~4까지 했다 치고...
		 */
		
		return new ModelAndView("result","info",user);
	}
}
