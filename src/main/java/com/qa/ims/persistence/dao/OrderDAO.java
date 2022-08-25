package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.persistence.domain.OrderItem;
import com.qa.ims.utils.DBUtils;

public class OrderDAO implements Dao<Order>{
	
	public static final Logger LOGGER = LogManager.getLogger();

	@Override
	public List<Order> readAll() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT o.id AS 'Order ID' , c.id AS 'Customer ID' , concat(c.first_name, ' ', c.surname) AS 'Name' , i.item_name, i.price\r\n"
						+ "FROM orderitem oi\r\n"
						+ "JOIN orders o ON o.id = oi.order_id\r\n"
						+ "JOIN items i ON i.id = oi.item_id\r\n"
						+ "JOIN customers c ON c.id = o.customer_id\r\n"
						+ "ORDER BY o.id;");) {
			
			while (resultSet.next()) {
				Long orderID = resultSet.getLong("Order ID");
				Long custID = resultSet.getLong("Customer ID");
				String name = resultSet.getString("Name");
				String itemName = resultSet.getString("item_name");
				float price = resultSet.getFloat("price");
				System.out.println("Order ID:" + orderID + " Customer ID:" + custID + " Name:" + name + " Item:" + itemName + " Price:" + price );
			}
			return null;
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}

	@Override
	public Order read(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Order readLatest() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orders ORDER BY id DESC LIMIT 1");) {
			resultSet.next();
			return modelFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	
	public OrderItem readLatestOrderItem() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orderitem ORDER BY id DESC LIMIT 1");) {
			resultSet.next();
			return modelFromResultSetOrderItem(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public Order create(Order order) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("INSERT INTO orders(customer_id, total) VALUES (?, 0);");) {
			statement.setLong(1, order.getCustomerID());
			statement.executeUpdate();
			return readLatest();
		}
		catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	
	public OrderItem addItem(OrderItem orderitem) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("INSERT INTO orderitem (order_id, item_id) VALUES (?, ?);");) {
			statement.setLong(1, orderitem.getOrderID());
			statement.setLong(2, orderitem.getItemID());
			statement.executeUpdate();
			return readLatestOrderItem();
		}
		catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public Order update(Order t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Order modelFromResultSet(ResultSet resultSet) throws SQLException {
		Long id = resultSet.getLong("id");
		Long customerID = resultSet.getLong("customer_id");
		float total = resultSet.getFloat("total");
		return new Order(id, customerID, total);
	}
	
	public OrderItem modelFromResultSetOrderItem(ResultSet resultSet) throws SQLException {
		Long id = resultSet.getLong("id");
		Long orderID = resultSet.getLong("order_id");
		Long itemID = resultSet.getLong("order_id");
		
		return new OrderItem(id, orderID, itemID);
	}

}
