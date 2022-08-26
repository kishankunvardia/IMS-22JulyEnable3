package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class OrderItemTest {
	
	@Test
	public void testCreateSetId() {
		OrderItem created = new OrderItem(1L, 2L);
		created.setId(3L);
		long actual = created.getId();
		assertEquals(3 , actual);
	}
	
	@Test
	public void testCreateOrderId() {
		OrderItem created = new OrderItem(1L, 1L, 2L);
		created.setOrderID(3L);
		long actual = created.getOrderID();
		assertEquals(3 , actual);
	}
	
	@Test
	public void testCreateItemId() {
		OrderItem created = new OrderItem(1L, 1L, 2L);
		created.setItemID(3L);
		long actual = created.getItemID();
		assertEquals(3 , actual);
	}

}
