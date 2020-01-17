package com.exceptions;

public class InvalidAccountException extends Exception {
	String str;

	public InvalidAccountException(String str) {
		this.str = str;
	}
	public String toString()
	{
		return "Message: "+str;
	}
	

}

