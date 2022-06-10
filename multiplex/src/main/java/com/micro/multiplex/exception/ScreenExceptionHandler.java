package com.micro.multiplex.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ScreenExceptionHandler extends ResponseEntityExceptionHandler {
	
	       @ExceptionHandler(ScreenLimitExtendedException.class)
	       public ResponseEntity<Object> getScreenException(ScreenLimitExtendedException screenLimitExtendedException) {

	       JsonResponse errorResponse = new JsonResponse(screenLimitExtendedException.getMessage(),
	                                                   HttpStatus.NOT_MODIFIED.toString());

	         return new ResponseEntity<Object>(errorResponse, HttpStatus.NOT_MODIFIED);

	      }
	}

