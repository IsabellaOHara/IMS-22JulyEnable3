package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class OrdersItemsTest {

	@Test
	public void constructorTest() {
		OrdersItems oi = new OrdersItems(1L, 2L, 4L);
		
		Long actualId = oi.getId();
		Long expectedId = 1L;
		
		Long actualItem = oi.getItemId();
		Long expectedItem = 2L;
		
		Long actualQuant = oi.getQuantity();
		Long expectedQuant = 4L;
		
		assertEquals(expectedId, actualId);
		assertEquals(expectedItem, actualItem);
		assertEquals(expectedQuant, actualQuant);
		
	}
	
}
