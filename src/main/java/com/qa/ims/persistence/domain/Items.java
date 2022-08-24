package com.qa.ims.persistence.domain;

import java.util.Objects;

public class Items {

		private Long id;
		private String itemName;
		private double price;
		
		public Items() {}
		
		public Items(String itemName, double price) {
			this.setItemName(itemName);
			this.setPrice(price);
		}

		public Items(Long id, String itemName, double price) {
			this.setId(id);
			this.setItemName(itemName);
			this.setPrice(price);
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

		public double getPrice() {
			return price;
		}

		public void setPrice(double price) {
			this.price = price;
		}

		@Override
		public String toString() {
			return "id: " + id + " item name: " + itemName + " price: " + price;
		}

		
	
	
	
}
