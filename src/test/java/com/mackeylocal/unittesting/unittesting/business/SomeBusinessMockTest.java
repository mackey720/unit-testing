package com.mackeylocal.unittesting.unittesting.business;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mackeylocal.unittesting.unittesting.data.SomeDataService;


@ExtendWith(MockitoExtension.class)
class SomeBusinessMockTest {
	
	@InjectMocks
	SomeBusinessImpl business;
	
	@Mock
	SomeDataService dataServiceMock;

	@Test
	void calculateSum_basic() {	
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {1,2,3});
		assertEquals(6, business.calculateSumUsingDataService());
	}

	@Test
	void calculateSum_emptyArray() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {0});
		assertEquals(0, business.calculateSumUsingDataService());
	}
	
	@Test
	void calculateSum_oneValue() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {5});
		assertEquals(5, business.calculateSumUsingDataService());
	}
}
