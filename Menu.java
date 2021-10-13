package com.arcadial.restaurant.model;

import java.util.ArrayList;
import java.util.List;

public class Menu extends AbstractModel {
	
	private static final long serialVersionUID = 1L;
	
	private List<Item> items;
	
	public Menu() {
		this.items = new ArrayList<>();
	}
	
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	
}
