package com.project.user_service.exception;
public class InvalidRequestException extends RuntimeException	{

	public InvalidRequestException(String message)
	{
		super(message);
	}
}
