/**********************************************************************************************************************************
 -File Name         :   Theater Exception Handler
 -Author            :   Sanjeev Kumar Yaduwanshi
 -Creation Date     :   23-09-2020
 -Description       :   Global Exception Handler.
 **********************************************************************************************************************************/


package com.cg.omtb.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.omtb.exception.TheaterException;

@RestControllerAdvice
public class TheaterExceptionHandler {
	
	@ExceptionHandler(TheaterException.class)
	public ResponseEntity<String> userExceptionHandler(TheaterException exception){
		return new ResponseEntity<>(exception.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
	
	  @ExceptionHandler(Exception.class) 
	  public ResponseEntity<String> otherExceptionHandler(Exception exception){
		  return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		
	  }
	 
}
