package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class OrdersTest {

	private Orders myOrders;
	
	@Before
	public void setUp() {
		myOrders = new Orders();
	}
	
	@Test
	public void noIdConstructorTest() {
		Orders orders = new Orders(3L);
		Long actual = orders.getCustomerId();
		Long expected = 3L;
		
		assertEquals(expected, actual);
		
	}
	
	@Test
	public void idConstructorTest() {
		Orders orders = new Orders(2L, 3L);
		Long actualId = orders.getOrderId();
		Long expectedId = 2L;
		Long actualCust = orders.getCustomerId();
		Long expectedCust = 3L;
		
		assertEquals(expectedId, actualId);
		assertEquals(expectedCust, actualCust);
	}
	
}
