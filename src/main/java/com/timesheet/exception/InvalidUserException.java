package com.timesheet.exception;

public class InvalidUserException extends Exception {
	private static final long serialVersionUID = 1L;
	static final String LOCATION="index.jsp";
	public String validateUser()
	{
		return LOCATION;
		
	}
	

}
