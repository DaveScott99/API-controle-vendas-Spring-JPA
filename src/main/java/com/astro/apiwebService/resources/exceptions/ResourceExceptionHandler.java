package com.astro.apiwebService.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.astro.apiwebService.services.exceptions.DatabaseException;
import com.astro.apiwebService.services.exceptions.ResourceNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request){

 		// Mensagem de erro que será exibido ao usuário.
		String error = "Resource not found";

		// Status HTTP que será exibido ao usuário.
		HttpStatus status = HttpStatus.NOT_FOUND; 

		// Montagem da exceção que será exibibida ao usuário.
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI()); 

		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(DatabaseException.class)
	public ResponseEntity<StandardError> database(DatabaseException e, HttpServletRequest request){

		// Mensagem de erro que será exibido ao usuário.
		String error = "Database error";

		// Status HTTP que será exibido ao usuário.
		HttpStatus status = HttpStatus.BAD_REQUEST;

		// Montagem da exceção que será exibibida ao usuário.
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());

		return ResponseEntity.status(status).body(err);
	}

}
