package com.web.spring.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class DMLException extends RuntimeException{
	private String message;
	private HttpStatus httpStatus;
	private String title;
	
	public DMLException(String message, String title,HttpStatus httpStatus) {	
		this.message = message;
		this.httpStatus = httpStatus;
		this.title = title;
	}
	
	public DMLException(String message, String title) {	
		this(message,title,HttpStatus.EXPECTATION_FAILED);
	}
}
	

