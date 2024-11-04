package com.web.spring.avdice;

import java.time.LocalDateTime;

import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.web.spring.exception.BoardSearchNotException;
import com.web.spring.exception.DMLException;


//모든 예외를 전역적으로 처리하는 어드바이스
@RestControllerAdvice
public class DefaultExceptionAdvice {
	
	@ExceptionHandler(BoardSearchNotException.class)
	public ProblemDetail boardSearchExceptionHandle(BoardSearchNotException e) {
		ProblemDetail problemDetail = ProblemDetail.forStatus(e.getHttpStatus().value());
		problemDetail.setTitle(e.getTitle());
		problemDetail.setDetail(e.getMessage());
		
		//추가적으로 정보를 설정할 부분은 아랫코드로 작성..
		problemDetail.setProperty("timestamp", LocalDateTime.now());
		return problemDetail;
		
	}
	
	@ExceptionHandler(DMLException.class)
	public ProblemDetail dMLExceptionHandle(DMLException e) {
		ProblemDetail problemDetail = ProblemDetail.forStatus(e.getHttpStatus().value());
		problemDetail.setTitle(e.getTitle());
		problemDetail.setDetail(e.getMessage());
		
		//추가적으로 정보를 설정할 부분은 아랫코드로 작성..
		problemDetail.setProperty("timestamp", LocalDateTime.now());
		return problemDetail;
		
	}
	@ExceptionHandler(Exception.class)
	public ProblemDetail exceptionHandle(Exception e) {
		ProblemDetail problemDetail = ProblemDetail.forStatus(600);//상태코드중 하나 넣어도 상관없음.
		problemDetail.setTitle("DB Error...");
		problemDetail.setDetail("작업중 문제가 발생하였습니다."+e.getMessage());
		
		//추가적으로 정보를 설정할 부분은 아랫코드로 작성..
		problemDetail.setProperty("timestamp", LocalDateTime.now());
		return problemDetail;		
	}
	//필요한 예외가 있으면 계속 이런 식으로 추가할수 있다...
}
