package com.onlywell.exception;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value = Exception.class)
	public Object globalErrorHandler(HttpServletRequest request, Exception e) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("code", 1001);
		result.put("message", "∑˛ŒÒ«Î«Û ß∞‹!");
		return result;

	}
}
