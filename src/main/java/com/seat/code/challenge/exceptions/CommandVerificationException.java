package com.seat.code.challenge.exceptions;

public class CommandVerificationException extends Exception {
	private static final long serialVersionUID = 1L;
	
	private int errorCode = 0;
	private String errorMessage = "";
	
	public CommandVerificationException(int errorCode, String errorMessage) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
