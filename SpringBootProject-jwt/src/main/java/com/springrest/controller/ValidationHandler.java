package com.springrest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class ValidationHandler extends ResponseEntityExceptionHandler {

	public ResponseEntity<Object> handleException(String message){
		
		return new ResponseEntity<Object>(message,HttpStatus.BAD_REQUEST); 

		
	}

	
}
