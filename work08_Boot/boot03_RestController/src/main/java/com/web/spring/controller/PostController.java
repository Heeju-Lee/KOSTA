package com.web.spring.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.spring.dto.Member;

@RestController
@RequestMapping("api/v1")
public class PostController {

	//데이타 전달이 목적...request 객체의 Body에 담겨서 전달되는 값을 받는다.
	@PostMapping("/members")
	public String insertMember(@RequestBody Member pvo) {
		//service 함수를 호출...insert..dao..DB
		return pvo.toString();
	}	
	
	@PostMapping("/members2")
	public String insertMember2(@RequestBody Map<String, String> data) {
		StringBuilder sb = new StringBuilder();
		data.entrySet().forEach(map->{
			sb.append(map.getKey()+" : "+map.getValue());
		});
		return sb.toString();
	}
}
