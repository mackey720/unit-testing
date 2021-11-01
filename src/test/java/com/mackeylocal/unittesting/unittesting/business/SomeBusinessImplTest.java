package com.mackeylocal.unittesting.unittesting.business;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SomeBusinessImplTest {

	@Test
	void calculateSum_basic() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		int actualResult = business.calculateSum( new int[] {1,2,3});
		int expectedResult = 6;
		assertEquals(expectedResult, actualResult);
	}

	@Test
	void calculateSum_emptyArray() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		int actualResult = business.calculateSum( new int[] {});
		int expectedResult = 0;
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	void calculateSum_oneValue() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		int actualResult = business.calculateSum( new int[] {5});
		int expectedResult = 5;
		assertEquals(expectedResult, actualResult);
	}
}
