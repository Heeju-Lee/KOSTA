package com.stay.exception;

public class DMLException extends RuntimeException{
	
	public DMLException() {
		this("DMLException SQL 문법 에러 입니다.");
	}
	
	public DMLException(String msg) {
		super(msg);
	}

}
