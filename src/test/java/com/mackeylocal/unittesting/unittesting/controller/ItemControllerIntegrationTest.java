package com.mackeylocal.unittesting.unittesting.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.mackeylocal.unittesting.unittesting.data.ItemRepository;


@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
class ItemControllerIntegrationTest {
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	//@MockBean
	//private ItemRepository respository;

	@Test
	public void contextLoads() throws JSONException {
		String response = this.restTemplate.getForObject("/all-items-from-database", String.class);
		
		JSONAssert.assertEquals("[{id:1001},{id:1002},{id:1003},{id:1004}]", response, false);
	}

}
