package com.example.demo.error;

import java.util.Collections;
import java.util.List;

import lombok.Getter;

public class LcsRequestValidationException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8081031562706962449L;
	
	@Getter
	private List<LcsRequestValidationError> errors;

	public LcsRequestValidationException(List<LcsRequestValidationError> errors) {
		super();
		this.errors = errors;
	}

	public LcsRequestValidationException(LcsRequestValidationError error) {
		super();
		this.errors = Collections.singletonList(error);
	}
		
}
