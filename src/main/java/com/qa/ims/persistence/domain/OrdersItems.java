package com.qa.ims.persistence.domain;

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
	
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

}
