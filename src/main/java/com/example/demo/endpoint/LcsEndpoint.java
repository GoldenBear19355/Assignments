package com.example.demo.endpoint;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bo.LcsObject;
import com.example.demo.bo.LcsRequest;
import com.example.demo.bo.LcsResponse;
import com.example.demo.service.LcsService;
import com.example.demo.validator.BaseValidator;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Sudhakar
 *
 */
@RestController
@RequestMapping(produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
@Validated
@Slf4j
public class LcsEndpoint {

	@Autowired
	public LcsService lcsService;
	
	@Autowired
	public BaseValidator validator;

	/**
	 * @param lcsRequest
	 * @return
	 */
	@PostMapping(path = "/lcs")
	public LcsResponse computeLcs(@Valid @RequestBody LcsRequest lcsRequest) {
		log.info("lcsRequest:{}", lcsRequest);
		LcsResponse lcsResponse;

		List<String> strings = lcsRequest.getSetOfStrings().stream().map(LcsObject::getValue)
				.collect(Collectors.toList());

		validator.validateAndThrow(strings);

		lcsResponse = lcsService.findLcs(strings);
		log.info("lcsRequest:{}", lcsResponse);
		return lcsResponse;

	}

}
