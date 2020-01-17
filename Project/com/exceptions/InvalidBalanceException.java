package com.exceptions;

public class InvalidBalanceException extends Exception {
	String str;

	public InvalidBalanceException(String str) {
		this.str = str;
	}
	public String toString()
	{
		return "Message: "+str;
	}
	

}

