package com.example.demo;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.Charset;

import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.endpoint.LcsEndpoint;
import com.example.demo.service.LcsService;
import com.example.demo.validator.BaseValidator;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers={LcsEndpoint.class})
public class Demo1Application1Test {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	LcsService lcsService;
	
	@MockBean
	BaseValidator validator;

	// Validation test scenarios
	private static final String TEST_CASE5_BAD_REQUEST_EMPTY_VALUE = "/case5.json";
	private static final String TEST_CASE6_BAD_REQUEST_EMPTY_SET_OF_STRINGS = "/case6.json";
	private static final String TEST_CASE7_BAD_REQUEST_DUPLICATE_STRINGS = "/case7.json";
	private static final String TEST_CASE8_BAD_REQUEST_FAULTY_FORMAT = "/case8.json";
	private static final String TEST_CASE9_BAD_REQUEST_EMPTY_BODY = "/case9.json";

	@Test
	public void test_findLcs_validation() throws Exception {
		assertNotNull(mockMvc);
		assertNotNull(lcsService);
		String json = IOUtils.resourceToString(TEST_CASE5_BAD_REQUEST_EMPTY_VALUE, Charset.defaultCharset());
		mockMvc.perform(post("/lcs").contentType(MediaType.APPLICATION_JSON_VALUE).content(json))
				.andExpect(status().isBadRequest());
	}

	@Test
	public void test_findLcs_validation2() throws Exception {
		assertNotNull(mockMvc);
		assertNotNull(lcsService);
		String json = IOUtils.resourceToString(TEST_CASE6_BAD_REQUEST_EMPTY_SET_OF_STRINGS, Charset.defaultCharset());
		mockMvc.perform(post("/lcs").contentType(MediaType.APPLICATION_JSON_VALUE).content(json))
				.andExpect(status().isBadRequest());
	}

	@Test
	public void test_findLcs_validation3() throws Exception {
		assertNotNull(mockMvc);
		assertNotNull(lcsService);
		String json = IOUtils.resourceToString(TEST_CASE7_BAD_REQUEST_DUPLICATE_STRINGS, Charset.defaultCharset());
		mockMvc.perform(post("/lcs").contentType(MediaType.APPLICATION_JSON_VALUE).content(json))
				.andExpect(status().isBadRequest());
	}
	
	@Test
	public void test_findLcs_validation4() throws Exception {
		assertNotNull(mockMvc);
		assertNotNull(lcsService);
		String json = IOUtils.resourceToString(TEST_CASE8_BAD_REQUEST_FAULTY_FORMAT, Charset.defaultCharset());
		mockMvc.perform(post("/lcs").contentType(MediaType.APPLICATION_JSON_VALUE).content(json))
				.andExpect(status().isBadRequest());
	}
	
	
	@Test
	public void test_findLcs_validation5() throws Exception {
		assertNotNull(mockMvc);
		assertNotNull(lcsService);
		String json = IOUtils.resourceToString(TEST_CASE9_BAD_REQUEST_EMPTY_BODY, Charset.defaultCharset());
		mockMvc.perform(post("/lcs").contentType(MediaType.APPLICATION_JSON_VALUE).content(json))
				.andExpect(status().isBadRequest());
	}


}
