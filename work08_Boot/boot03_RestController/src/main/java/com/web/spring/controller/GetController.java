package com.web.spring.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.web.spring.dto.Member;

/*
 * 단순한 페이지를 요청하는 Get방식의 Controller를 다뤄보겠다.
 */
@RestController
public class GetController {
	
	
	//1. 
	@GetMapping("/members")
	public String getMember(String id, Model model) {
		//서비스 함수 호출 결과로 id에 해당하는 Member 객체를 리턴받았다 치고
		Member rvo = new Member("KOSTA", "1234", "홍종각", "종각");
		return rvo.toString();
	}
	
	//2. http://localhost:9000/members?name=홍종각&address=종각
	@GetMapping("/member")
	public String getMember(@RequestParam String name, @RequestParam String address) {
		return name + "님이 사는 곳은 "+address+"입니다.";
	}
	
	//3. (중요) http://localhost:9000/member/값
	/*
	@GetMapping("/member/{name}")
	public String getMember(@PathVariable String name) {
		return "Hello, "+ name;
	}
	*/
	@GetMapping("/member/{name}")
	public String getMember(@PathVariable("name") String myName) {
		return "Hello3, "+ myName;
	}
	
}
