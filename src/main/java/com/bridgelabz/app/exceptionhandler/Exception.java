package com.bridgelabz.app.exceptionhandler;

import java.util.NoSuchElementException;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.bridgelabz.app.dto.ResponseDTO;

@RestControllerAdvice
public class Exception extends RuntimeException {
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseDTO exceptionOfArgument() {
		return new ResponseDTO("Invalid Input", null);
	}
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseDTO invalidArgument() {
		return new ResponseDTO("no element found exception",null);
	}
	
	
}
