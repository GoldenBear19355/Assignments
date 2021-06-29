package com.example.demo.bo;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
public class LcsRequest {

	@Valid
	@NotNull(message = "setOfStrings must not be null")
	@Size(min = 2, message = "setOfStrings size must be 2 minimum")
	private List<LcsObject> setOfStrings;

}
