package com.gft.exception;

public class DesafioApiException extends RuntimeException {

	private static final long serialVersionUID = -6524350686916032717L;

	private String message;

	public DesafioApiException(String message) {
		super(message);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
