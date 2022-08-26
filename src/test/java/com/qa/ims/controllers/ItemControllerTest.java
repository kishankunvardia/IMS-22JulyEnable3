package com.qa.ims.controllers;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.controller.ItemController;
import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.Utils;

@RunWith(MockitoJUnitRunner.class)
public class ItemControllerTest {
	
	@Mock
	private Utils utils;

	@Mock
	private ItemDAO dao;

	@InjectMocks
	private ItemController controller;
	
//	@Test
//	public void testCreate() {
//		final String I_NAME = "speaker";
//		final float PRICE = 15.50F ;
//		final long S_LEVEL = 10 ;
//		final Item created = new Item(I_NAME, PRICE, S_LEVEL);
//		
//		Mockito.when(utils.getString()).thenReturn(I_NAME);
//		Mockito.when(utils.getFloat()).thenReturn(PRICE);
//		Mockito.when(utils.getLong()).thenReturn(S_LEVEL);
//		Mockito.when(dao.create(created)).thenReturn(created);
//
//		assertEquals(created, controller.create());
//
//		Mockito.verify(utils, Mockito.times(1)).getString();
//		Mockito.verify(utils, Mockito.times(1)).getFloat();
//		Mockito.verify(utils, Mockito.times(1)).getLong();
//		Mockito.verify(dao, Mockito.times(1)).create(created);
//	}
	
	@Test
	public void testReadAll() {
		List<Item> items = new ArrayList<>();
		items.add(new Item(1L, "table", 20F, 10L));

		Mockito.when(dao.readAll()).thenReturn(items);

		assertEquals(items, controller.readAll());

		Mockito.verify(dao, Mockito.times(1)).readAll();
	}
//	
//	@Test
//	public void testUpdate() {
//		Item updated = new Item(1L, "pencil", 2F, 100L);
//
//		Mockito.when(this.utils.getLong()).thenReturn(1L);
//		Mockito.when(this.utils.getString()).thenReturn(updated.getItemName());
//		Mockito.when(this.utils.getFloat()).thenReturn(updated.getPrice());
//		Mockito.when(this.utils.getLong()).thenReturn(updated.getStockLevel());
//		Mockito.when(this.dao.update(updated)).thenReturn(updated);
//
//		assertEquals(updated, this.controller.update());
//
//		Mockito.verify(this.utils, Mockito.times(1)).getLong();
//		Mockito.verify(this.utils, Mockito.times(1)).getString();
//		Mockito.verify(this.utils, Mockito.times(1)).getFloat();
//		Mockito.verify(this.utils, Mockito.times(1)).getLong();
//		Mockito.verify(this.dao, Mockito.times(1)).update(updated);
//	}
	
	@Test
	public void testDelete() {
		final long ID = 1L;

		Mockito.when(utils.getLong()).thenReturn(ID);
		Mockito.when(dao.delete(ID)).thenReturn(1);

		assertEquals(1L, this.controller.delete());

		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(dao, Mockito.times(1)).delete(ID);
	}

}
