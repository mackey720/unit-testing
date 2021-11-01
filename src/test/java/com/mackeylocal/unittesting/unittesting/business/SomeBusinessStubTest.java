package com.mackeylocal.unittesting.unittesting.business;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.mackeylocal.unittesting.unittesting.data.SomeDataService;


class SomeDataServiceStub implements SomeDataService {
	
	@Override
	public int[] retrieveAllData() {
		return new int[] {1,2,3};
	}
}

class SomeDataServiceEmptyStub implements SomeDataService {
	
	@Override
	public int[] retrieveAllData() {
		return new int[] {};
	}
}

class SomeDataServiceOneElementStub implements SomeDataService {
	
	@Override
	public int[] retrieveAllData() {
		return new int[] {5};
	}
}

class SomeBusinessStubTest {

	@Test
	void calculateSumUsingDataService_basic() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		business.setSomeDataService(new SomeDataServiceStub());
		int actualResult = business.calculateSumUsingDataService();
		int expectedResult = 6;
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	void calculateSumUsingDataService_emptyArray() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		business.setSomeDataService(new SomeDataServiceEmptyStub());
		int actualResult = business.calculateSumUsingDataService();
		int expectedResult = 0;
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	void calculateSumUsingDataService_oneValue() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		business.setSomeDataService(new SomeDataServiceOneElementStub());
		int actualResult = business.calculateSumUsingDataService();
		int expectedResult = 5;
		assertEquals(expectedResult, actualResult);
	}

}
