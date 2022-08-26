package com.qa.ims.persistence.domain;

import java.util.Objects;

public class OrdersItems {

	
	private Long quantity;
	private Long id;
	private Long itemId;
	private double totalPrice;
	
	Items items = new Items();

	public OrdersItems(Long id, Long itemId, Long quantity) {
		super();
		this.setId(id);
		this.setItemId(itemId);
		this.setQuantity(quantity);
	}

	public OrdersItems(Long id, double totalPrice) {
		this.setId(id);
		this.setTotalPrice(totalPrice); 
	}
	
	public OrdersItems() {
		
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, itemId, quantity);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrdersItems other = (OrdersItems) obj;
		return Objects.equals(id, other.id) && Objects.equals(itemId, other.itemId)
				&& Objects.equals(quantity, other.quantity);
	}
	
	
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

}
