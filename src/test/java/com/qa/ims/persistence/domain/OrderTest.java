package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class OrderTest {
	
	@Test
	public void testCreateSetId() {
		Order created = new Order(1L, 0);
		created.setId(2L);
		long actual = created.getId();
		assertEquals(2 , actual);
	}
	
	@Test
	public void testCreateSetCustomerId() {
		Order created = new Order(1L, 1L, 0);
		created.setCustomerID(2L);
		long actual = created.getCustomerID();
		assertEquals(2 , actual);
	}
	
	@Test
	public void testCreateSetTotal() {
		Order created = new Order(1L, 1L, 0);
		created.setTotal(1F);
		float actual = created.getTotal();
		assertEquals(1 , actual, 0.1f);
	}

}
