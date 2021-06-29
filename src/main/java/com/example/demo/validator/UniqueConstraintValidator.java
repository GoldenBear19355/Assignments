package com.example.demo.validator;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.demo.error.LcsRequestValidationError;
import com.example.demo.error.LcsRequestValidationException;

/**
 * @author Sudhakar
 *
 */
@Component
public class UniqueConstraintValidator implements BaseValidator {

	@Override
	public void validateAndThrow(List<String> strings) {
		Set<String> setOfStrings = strings.stream().collect(Collectors.toSet());
		/*
		 * If the setOfStrings supplied is not a set (i.e. all strings are not
		 * unique) the server should respond with an appropriate HTTP status
		 * code, and a response body explaining that "setOfStrings" must be a
		 * Set
		 */
		if (setOfStrings.size() != strings.size()) {
			throw new LcsRequestValidationException(
					new LcsRequestValidationError("1000", "setOfStrings must be a Set/Unique"));
		}
	}

}
