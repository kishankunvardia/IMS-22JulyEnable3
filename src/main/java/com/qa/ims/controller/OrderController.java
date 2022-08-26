package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.CustomerDAO;
import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.persistence.domain.OrderItem;
import com.qa.ims.utils.Utils;

public class OrderController implements CrudController<Order>{
	
public static final Logger LOGGER = LogManager.getLogger();
	
	private OrderDAO orderDAO;
	private Utils utils;
	
	public OrderController(OrderDAO orderDAO, Utils utils) {
		super();
		this.orderDAO = orderDAO;
		this.utils = utils;
	}

	@Override
	public List<Order> readAll() {
		List<Order> orders = orderDAO.readAll();
		return null;
	}

	@Override
	public Order create() {
		LOGGER.info("Please enter a customer id for the order");
		long customerID = utils.getLong();
		LOGGER.info("Please enter the item id of the item you would like to order");
		long itemID = utils.getLong();
		float total = 0;
		Order order = orderDAO.create(new Order(customerID, total));
		OrderItem orderItem = orderDAO.addItem(new OrderItem(order.getId(), itemID));
		LOGGER.info("Order created");
		LOGGER.info("Would you like to add another item, yes or no?");
		String add = utils.getString();
		while (add.equals("yes")) {
			LOGGER.info("Please enter the item id of the item you would like to order");
			long itemIDAdd = utils.getLong();
			OrderItem orderItemAdd = orderDAO.addItem(new OrderItem(order.getId(), itemIDAdd));
			LOGGER.info("Would you like to add another item, yes or no?");
			add = utils.getString();
		}

		return order;
	}

	@Override
	public Order update() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete() {
		LOGGER.info("Please enter the order id of the order to delete");
		Long id = utils.getLong();
		return orderDAO.delete(id);
	}

}
