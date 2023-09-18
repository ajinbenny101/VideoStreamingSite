package com.fdmgroup.vodappapi.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.fdmgroup.vodappapi.exception.MatchExistsException;
import com.fdmgroup.vodappapi.exception.MatchNotFoundException;
import com.fdmgroup.vodappapi.exception.TeamExistsException;
import com.fdmgroup.vodappapi.exception.TeamNotFoundException;


@ControllerAdvice
public class VODExceptionHandler {
	
	@ExceptionHandler(value = TeamNotFoundException.class)
	public ResponseEntity<String> handleTeamNotFoundException(TeamNotFoundException e){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	}
	
	@ExceptionHandler(value = TeamExistsException.class)
	public ResponseEntity<String> handleTeamExistsException(TeamExistsException e){
		return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
	}
	
	@ExceptionHandler(value = MatchNotFoundException.class)
	public ResponseEntity<String> handleMatchNotFoundException(MatchNotFoundException e){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	}
	
	@ExceptionHandler(value = MatchExistsException.class)
	public ResponseEntity<String> handleMatchExistsException(MatchExistsException e){
		return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
	}
	
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<String> handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
		List<ObjectError> objectErrors = e.getAllErrors();
		StringBuilder errors = new StringBuilder();
		objectErrors.forEach(error -> errors.append(error.getDefaultMessage() + ", "));
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors.toString());
	}

}
