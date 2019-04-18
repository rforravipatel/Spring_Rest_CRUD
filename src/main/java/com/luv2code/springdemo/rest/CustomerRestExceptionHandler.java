package com.luv2code.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerRestExceptionHandler {

	// Exception Handler for CustomerNotFoundException

	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleException(CustomerNotFoundException e) {

		// create CustomerErrorResponse

		CustomerErrorResponse errorResponse = new CustomerErrorResponse(HttpStatus.NOT_FOUND.value(), e.getMessage(),
				System.currentTimeMillis());

		// return ResponseEntity
		return new ResponseEntity<CustomerErrorResponse>(errorResponse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleException(Exception e) {

		// create CustomerErrorResponse

		CustomerErrorResponse errorResponse = new CustomerErrorResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage(),
				System.currentTimeMillis());

		// return ResponseEntity
		return new ResponseEntity<CustomerErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
	}
}
