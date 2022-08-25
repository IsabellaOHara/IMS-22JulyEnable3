package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.Items;
import com.qa.ims.utils.DBUtils;

public class ItemsDAOTest {

	private final ItemsDAO DAO = new ItemsDAO();
	
	@Before
	public void setup() {
		DBUtils.connect();
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}

	@Test 
	public void testCreate() {
		final Items newItem = new Items(2L, "hoodie", 50.00);
		assertEquals(newItem, DAO.create(newItem));
	}
	
	@Test
	public void testReadAll() {
		List<Items> expected = new ArrayList<>();
		expected.add(new Items(1L, "green sweatshirt", 35.50));
		assertEquals(expected, DAO.readAll());
	}
	
	@Test
	public void testRead() {
		final long id = 1L;
		assertEquals(new Items(id, "green sweatshirt", 35.50), DAO.read(id));
		
	}
	
	@Test
	public void testUpdate() {
		final Items updated = new Items(1L, "jumper", 45.00);
		assertEquals(updated, DAO.update(updated));
	}
	
	@Test
	public void testDelete() {
		assertEquals(1, DAO.delete(1));
	}
}
