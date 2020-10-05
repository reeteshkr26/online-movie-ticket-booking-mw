
/**********************************************************************************************************************************
 -File Name         :   ExceptionException.class
 -Author            :   Reetesh Kumar Mandal
 -Creation Date     :   24-09-2020
 -Description       :   Exception class to handle the Runtime exception
 **********************************************************************************************************************************/

package com.cg.omtb.exception;

public class TicketException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public TicketException(String msg) {
		super(msg);
	}
}
