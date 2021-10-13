package com.arcadial.restaurant.view;

import java.util.Scanner;

import com.arcadial.restaurant.controller.MenuController;
import com.arcadial.restaurant.model.Dessert;
import com.arcadial.restaurant.model.Drink;
import com.arcadial.restaurant.model.Item;
import com.arcadial.restaurant.model.MainCourse;

public class MenuView {

	private Scanner scanner;
	private MenuController menuController;

	public MenuView(MenuController menuController) {
		this.menuController = menuController;
		scanner = new Scanner(System.in);
	}

	public void selectCRUDType() {
		System.out.println("1.Create menu item\n2.Update menu item\n3.Remove menu item\n4.Display menu items");
		int choice = scanner.nextInt();
		scanner.nextLine();

		switch (choice) {
		case 1:
			createMenuItem();
			break;
		case 2:
			updateMenuItem();
			break;
		case 3:
			removeMenuItem();
			break;
		case 4:
			displayMenuItems();
			break;
		}
		
		menuController.saveData();
	}

	private int selectItemType() {
		System.out.println("1.Main Course\n2.Drinks\n3.Desserts");
		int choice = scanner.nextInt();
		scanner.nextLine();
		return choice;
	}

	private void createMenuItem() {
		int choice = selectItemType();

		Item item;

		String selection = "";

		while (choice == 1 || choice == 2 || choice == 3) {

			if (choice == 1) {
				selection = "main course";
				item = new MainCourse();
			} else if (choice == 2) {
				selection = "drink";
				item = new Drink();
			} else {
				selection = "dessert";
				item = new Dessert();
			}

			System.out.println("Enter name of " + selection);
			String name = scanner.nextLine();
			item.setName(name);
			System.out.println("Enter description of " + name);
			String description = scanner.nextLine();
			item.setDescription(description);
			System.out.println("Enter price of " + name);
			float price = scanner.nextFloat();
			item.setPrice(price);

			menuController.createMenuItem(item);

			choice = selectItemType();
		}
	}

	private void updateMenuItem() {
		System.out.println("Enter name of item to start updating");
		String name = scanner.nextLine();

		Item item = menuController.getItemByName(name);

		if (item != null) {

			System.out.println(item.getName() + " found");
			System.out.println("Update\n1.Name\n2.Description\n3.Price");
			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1:
				System.out.println("Enter new name");
				String newName = scanner.nextLine();
				menuController.updateItemNameByName(item, newName);
				System.out.println("Name changed successfully");
				break;
			case 2:
				System.out.println("Enter new description");
				String newDescription = scanner.nextLine();
				menuController.updateItemDescriptionByName(item, newDescription);
				System.out.println("Description changed successfully");
				break;
			case 3:
				System.out.println("Enter new price");
				float newPrice = scanner.nextFloat();
				menuController.updateItemPriceByName(item, newPrice);
				System.out.println("Price changed successfully");
				break;
			}
		}
	}

	private void removeMenuItem() {
		System.out.println("Enter name of item to delete");
		String name = scanner.nextLine();

		Item item = menuController.getItemByName(name);
		menuController.deleteItemByName(item);
		System.out.println(item.getName() + " successfully deleted");
	}

	private void displayMenuItems() {
		System.out.println("Menu:");
		menuController.getMenu().getItems().forEach(item -> System.out.println(item));
	}
}
