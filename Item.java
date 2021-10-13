package com.arcadial.restaurant.model;

import java.text.DecimalFormat;

public abstract class Item extends AbstractModel {

	private static final long serialVersionUID = 1L;
	
	private String name;
	private String description;
	private float price;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " [" + this.name + ", " + this.description + ", $" + new DecimalFormat("0.00").format(price) + "]";
	}

}
