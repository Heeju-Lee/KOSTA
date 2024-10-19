package com.web.spring.controller;

import org.springframework.web.bind.annotation.RestController;

import com.web.spring.entity.Member;
import com.web.spring.service.MemberService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequiredArgsConstructor
@Slf4j
public class MemberController {
	
	private final MemberService memberService;
	
	
	//signUp
	@PostMapping("/members")
	public String signUp(@RequestBody Member member) {
		memberService.signUp(member);
		return "OK";
	}
	
	//duplicateCheck
	@GetMapping("/members/{id}")
	public String duplicateCheck(@PathVariable String id) {
		System.out.println("ID ===>>>"+id);
		return memberService.duplicateCheck(id); 
	}

}
