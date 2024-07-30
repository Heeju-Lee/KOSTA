package com.edu.exception;

public class DuplicateIsbnException extends Exception{
	public DuplicateIsbnException(String message){
		super(message);
	}
	
	public DuplicateIsbnException() {
		this("Duplicate Isbn....이미 존재하는 사람입니다.");
	}

}
