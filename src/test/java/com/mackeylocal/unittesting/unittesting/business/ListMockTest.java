package com.mackeylocal.unittesting.unittesting.business;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

public class ListMockTest {

	List mock = mock(List.class); 
	
	@Test
	void size_basic() {
		when(mock.size()).thenReturn(5);
		assertEquals(5, mock.size());
	}
	
	@Test
	public void returnDifferentValues() {	
		when(mock.size()).thenReturn(5).thenReturn(10);
		assertEquals(5, mock.size());	
		assertEquals(10, mock.size());	
	}
	
	@Test
	public void returnWithParameters() {	
		when(mock.get(0)).thenReturn("mackeylocal");
		assertEquals("mackeylocal", mock.get(0));	
		assertEquals(null, mock.get(1));	
	}
		
	@Test
	public void returnWithGenericParameters() {	                    
		when(mock.get(anyInt())).thenReturn("mackeylocal");
		assertEquals("mackeylocal", mock.get(0));	
		assertEquals("mackeylocal", mock.get(1));	
	}
	
	@Test
	public void verificationBasics() {
		Object value =  mock.get(0);
		Object value2 = mock.get(1);
		
		verify(mock).get(0);
		verify(mock, times(2)).get(anyInt());
		//verify(mock).get(anyInt());
		verify(mock, atLeastOnce()).get(anyInt());
		verify(mock, atLeast(1)).get(anyInt());
		verify(mock, atMost(2)).get(anyInt());
		verify(mock,  never()).get(2);
	}
	
	@Test public void argumentCapturing() {
		mock.add("SomeString");
		mock.add("SomeString2");
		
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		verify(mock, times(2)).add(captor.capture());
		
		List<String> allValues = captor.getAllValues();
		
		assertEquals("SomeString", allValues.get(0));
		assertEquals("SomeString", allValues.get(1));
	}
	
	@Test
	public void spying() {
		ArrayList arrayListMock = mock(ArrayList.class);
		 
	}
}
