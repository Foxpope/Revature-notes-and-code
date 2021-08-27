package com.revature.exceptions;

public class NotAGradeException extends RuntimeException{

	public NotAGradeException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NotAGradeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public NotAGradeException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	//we're using this
	public NotAGradeException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public NotAGradeException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	
	
}
