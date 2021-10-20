package com.bridgelabz.app.exceptionhandler;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.bridgelabz.app.dto.AddressDTO;
import com.bridgelabz.app.dto.ResponseDTO;

@RestControllerAdvice
public class Exception {
	
	/**
	 * Exception is handeled for not valid Id
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(ABSException.class)
	public ResponseEntity<ResponseDTO> notValid(ABSException ex) {
		ResponseDTO dto=new ResponseDTO("Exception while processing request",ex.getMessage());
		return new ResponseEntity<>(dto,HttpStatus.NOT_FOUND);
	}
	
	/**
	 * Exception is handeled for invalid pattern
	 * @param exception
	 * @return
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ResponseDTO> notValid( MethodArgumentNotValidException exception){
		List<ObjectError> errors =exception.getBindingResult().getAllErrors();
		List<String> errorMessages=errors.stream().map(error->error.getDefaultMessage()).collect(Collectors.toList());
		ResponseDTO dto=new ResponseDTO("Exception while processing request",errorMessages);
		return new ResponseEntity<>(dto,HttpStatus.BAD_REQUEST);
	}
	
}
	
	