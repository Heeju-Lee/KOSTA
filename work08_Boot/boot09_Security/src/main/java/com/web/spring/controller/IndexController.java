package com.web.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j //log함수를 자동으로 쓸 수 있다.
public class IndexController {
	
	@GetMapping("/")
	public String index() {
		
		//System.out.println("index()....call....");
		log.info("index()....call....");
		return "INDEX.....";
	}

}
