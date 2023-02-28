package com.gft.exception;

public class ExceededLimitException extends DesafioApiException {

	private static final long serialVersionUID = -8960094070025753832L;

	public ExceededLimitException(String message) {
		super(message);
	}
}
