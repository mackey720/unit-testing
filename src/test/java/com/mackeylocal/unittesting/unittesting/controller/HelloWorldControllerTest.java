package com.mackeylocal.unittesting.unittesting.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;


@ExtendWith(SpringExtension.class)
@WebMvcTest(HelloWorldController.class)
public class HelloWorldControllerTest {
	
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void helloWorld_basic() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.get("/hello-world")
				.accept(MediaType.APPLICATION_JSON);
		mockMvc.perform(request);
		
		//MvcResult result = 
		mockMvc.perform(request)
		.andExpect(status().isOk())
		.andExpect(content().string("Hello World"))
		.andReturn();
		
		//assertEquals("Hello World", result.getResponse().getContentAsString()); NOT NEEDED WHEN RESPONSE IS AS SIMPLE ABOVE
	}
}
