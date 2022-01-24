package com.mahendra.restdemo1.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// Filter for all controllers
// Spring will BIND this handler to All rest-controllers
// It can be 2 controller (current scenario), or 100s of controllers
@ControllerAdvice
public class MyErrorHandler {

	/// Recommended : Use "User Defined Exception"
	@ExceptionHandler(value = RuntimeException.class)
	public ResponseEntity<String> handleError(RuntimeException ex){
		System.out.println("Exception caught: "+ ex.getMessage());
		return new ResponseEntity<String>("Error : "+ex.getMessage(), HttpStatus.BAD_REQUEST);
	}

	
}
