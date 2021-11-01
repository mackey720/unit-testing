package com.mackeylocal.unittesting.unittesting.data;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.mackeylocal.unittesting.unittesting.model.Item;


@DataJpaTest
@ExtendWith(SpringExtension.class)
class ItemRespositoryTest {
	
	@Autowired
	private ItemRepository repository;

	@Test
	public void testFindAll() {
		List<Item> items = repository.findAll();
		
		assertEquals(4, items.size());
	}
	
	@Test
	public void testFindItem() {
		List<Item> items = repository.findAll();
		
		assertEquals(18, items.get(1).getQuantity());
	}

}
