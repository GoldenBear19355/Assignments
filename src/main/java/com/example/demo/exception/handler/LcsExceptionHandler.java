package com.example.demo.exception.handler;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.demo.error.LcsRequestValidationError;
import com.example.demo.error.LcsRequestValidationException;
import com.fasterxml.jackson.databind.JsonMappingException;

import lombok.extern.slf4j.Slf4j;


/**
 * @author Sudhakar
 *
 */
//@RestControllerAdvice
@Slf4j
public class LcsExceptionHandler extends ResponseEntityExceptionHandler {
	
	
	@ExceptionHandler({LcsRequestValidationException.class})	
	public static ResponseEntity<Object> handleLcsRequestValidationException(LcsRequestValidationException ex){
		return new ResponseEntity<>(ex.getErrors().get(0),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler({ IllegalArgumentException.class, ConstraintViolationException.class })
	public static ResponseEntity<Object> handleVoilationException(RuntimeException ex) {
		return new ResponseEntity<>(LcsRequestValidationError.of("2000", ex.getMessage()), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value= Exception.class)
	public ResponseEntity<Object> handleUnknownException(Exception ex){
		return new ResponseEntity<>(LcsRequestValidationError.of("5000", ex.getMessage()), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value= JsonMappingException.class)
	public ResponseEntity<Object> handleParsingException(IOException ex){
		return new ResponseEntity<>(LcsRequestValidationError.of("4000", ex.getMessage()), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value= InputMismatchException.class)
	public ResponseEntity<Object> handleInputMismtachException(Exception ex){
		return new ResponseEntity<>(LcsRequestValidationError.of("6000", ex.getMessage()), HttpStatus.BAD_REQUEST);
	}
	
	@Override
	public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
			HttpStatus status, WebRequest webrequest) {
		List<String> errorMessages = ex.getBindingResult().getAllErrors().stream()
				.map(error -> String.format("%s:%s", ((FieldError) error).getField(), error.getDefaultMessage()))
				.collect(Collectors.toList());
		List<LcsRequestValidationError> errors = errorMessages.stream()
				.map(message -> LcsRequestValidationError.of("3000", message)).collect(Collectors.toList());
		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	}

}
