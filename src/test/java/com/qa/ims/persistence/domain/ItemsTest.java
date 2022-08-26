package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class ItemsTest {

	
	private Items myItems;
	
	@Before
	public void setUp() {
		myItems = new Items();
	}
	
//	@Test
//	public void testEquals() {
//		EqualsVerifier.simple().forClass(Items.class).verify();
//	}
//	
	@Test
	public void noIdConstructorTest() {
		Items items = new Items("green sweatshirt", 35.50);
		String actualName = items.getItemName();
		String expectedName = "green sweatshirt";
		double actualPrice = items.getPrice();
		double expectedPrice = 35.50;
		
		assertEquals(expectedName, actualName);
		assertEquals(expectedPrice, actualPrice, 0.0f);
		
	}
	
	@Test
	public void idConstructorTest() {
		Items items = new Items(2L, "green sweatshirt", 35.50);
		Long actualId = items.getId();
		Long expectedId = 2L;
		String actualName = items.getItemName();
		String expectedName = "green sweatshirt";
		double actualPrice = items.getPrice();
		double expectedPrice = 35.50;
		
		assertEquals(expectedId, actualId);
		assertEquals(expectedName, actualName);
		assertEquals(expectedPrice, actualPrice, 0.0f);
	}
}
