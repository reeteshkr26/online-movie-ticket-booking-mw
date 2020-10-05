
/**********************************************************************************************************************************
 -File Name         :   BookingExceptionHandler.class
 -Author            :   Reetesh Kumar Mandal
 -Creation Date     :   24-09-2020
 -Description       :   Global Exception Handler.
 **********************************************************************************************************************************/
package com.cg.omtb.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.omtb.exception.BookingException;
import com.cg.omtb.exception.TicketException;

@RestControllerAdvice
public class BookingExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> otherExceptionHandler(Exception exception){
		return new ResponseEntity<>(exception.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(TicketException.class)
	public ResponseEntity<String> ticketExceptionHandler(TicketException ex){
		return new ResponseEntity<>(ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(BookingException.class)
	public ResponseEntity<String> bookingExceptionHandler(BookingException ex){
		return new ResponseEntity<>(ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
