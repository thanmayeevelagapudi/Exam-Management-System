package com.project.user_service.exception;

public class CredentialsInvalidException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CredentialsInvalidException(String msg){
		super(msg);
	}

}
