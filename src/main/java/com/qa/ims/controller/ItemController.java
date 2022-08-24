package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.CustomerDAO;
import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.Utils;

public class ItemController implements CrudController<Item>{
	
	public static final Logger LOGGER = LogManager.getLogger();
	
	private ItemDAO itemDAO;
	private Utils utils;
	
	public ItemController(ItemDAO itemDAO, Utils utils) {
		super();
		this.itemDAO = itemDAO;
		this.utils = utils;
	}

	@Override
	public List<Item> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Item create() {
		LOGGER.info("Please enter item name");
		String itemName = utils.getString();
		LOGGER.info("Please enter a price");
		float price = utils.getFloat();
		LOGGER.info("Please enter stock level");
		long stockLevel = utils.getLong();
		Item item = itemDAO.create(new Item(itemName, price, stockLevel));
		LOGGER.info("Item created");
		return item;
	}

	@Override
	public Item update() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete() {
		// TODO Auto-generated method stub
		return 0;
	}

}
