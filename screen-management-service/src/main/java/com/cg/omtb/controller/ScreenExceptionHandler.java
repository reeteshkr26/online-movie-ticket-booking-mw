package com.cg.omtb.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.omtb.exception.ScreenException;

@RestControllerAdvice
public class ScreenExceptionHandler {

	@ExceptionHandler(ScreenException.class)
	public ResponseEntity<String> userExceptionHandler(ScreenException exception){
		return new ResponseEntity<>(exception.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
	
	  @ExceptionHandler(Exception.class) 
	  public ResponseEntity<String> otherExceptionHandler(Exception exception){
		  return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		
	  }
}
