package com.example.demo.exceptionhandling;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

@ControllerAdvice
public class CalculatorExceptionHandler {

	@ExceptionHandler(UnsupportedOperationException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ResponseEntity<ExceptionResponse> handleUnsupportedOperationException(final UnsupportedOperationException ex,
			final WebRequest request) {

		ExceptionResponse error = new ExceptionResponse(HttpStatus.BAD_REQUEST.value(), new Date(), ex.getMessage(),
				request.getDescription(false));

		return new ResponseEntity<ExceptionResponse>(error, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(NullPointerException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ResponseEntity<ExceptionResponse> handleNullPointerException(final NullPointerException ex,
			final WebRequest request) {

		ExceptionResponse error = new ExceptionResponse(HttpStatus.BAD_REQUEST.value(), new Date(), ex.getMessage(),
				request.getDescription(false));

		return new ResponseEntity<ExceptionResponse>(error, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ArithmeticException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ResponseEntity<ExceptionResponse> handleArithmeticException(final ArithmeticException ex,
			final WebRequest request) {

		ExceptionResponse error = new ExceptionResponse(HttpStatus.BAD_REQUEST.value(), new Date(), ex.getMessage(),
				request.getDescription(false));

		return new ResponseEntity<ExceptionResponse>(error, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(InvalidFormatException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ResponseEntity<ExceptionResponse> handleInvalidFormatException(final InvalidFormatException ex,
			final WebRequest request) {

		ExceptionResponse error = new ExceptionResponse(HttpStatus.BAD_REQUEST.value(), new Date(), ex.getMessage(),
				request.getDescription(false));

		return new ResponseEntity<ExceptionResponse>(error, HttpStatus.BAD_REQUEST);
	}
}
