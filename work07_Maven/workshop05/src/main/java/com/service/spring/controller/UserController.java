package com.service.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.service.spring.domain.User;
import com.service.spring.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("memberLogin.do")
	public ModelAndView login(User user, HttpServletRequest request) throws Exception{
		
		System.out.println("getUser Before : " +user);//name, email 값이 null
		User rvo = userService.getUser(user);	
		
		System.out.println("getUser After : " +rvo);// 모든 값이 채워진 채로 반환
		String path = "index.jsp";
		String msg ="아이디 혹은 패스워드가 틀렸습니다.";
		
		if(rvo!=null) {//로그인에 성공했다면...세션에 바인딩.
			request.getSession().setAttribute("user", rvo);
			msg ="로그인에 성공하셨습니다.";
		}
		request.setAttribute("msg", msg);//로그인 성공여부에 따라서 저장되는 msg가 달라진다.	
		return new ModelAndView("redirect:"+path);
	}
	
	@RequestMapping("memberLogout.do")
	public ModelAndView logout(HttpSession session) throws Exception{
		session.invalidate();		
		
		return new ModelAndView("redirect:index.jsp");
	}

}















