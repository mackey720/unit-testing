package com.mackeylocal.unittesting.unittesting.business;

import java.util.Arrays;

import com.mackeylocal.unittesting.unittesting.data.SomeDataService;

public class SomeBusinessImpl {
	
	private SomeDataService someDataService;

	public SomeDataService getSomeDataService() {
		return someDataService;
	}

	public void setSomeDataService(SomeDataService someDataService) {
		this.someDataService = someDataService;
	}

	public int calculateSum(int[] data) {
		
		return Arrays.stream(data).reduce(Integer::sum).orElse(0);
		
		/* SAME AS ABOVE
		int sum = 0;
		for (int value:data) {
			sum += value;
		}
		return sum;*/
	}
	
	public int calculateSumUsingDataService() {
		int[] data = someDataService.retrieveAllData();
		
		return Arrays.stream(data).reduce(Integer::sum).orElse(0);
	}
}
