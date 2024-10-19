package com.service.spring.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.spring.domain.Phone;
import com.service.spring.domain.UserInfo;
import com.service.spring.service.PhoneService;

@Controller
public class PhoneController {
	@Autowired
	private PhoneService phoneService;
	
	@GetMapping("/")// http://localhost:8888/spring/
	public String index() {
		return "redirect:index.jsp";
	}
	
	@GetMapping("searchPhone.do")
	public String doList(Model model, Phone phone) {
		try {
			List<Phone> phones =  phoneService.select();
			model.addAttribute("phones",phones);
			model.addAttribute("title","핸드폰 관리 - 핸드폰 목록 리스트");
			return "PhoneList";//InternalResourceViewResolver
		} catch (Exception e) {
			System.out.println(e);
			model.addAttribute("title","핸드폰 관리 - 에러발생");
			model.addAttribute("message","문제 내용 - 폰 조회 중 에러 발생");
			return "Error";
		}
	}
	
	//폰 등록하는 폼을 요청
	@GetMapping("/regPhone.do")
	public String getRegPhone(Model model) {
		model.addAttribute("title","핸드폰 관리 - 핸드폰 목록 등록 폼");
		return "PhoneReg";
	}
	
	//실질적으로 폰 정보가 저장되는 요청
	@PostMapping("/savePhone.do")
	public String doRegPhone(Model model, Phone phone) {
		try {
			System.out.println("PhoneService.insert... 호출 전 :: "+phone);
			phoneService.insert(phone);//dao insert 호출 --> sqlSession insert 호출
			
			model.addAttribute("title","핸드폰 관리 - 핸드폰 저장 성공");
			System.out.println("PhoneService.insert... 호출 후 :: "+phone);
			return "Result";
		}catch (Exception e) {
			System.out.println(e);
			model.addAttribute("title","핸드폰 관리 - 에러발생");
			model.addAttribute("message","문제 내용 - 폰 저장 중 에러 발생");
			return "Error";
		}
	}
	
	//폰 하나의 정보를 받아오는 요청(동적쿼리는 객체를 넣어줘야함)
	@GetMapping("/detail.do")
	public String doDetail(Model model, Phone phone) {
		try {
			System.out.println("doDetail...호출전.."+phone);
			Phone selected = phoneService.select(phone);
			
			System.out.println("doDetail...호출후.."+selected);
			model.addAttribute("phone",selected);
			
			model.addAttribute("title","핸드폰 관리 - 핸드폰 상세조회 성공");
			return "PhoneView";
		} catch (Exception e) {
			System.out.println(e);
			model.addAttribute("title","핸드폰 관리 - 핸드폰 에러");
			model.addAttribute("message","문제 내용 - 폰 상세조회 중 에러 발생");
			return "Error";
		}
	}
	//폼 삭제 요청... 비동기 처리 (	@ResponseBody 붙여줘야 함)
	@PostMapping("deleteAjax.do")
	@ResponseBody
	public String doAjaxDelete(Model model, @RequestParam("num") List<String> num) {
		try {
			phoneService.delete(num);
			return "";
		} catch (Exception e) {
			System.out.println(e);
			model.addAttribute("title","핸드폰 관리 - 핸드폰 에러");
			model.addAttribute("message","문제 내용 - 폰 삭제 중 에러 발생");
			return "Error";
		}
		
	}
	
	
	///////////// 로그인 요청 /////////////////////
	//로그인 폼을 먼저 요청....Get
	@GetMapping("/login.do")
	public String loginForm() {
		return "Login";		
	}
	
	//로그인을 진행하는 요청
	@PostMapping("/login.do")
	public String login(UserInfo user, Model model, HttpSession session) {
		try {
			UserInfo selected =phoneService.selectUser(user);
			if(selected != null) {//로그인 성공했다면
				session.setAttribute("loginUser", selected);
				return "redirect:searchPhone.do";
			}else{
				return "Login";
			}
		} catch (Exception e) {
			System.out.println(e);
			model.addAttribute("message","문제 내용 - 회원 로그인 중 에러발생");
			model.addAttribute("title","핸드폰 관리 - 에러발생");
			return "Error";
		}
	}
}
