package com.service.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/*
 Controller를 작성하는 방법
 1. Controller 인터페이스를 상속
 2. POJO 로 만드는 방법이 있음.!!!!좀 더 advanced한 방법임 @ annotation으로 갈 것
 	나중에 <bean>이 생략됨
 */

@Controller
public class IndexController{
	//함수와 요청을 mapping
	@RequestMapping("/index.do")
	public ModelAndView doIndex() {
		/*
		 1. 폼값 받아서
		 2. DAO 리턴받고 비즈니스 로직 호출
		 3. (데이타 바인딩-->ServletRequest에 자동 바인딩)
		 4. (네비게이션--> forwarding)
		 .....1~4까지 했다 치고...
		 */
		return new ModelAndView("result","info","Plain Old Java Object~~!");
	}
}
