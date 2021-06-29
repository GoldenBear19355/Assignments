package com.example.demo.error;

import java.io.Serializable;

import com.example.demo.bo.LcsResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Sudhakar
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LcsError extends LcsResponse implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 3414162549460457350L;

	private String errorCode;

	private String errorMessage;
	
	public static LcsError of(String errorCode, String errorMessage) {
		return new LcsError(errorCode, errorMessage);
	}

	@Override
	public String toString() {
		return "LcsError {"
				+ "errorCode=" + errorCode 
				+ ", errorMessage=" + errorMessage 
				+ "}";
	}



}
