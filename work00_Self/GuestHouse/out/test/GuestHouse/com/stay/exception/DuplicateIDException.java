package com.stay.exception;

public class DuplicateIDException extends RuntimeException{
	
	public DuplicateIDException() {
		this("DuplicateId : 이미 존재하는 id 입니다.");
	}

	public DuplicateIDException(String msg) {
		super(msg);
	}

}
