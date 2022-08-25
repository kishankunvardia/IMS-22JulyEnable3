package com.qa.ims.persistence.domain;

import java.util.Objects;

public class Order {
	
	private Long id;
	private Long customerID;
	private float total;
	
	public Order(Long customerID, float total) {
		this.customerID = customerID;
		this.total = total;
	}
	
	public Order(Long id, Long customerID, float total) {
		this.id = id;
		this.customerID = customerID;
		this.total = total;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCustomerID() {
		return customerID;
	}

	public void setCustomerID(Long customerID) {
		this.customerID = customerID;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", customerID=" + customerID + ", total=" + total + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(customerID, id, total);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(customerID, other.customerID) && Objects.equals(id, other.id)
				&& Float.floatToIntBits(total) == Float.floatToIntBits(other.total);
	}
	
	

}
