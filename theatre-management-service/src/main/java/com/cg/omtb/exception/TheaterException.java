/**********************************************************************************************************************************
 -File Name         :   Theater Exception
 -Author            :   Sanjeev Kumar Yaduwanshi
 -Creation Date     :   23-09-2020
 -Description       :   Exception class to throw exception when a value entered could not be found in the database
 **********************************************************************************************************************************/


package com.cg.omtb.exception;

public class TheaterException extends Exception{
	
	private static final long serialVersionUID = 1L;
	
	/**********************************************************************************************************************************
	 -Method Name       :   TheaterException
	 -Input Parameters  :   String message
	 -Return Type       :	null
	 -Description       :   Method to throw exception with custom message
	 **********************************************************************************************************************************/

	public TheaterException(String msg) {
		super(msg);
	}

}
