package com.web.spring.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class MemberAuthenticationException extends  RuntimeException{
    private String message;
    private HttpStatus httpStatus;
    private  String title;
    public MemberAuthenticationException(String message, String title){
        this(message , title, HttpStatus.UNAUTHORIZED);//
    }
    public MemberAuthenticationException(String message, String title, HttpStatus httpStatus){
        this.message=message;
        this.title=title;
        this.httpStatus=httpStatus;
    }
}
