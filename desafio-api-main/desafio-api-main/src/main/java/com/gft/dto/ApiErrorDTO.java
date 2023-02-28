package com.gft.dto;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;

public class ApiErrorDTO {
	
	private String message;
	private List<String> erros;
	private HttpStatus status;
	
	public ApiErrorDTO() {
	}
	
	public ApiErrorDTO(String message, List<String> erros, HttpStatus status) {
		this.message = message;
		this.erros = erros;
		this.status = status;
	}
	
	public ApiErrorDTO(String message, String error, HttpStatus status) {
		this.message = message;
		this.erros = Arrays.asList(error);
		this.status = status;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<String> getErros() {
		return erros;
	}
	public void setErros(List<String> erros) {
		this.erros = erros;
	}
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	
	

}

