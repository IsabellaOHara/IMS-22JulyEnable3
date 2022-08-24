package com.qa.ims.persistence.domain;

public class Orders {

	private Long orderId;
	private Long customerId;
	
	public Orders() {}
	
	public Orders(Long customerId) {
		super();
		this.setCustomerId(customerId);
	}

	public Orders(Long orderId, Long customerId) {
		super();
		this.setOrderId(orderId);
		this.setCustomerId(customerId);
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long id) {
		this.orderId = id;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	@Override
	public String toString() {
		return "id: " + orderId + " customer ID: " + customerId;
	}	
	
}
