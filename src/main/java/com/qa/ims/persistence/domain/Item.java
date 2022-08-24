package com.qa.ims.persistence.domain;

import java.util.Objects;

public class Item {
	
	private Long id;
	private String itemName;
	private float price;
	private Long stockLevel;
	
	public Item(String itemName, float price, Long stockLevel) {
		this.itemName = itemName;
		this.price = price;
		this.stockLevel = stockLevel;
	}
	
	public Item(Long id, String itemName, float price, Long stockLevel) {
		super();
		this.id = id;
		this.itemName = itemName;
		this.price = price;
		this.stockLevel = stockLevel;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Long getStockLevel() {
		return stockLevel;
	}

	public void setStockLevel(Long stockLevel) {
		this.stockLevel = stockLevel;
	}

	@Override
	public String toString() {
		return "ID:" + id + " | Item name:" + itemName + " | Price:" + price + " | Stock level:" + stockLevel;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, itemName, price, stockLevel);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		return Objects.equals(id, other.id) && Objects.equals(itemName, other.itemName)
				&& Float.floatToIntBits(price) == Float.floatToIntBits(other.price)
				&& Objects.equals(stockLevel, other.stockLevel);
	}
	
	
	
}