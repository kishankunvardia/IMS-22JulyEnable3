package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.DBUtils;

public class ItemDAOTest {
	
	private final ItemDAO DAO = new ItemDAO();
	
	@Before
	public void setup() {
		DBUtils.connect();
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}
	
	@Test
	public void testCreate() {
		final Item created = new Item(2L, "Potato", 1F, 50L);
		System.out.println(created.getPrice());
		assertEquals("\n" + created+"\n", "\n" + DAO.create(created)+"\n");
	}
	
	@Test
	public void testCreateFail() {
		final Item created = new Item(2L, "Potato", 1F, 5000000000000000000L);
		System.out.println(created.getPrice());
		assertEquals(null, DAO.create(created));
	}
	
	@Test
	public void testReadAll() {
		List<Item> expected = new ArrayList<>();
		expected.add(new Item(1L, "calendar", 15F, 200L));
		assertEquals("\n" + expected+"\n",  "\n" + DAO.readAll()+"\n");
	}
	
	@Test
	public void testReadLatest() {
		assertEquals("\n"+new Item(1L, "calendar", 15F, 200L)+"\n", "\n"+DAO.readLatestItem()+ "\n");
	}
	
	@Test
	public void testRead() {
		final long ID = 1L;
		assertEquals("\n"+new Item(ID, "calendar", 15F, 200L)+"\n", "\n"+DAO.read(ID)+ "\n");
	}
	
	@Test
	public void testUpdate() {
		final Item updated = new Item(1L, "pen", 2F, 1000L);
		assertEquals("\n"+updated+"\n","\n"+ DAO.update(updated)+"\n");

	}
	
	@Test
	public void testUpdateFail() {
		final Item updated = new Item(1L, "pen", 2F, 10000000000000000L);
		assertEquals(null, DAO.update(updated));

	}
	
	@Test
	public void testDelete() {
		assertEquals(1, DAO.delete(1));
	}
	
	@Test
	public void testDeleteFail() {
		assertEquals(0, DAO.delete(10000000000000000L));
	}
	
	
	
}
