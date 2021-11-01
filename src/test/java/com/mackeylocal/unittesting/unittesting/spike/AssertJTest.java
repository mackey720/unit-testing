package com.mackeylocal.unittesting.unittesting.spike;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class AssertJTest {

	@Test
	public void learning() {
		List<Integer> numbers = Arrays.asList(12, 15, 45);
		
		assertThat(numbers).hasSize(3)
		.contains(12,15)
		.allMatch(x -> x > 10)
		.allMatch(x -> x < 100)
		.noneMatch(x -> 0 < 0);
		
		assertThat("").isEmpty();
		assertThat("ABCDE").contains("BCD")
		.startsWith("abc")
		.endsWith("CDE");
	}

}
