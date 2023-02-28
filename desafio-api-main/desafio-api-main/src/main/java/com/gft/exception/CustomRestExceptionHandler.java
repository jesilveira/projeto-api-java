package com.gft.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.gft.dto.ApiErrorDTO;

@ControllerAdvice
public class CustomRestExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler({ DesafioApiException.class })
	public ResponseEntity<ApiErrorDTO> handleDesafioApiException(DesafioApiException e, WebRequest request) {

		ApiErrorDTO apiError = new ApiErrorDTO(e.getMessage(),
				"Ocorreu um erro no nosso sistema. Tente novamente mais tarde.", HttpStatus.INTERNAL_SERVER_ERROR);

		return new ResponseEntity<ApiErrorDTO>(apiError, new HttpHeaders(), apiError.getStatus());
	}

	@ExceptionHandler({ EntityNotFoundException.class })
	public ResponseEntity<ApiErrorDTO> handleEntityNotFoundException(DesafioApiException e, WebRequest request) {

		ApiErrorDTO apiErrorDTO = new ApiErrorDTO(e.getMessage(), "Não conseguimos encontrar este recurso.",
				HttpStatus.NOT_FOUND);

		return new ResponseEntity<ApiErrorDTO>(apiErrorDTO, new HttpHeaders(), apiErrorDTO.getStatus());
	}

	@ExceptionHandler({ ExceededLimitException.class })
	public ResponseEntity<ApiErrorDTO> handleExceededLimitException(DesafioApiException e, WebRequest request) {

		ApiErrorDTO apiErrorDTO = new ApiErrorDTO(e.getMessage(), "O limite máximo deste recurso foi atingido!",
				HttpStatus.NOT_ACCEPTABLE);

		return new ResponseEntity<ApiErrorDTO>(apiErrorDTO, new HttpHeaders(), apiErrorDTO.getStatus());
	}

	@ExceptionHandler({ MinimumLimitException.class })
	public ResponseEntity<ApiErrorDTO> handleMinimumLimitException(DesafioApiException e, WebRequest request) {

		ApiErrorDTO apiErrorDTO = new ApiErrorDTO(e.getMessage(), "O limite mínimo deste recurso foi atingido!",
				HttpStatus.NOT_ACCEPTABLE);

		return new ResponseEntity<ApiErrorDTO>(apiErrorDTO, new HttpHeaders(), apiErrorDTO.getStatus());
	}
}
