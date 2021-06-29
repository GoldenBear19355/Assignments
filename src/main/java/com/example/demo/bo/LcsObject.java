package com.example.demo.bo;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Sudhakar
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LcsObject implements Comparable<LcsObject>{
	
	@NotBlank(message="value must not be empty or null")
	private String value;

	@Override
	public int compareTo(LcsObject o) {
		return this.value.compareTo(o.getValue());
	}
}
