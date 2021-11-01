package com.mackeylocal.unittesting.unittesting;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JSONAssertTest {
	
	String actualResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";
	
	@Test
	public void jsonAssert_StrictTrue_ExactMatchExceptSpaces() throws JSONException {
		String expectedResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";
		JSONAssert.assertEquals(expectedResponse,  actualResponse, true); //the exact structure should match
	}
	
	@Test
	public void jsonAssert_StrictFalse() throws JSONException {
		String expectedResponse = "{\"id\":1,\"name\":\"Ball\"}";
		JSONAssert.assertEquals(expectedResponse,  actualResponse, false); //the exact structure should match
	}
	
	@Test
	public void jsonAssert_StrictFalse_WithoutEscapeCharacters() throws JSONException {
		String expectedResponse = "{id:1,name:Ball,price:10,quantity:100}";
		JSONAssert.assertEquals(expectedResponse,  actualResponse, false); //the exact structure should match
	}


}
