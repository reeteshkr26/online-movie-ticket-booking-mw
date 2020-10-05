/**********************************************************************************************************************************
 -File Name         :   Movie Exception Handler
 -Author            :   Reetesh Kumar Mandal
 -Creation Date     :   23-09-2020
 -Description       :   Global Exception Handler.
 **********************************************************************************************************************************/
package com.cg.omtb.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


import com.cg.omtb.exception.MovieException;

@RestControllerAdvice
public class MovieExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> otherExceptionHandler(Exception exception){
		return new ResponseEntity<>(exception.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@ExceptionHandler(MovieException.class)
	public ResponseEntity<String> orderExceptionHandler(MovieException exception){
		return new ResponseEntity<>(exception.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}


}
