package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;
import org.junit.Test;


public class ItemTest {
	
	@Test
	public void testCreateSetId() {
		Item created = new Item("Potato", 1F, 50L);
		created.setId(3L);
		long actual = created.getId();
		assertEquals(3 , actual);
	}
	
	@Test
	public void testCreateSetItemName() {
		Item created = new Item("Potato", 1F, 50L);
		created.setItemName("Carrot");
		String actual = created.getItemName();
		assertEquals("Carrot" , actual);
	}
	
	@Test
	public void testCreateSetPrice() {
		Item created = new Item("Potato", 1F, 50L);
		created.setPrice(2F);
		float actual = created.getPrice();
		assertEquals(2F , actual, 0.1F);
	}
	
	@Test
	public void testCreateStockLevel() {
		Item created = new Item("Potato", 1F, 50L);
		created.setStockLevel(100L);
		long actual = created.getStockLevel();
		assertEquals(100L , actual);
	}

}
