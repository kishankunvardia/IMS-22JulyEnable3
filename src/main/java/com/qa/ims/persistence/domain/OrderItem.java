package com.qa.ims.persistence.domain;

import java.util.Objects;

public class OrderItem {
	
	private long id;
	private long orderID;
	private long itemID;
	
	public OrderItem(long orderID, long itemID) {
		this.orderID = orderID;
		this.itemID = itemID;
	}
	
	public OrderItem(long id, long orderID, long itemID) {
		this.id = id;
		this.orderID = orderID;
		this.itemID = itemID;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getOrderID() {
		return orderID;
	}

	public void setOrderID(long orderID) {
		this.orderID = orderID;
	}

	public long getItemID() {
		return itemID;
	}

	public void setItemID(long itemID) {
		this.itemID = itemID;
	}

	@Override
	public String toString() {
		return "OrderItem [id=" + id + ", orderID=" + orderID + ", itemID=" + itemID + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, itemID, orderID);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItem other = (OrderItem) obj;
		return id == other.id && itemID == other.itemID && orderID == other.orderID;
	}
	
	
	
	

}
