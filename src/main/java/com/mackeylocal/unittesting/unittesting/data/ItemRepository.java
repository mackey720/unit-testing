package com.mackeylocal.unittesting.unittesting.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mackeylocal.unittesting.unittesting.model.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {

}
