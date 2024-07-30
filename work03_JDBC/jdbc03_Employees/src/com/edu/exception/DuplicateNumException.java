package com.edu.exception;

public class DuplicateNumException extends Exception{
	public DuplicateNumException(String message){
		super(message);
	}
	
	public DuplicateNumException() {
		this("Duplicate Number....이미 존재하는 사람입니다.");
	}

}
