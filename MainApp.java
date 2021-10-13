package com.arcadial.restaurant.controller;

import java.util.Scanner;

import com.arcadial.restaurant.view.MenuView;

public class MainApp {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println(
				"Please select an option: \n1. Create/Update/Remove menu item \n2. Create/Update/Remove promotion"
						+ "\n3. Create order\n4. View order\n5. Add/Remove reservation booking\n6. Check table availability\n"
						+ "9. Print order invoice\n10. Print sale revenue report by period");
		int input = sc.nextInt();

		switch (input) {
		case 1: {
			MenuView menuView = new MenuView(new MenuController());
			menuView.selectCRUDType();
		}
		case 2: {
			break;
		}
		case 3: {

			break;
		}
		case 4: {

			break;
		}
		case 5: {

			break;
		}
		case 6: {

			break;
		}
		case 7: {

			break;
		}
		case 8: {

			break;
		}
		case 9: {

			break;
		}
		case 10: {

			break;
		}
		}

		sc.close();
	}

}
