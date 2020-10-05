
/**********************************************************************************************************************************
 -File Name         :   BookingException.class
 -Author            :   Reetesh Kumar Mandal
 -Creation Date     :   24-09-2020
 -Description       :   Exception class to handle the Runtime exception
 **********************************************************************************************************************************/

package com.cg.omtb.exception;

public class BookingException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public BookingException(String msg) {
		super(msg);
	}

}
