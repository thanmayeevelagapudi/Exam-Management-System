package com.project.user_service.exception;

public class GuestNotFoundException extends RuntimeException{
	
	public GuestNotFoundException(String message) {
		super(message);
	}

}
