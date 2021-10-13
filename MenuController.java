package com.arcadial.restaurant.controller;

import com.arcadial.restaurant.model.Item;
import com.arcadial.restaurant.model.Menu;

public class MenuController extends AbstractController<Menu> {

	private Menu menu;

	private static final String MENU_DIRECTORY = "E:\\Java Workspace\\For Fun\\src\\com\\arcadial\\restaurant\\io\\menu.io";

	public MenuController() {
		menu = loadReadIOFile(MENU_DIRECTORY);
		
		if (menu == null) {
			menu = new Menu();
		}
	}
	
	public Menu getMenu() {
		return menu;
	}
	
	public Item getItemByName(String itemName) {
		for (Item item : menu.getItems()) {
			if (itemName.toString().equalsIgnoreCase(item.getName())) {
				return item;
			}
		}
		return null;
	}
	
	public void createMenuItem(Item item) {
		menu.getItems().add(item);
	}

	public void updateItemNameByName(Item item, String newName) {
		menu.getItems().get(menu.getItems().indexOf(item)).setName(newName);
	}

	public void updateItemDescriptionByName(Item item, String newDescription) {
		menu.getItems().get(menu.getItems().indexOf(item)).setDescription(newDescription);
	}
	
	public void updateItemPriceByName(Item item, float newPrice) {
		menu.getItems().get(menu.getItems().indexOf(item)).setPrice(newPrice);
	}

	public void deleteItemByName(Item item) {
		menu.getItems().remove(item);
	}
	
	public void saveData() {
		writeSaveIOFile(MENU_DIRECTORY, menu);
	}
}
