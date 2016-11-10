package spittr.web;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice	// 모든 컨트롤러의 모든 예외를 감지.
public class AppWideExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public String errorSpittleHandler() {
		return "error/error";
	}
}
