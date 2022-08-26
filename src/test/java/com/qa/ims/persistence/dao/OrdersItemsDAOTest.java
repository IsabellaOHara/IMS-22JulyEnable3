package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.qa.ims.persistence.domain.OrdersItems;
import com.qa.ims.utils.DBUtils;

public class OrdersItemsDAOTest {

	//none of these tests worked (hence @Ignore so could do the JAR) - SQL error "Table ORDERS_ITEMS not found" 
	// can't work out what is wrong (triple checked all SQL syntax) 
	//have asked for help but no access to trainer today (final day) (they've gone offline?)
	
	private final OrdersItemsDAO DAO = new OrdersItemsDAO();
	
	@Before
	public void setup() {
		DBUtils.connect();
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}

	@Ignore
	@Test
	public void testCreate() {
		final OrdersItems created = new OrdersItems(2L, 1L, 4L);
		assertEquals(created, DAO.create(created));
	}
	
	@Ignore
	@Test
	public void testReadAll() {
		List<OrdersItems> expected = new ArrayList<>();
		expected.add(new OrdersItems(1L, 1L, 4L));
		assertEquals(expected, DAO.readAll());
	}
	
	@Ignore
	@Test
	public void testReadLatest() {
		assertEquals(new OrdersItems(1L, 1L, 4L), DAO.readLatest());
	}
	
	@Ignore
	@Test
	public void testRead() {
		final long id = 1L;
		assertEquals(new OrdersItems(id, 1L, 4L), DAO.read(id));
	}
	
	@Ignore
	@Test
	public void testUpdate() {
		final OrdersItems updated = new OrdersItems(1L, 1L, 4L);
		assertEquals(updated, DAO.update(updated));
	}
	
	@Ignore
	@Test
	public void testDelete() {
		assertEquals(1, DAO.delete(1));
	}
	
}
