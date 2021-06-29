package com.example.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.bo.LcsRequest;
import com.example.demo.bo.LcsResponse;
import com.example.demo.endpoint.LcsEndpoint;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Sudhakar
 *
 */
@SpringBootTest
public class Demo1ApplicationTests {

	// Functional test scenarios
	private static final String TEST_CASE1_SINGLE_LCS = "/case1.json";
	private static final String TEST_CASE2_MULTIPLE_LCS = "/case2.json";
	private static final String TEST_CASE3_MULTIPLE_CASE_SENSITIVE_LCS = "/case3.json";
	private static final String TEST_CASE4_NO_LCS = "/case4.json";

	@Autowired
	public LcsEndpoint endpoint;

	@Test
	public void contextLoads() {
		assertNotNull("Context load failed...",endpoint);
	}

	@Test
	public void testFindLcs_case1() throws IOException {

		ObjectMapper mapper = new ObjectMapper();
		LcsRequest request = mapper.readValue(IOUtils.resourceToURL(TEST_CASE1_SINGLE_LCS), LcsRequest.class);
		LcsResponse response = endpoint.computeLcs(request);
		assertNotNull(response);
		assertNotNull(response.getLcs());
		assertEquals(1, response.getLcs().size());
		assertEquals("comcast", response.getLcs().get(0).getValue());

	}

	@Test
	public void testFindLcs_case2() throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		LcsRequest request = mapper.readValue(IOUtils.resourceToURL(TEST_CASE2_MULTIPLE_LCS), LcsRequest.class);

		LcsResponse response = endpoint.computeLcs(request);
		assertNotNull(response);
		assertNotNull(response.getLcs());
		assertEquals(2,response.getLcs().size());
		assertEquals("cast",response.getLcs().get(0).getValue());
		assertEquals("hell",response.getLcs().get(1).getValue());

	}

	@Test
	public void testFindLcs_case3() throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		LcsRequest request = mapper.readValue(IOUtils.resourceToURL(TEST_CASE3_MULTIPLE_CASE_SENSITIVE_LCS), LcsRequest.class);

		LcsResponse response = endpoint.computeLcs(request);
		assertNotNull(response);
		assertNotNull(response.getLcs());
		assertEquals(1,response.getLcs().size());
		assertEquals("Co",response.getLcs().get(0).getValue());
	}

	@Test
	public void testFindLcs_case4() throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		LcsRequest request = mapper.readValue(IOUtils.resourceToURL(TEST_CASE4_NO_LCS), LcsRequest.class);
		LcsResponse response = endpoint.computeLcs(request);
		assertNotNull(response);
		assertNotNull(response.getLcs());
		assertEquals(0, response.getLcs().size());
	}

}
