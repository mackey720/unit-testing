package com.mackeylocal.unittesting.unittesting.business;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.mackeylocal.unittesting.unittesting.data.ItemRepository;
import com.mackeylocal.unittesting.unittesting.model.Item;

@ExtendWith(SpringExtension.class)
class ItemBusinessServiceTest {
	
	@InjectMocks
	private ItemBusinessService business;
	
	
	@Mock
	ItemRepository repository;
	

	@Test
	public void calculateSumUsingDataService_basic() {
		when(repository.findAll()).thenReturn(Arrays.asList(new Item(2, "Item2", 10,10), new Item(3, "Item3", 20,20))
				);
		
		List<Item>  businessItems = business.retrieveAllItems();
		
		assertEquals(100, businessItems.get(0).getValue());
		assertEquals(400, businessItems.get(1).getValue());
	}

}
