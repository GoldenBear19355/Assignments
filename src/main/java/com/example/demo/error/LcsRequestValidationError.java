package com.example.demo.error;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LcsRequestValidationError implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3414162549460457350L;

	private String errorCode;

	private String errorMessage;
	
	public static LcsRequestValidationError of(String errorCode, String errorMessage) {
		return new LcsRequestValidationError(errorCode, errorMessage);
	}

	@Override
	public String toString() {
		return "LcsRequestValidationError {"
				+ "errorCode=" + errorCode 
				+ ", errorMessage=" + errorMessage 
				+ "}";
	}

}
