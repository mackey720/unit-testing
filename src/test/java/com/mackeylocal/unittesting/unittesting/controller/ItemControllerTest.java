package com.mackeylocal.unittesting.unittesting.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.hamcrest.Matchers.containsString;

import com.mackeylocal.unittesting.unittesting.business.ItemBusinessService;
import com.mackeylocal.unittesting.unittesting.model.Item;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ItemController.class)
class ItemControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ItemBusinessService businessService;

	@Test
	public void dummyItem_basic() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.get("/dummy-item")
				.accept(MediaType.APPLICATION_JSON);
		mockMvc.perform(request);
		
		//MvcResult result = 
		mockMvc.perform(request)
		.andExpect(status().isOk())
		.andExpect(content().json("{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}"))
		.andReturn();
		
		//assertEquals("Hello World", result.getResponse().getContentAsString()); NOT NEEDED WHEN RESPONSE IS AS SIMPLE ABOVE
	}
	
	@Test
	public void itemFromBusinessService_basic() throws Exception {
		
		when(businessService.retrieveHardcodedItem()).thenReturn(new Item(2, "Item2", 10,10));
		
		RequestBuilder request = MockMvcRequestBuilders.get("/item-from-business-service")
				.accept(MediaType.APPLICATION_JSON);
		mockMvc.perform(request);
		
		//MvcResult result = 
		mockMvc.perform(request)
		.andExpect(status().isOk())
		.andExpect(content().json("{id:2, name:Item2, price:10, quantity:10}"))
		.andReturn();
		
	}
	
	@Test
	public void itemFromDatabase_basic() throws Exception {
		
		when(businessService.retrieveAllItems()).thenReturn(
				Arrays.asList(new Item(2, "Item2", 10,10), new Item(3, "Item3", 20,20))
				);
		
		RequestBuilder request = MockMvcRequestBuilders.get("/all-items-from-database")
				.accept(MediaType.APPLICATION_JSON);
		mockMvc.perform(request);
		
		mockMvc.perform(request)
		.andExpect(status().isOk())
		.andExpect(content().json("[{id:2, name:Item2, price:10, quantity:10}, {id:3, name:Item3, price:20, quantity:20}]"))
		.andReturn();
		
		//JSONAssert.assertEquals(expected, actual, false); same as above
		
	}
	

	/*
	@Test
	public void itemFromDatabase_Post() throws Exception {
		
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/all-items-from-database")
				.accept(MediaType.APPLICATION_JSON)
				.content("{\"id\":1005,\"name\":\"item5\",\"price\":20,\"quantity\":10,\"value\":0}")
				.contentType(MediaType.APPLICATION_JSON);
		
		mockMvc.perform(requestBuilder)
				.andExpect(status().isCreated())
				.andExpect(header().string("location", containsString("/all-items-from-database")))
				.andReturn();
		
	}
	*/

}
