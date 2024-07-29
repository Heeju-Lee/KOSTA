package com.edu.exception;

public class RecordNotFoundException extends Exception{
	public RecordNotFoundException() {
		this("찾고자하는 직원은 데이터가 존재하지 않습니다.");
	}
	public RecordNotFoundException(String message) {
		super(message);
	}
	
}
