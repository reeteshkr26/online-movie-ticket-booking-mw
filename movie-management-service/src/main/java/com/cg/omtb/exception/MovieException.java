/**********************************************************************************************************************************
 -File Name         :   Movie Exception
 -Author            :   Reetesh Kumar Mandal
 -Creation Date     :   23-09-2020
 -Description       :   Exception class to handle the Runtime exception
 **********************************************************************************************************************************/
package com.cg.omtb.exception;


public class MovieException extends Exception{

	private static final long serialVersionUID = 1L;

	
	public MovieException(String msg) {
		super(msg);
	}

	
}
