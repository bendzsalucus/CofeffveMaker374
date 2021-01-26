package presentation_layer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import business_layer.*;

public class Main {

	static ArrayList<Server> servers;
	static ArrayList<SimulatedMobileDevice> mobileApps;
	static boolean ordering;

	public static void main(String[] args) {

		servers = new ArrayList<Server>();
		ordering = true;
		// Only one server for this demo
		servers.add(new Server());

		HashMap<String, Ingredient> ingreidientsList = setUpIngridents();
		ArrayList<DrinkRecipe> drinks = setUpDrinks(ingreidientsList);
		ArrayList<Ingredient> condiments = setupExtraIngriedents();

		System.out.println("Menu:________________________________");

		Scanner scanny = new Scanner(System.in);

		while (true) {
			for (int i = 0; i < drinks.size(); i++) {
				DrinkRecipe cur = drinks.get(i);
				System.out.println(i + ". " + cur.getName() + "   Ingridients:  " + cur.getIngredientsString());
			}

			int orderNum = 0;
			try {
				System.out.println("______________________________");
				System.out.println("Enter the number of the drink you want: ");
				orderNum = Integer.parseInt(scanny.nextLine());
			}

			catch (Exception e) {
				System.out.println("Invalid Input");
			}

			DrinkRecipe order = drinks.get(orderNum);

			ArrayList<Ingredient> added = new ArrayList<Ingredient>();
			added = condimentOrder(scanny, condiments);
			System.out.println("I'm back");
			order.addExtras(added);

			System.out.println("You ordered: " + order.getName() + " with " + order.getIngredientsString());
			servers.get(0).update(order);
		}

		// Controller.make(order);

	}

//	private static void condimentOrder(Scanner scanny, ArrayList<Ingredient> condiments, boolean first,
//			ArrayList<Ingredient> added, boolean done) {
//		while (true) {
//
//			if (first) {
//				System.out.println("Would you like any condiments with your order? Enter 404 to singal you are done.");
//
//				for (int i = 0; i < condiments.size(); i++) {
//					Ingredient cur = condiments.get(i);
//					System.out.println(i + ". " + cur.getName());
//				}
//			} else {
//				System.out.println("Anything else?");
//			}
//
//			int scarlett = 0;
//
//			try {
//				scarlett = scanny.nextInt();
//			} catch (Exception e) {
//				System.out.println("Invalid Order.");
//				condimentOrder(scanny, condiments, false, added, true);
//			}
//
//			for (int i = 0; i < condiments.size(); i++) {
//				if (scarlett == i) {
//					added.add(condiments.get(i));
//				}
//			}
//
//			if (scarlett == 404) {
//				System.out.println("404 HELP");
//				return;
//			}
//			condimentOrder(scanny, condiments, false, added, true);
//
//		}
//	}

	
	private static ArrayList<Ingredient> condimentOrder(Scanner scanny, ArrayList<Ingredient> condiments) {
		ArrayList<Ingredient> added = new ArrayList<Ingredient>();
		boolean second = false;
		boolean pre = false;
		while (ordering) {
			if (!pre) {
				if(!second) {
					System.out.println("Would you like any condiments with your order? Enter 404 to singal you are done.");
					System.out.println();
					for (int i = 0; i < condiments.size(); i++) {
						Ingredient cur = condiments.get(i);
						System.out.println(i + ". " + cur.getName());
					}
				}else {
					System.out.println("Would else you like any condiments with your order? Enter 404 to singal you are done.");
					System.out.println();
					for (int i = 0; i < condiments.size(); i++) {
						Ingredient cur = condiments.get(i);
						System.out.println(i + ". " + cur.getName());
					}
				}
			} else {
				System.out.println("Anything else?");
			}

			int scarlett = 0;
			try {
				scarlett = scanny.nextInt();
			} catch (Exception e) {
				System.out.println("Invalid Order.");
			}
			
			for (int i = 0; i < condiments.size(); i++) {
				if (scarlett == i) {
					added.add(condiments.get(i));
				}
			}
			
			if (scarlett == 404) {
				System.out.println("404 HELP");
				ordering = false;
			}
		}
		ordering = true;//set the true for next ordering simulation
		System.out.println(added.toString());
		return added;
	}
	
	// Temporary
	public static void update(String message) {
		if (message.equals("Ready")) {
			System.out.println("Your Order is Ready!");
		} else {
			System.out.println("Your Order wasn't processed properly.");
		}

	}

	private static HashMap<String, Ingredient> setUpIngridents() {
		HashMap<String, Ingredient> temp = new HashMap<String, Ingredient>();
		temp.put("Milk", (new Ingredient("Milk", "Cow stuff")));
		temp.put("Bark", (new Ingredient("Bark", "Tree stuff")));
		temp.put("Caramel", (new Ingredient("Caramel", "Sweet Brown Stuff")));
		temp.put("Cinnamon", (new Ingredient("Cinnamon", "Challenge stuff")));
		temp.put("Sugar", (new Ingredient("Sugar", "Cane stuff")));
		temp.put("American Beans", (new Ingredient("American Beans", "Beans grown in America")));
		temp.put("Brazilian Beans", (new Ingredient("Brazilian Beans", "Beans from Brazil")));
		temp.put("Amazon Beans", (new Ingredient("Amazon Beans", "Prime Beans")));
		return temp;
	}

	private static ArrayList<Ingredient> setupExtraIngriedents() {
		ArrayList<Ingredient> extras = new ArrayList<Ingredient>();
		extras.add((new Ingredient("Milk", "Cow stuff")));
		extras.add((new Ingredient("Bark", "Tree stuff")));
		extras.add((new Ingredient("Caramel", "Sweet Brown Stuff")));
		extras.add((new Ingredient("Cinnamon", "Challenge stuff")));
		extras.add((new Ingredient("Sugar", "Cane stuff")));
		extras.add((new Ingredient("American Beans", "Beans grown in America")));
		extras.add((new Ingredient("Brazilian Beans", "Beans from Brazil")));
		extras.add((new Ingredient("Amazon Beans", "Prime Beans")));
		return extras;
	}

	private static ArrayList<DrinkRecipe> setUpDrinks(HashMap<String, Ingredient> ingreidientsList) {
		ArrayList<DrinkRecipe> drinks = new ArrayList<DrinkRecipe>();

		ArrayList<Ingredient> temp = new ArrayList<Ingredient>();
		temp.add(ingreidientsList.get("American Beans"));
		drinks.add(new DrinkRecipe("American Black Coffee", temp));

		temp = new ArrayList<Ingredient>();
		temp.add(ingreidientsList.get("American Beans"));
		temp.add(ingreidientsList.get("Bark"));
		temp.add(ingreidientsList.get("Milk"));
		drinks.add(new DrinkRecipe("Mocha", temp));

		temp = new ArrayList<Ingredient>();
		temp.add(ingreidientsList.get("American Beans"));
		temp.add(ingreidientsList.get("Sugar"));
		temp.add(ingreidientsList.get("Milk"));
		temp.add(ingreidientsList.get("Bark"));
		drinks.add(new DrinkRecipe("Scarlett Surprise", temp));

		temp = new ArrayList<Ingredient>();
		temp.add(ingreidientsList.get("Milk"));
		temp.add(ingreidientsList.get("Sugar"));
		temp.add(ingreidientsList.get("Cinnamon"));
		drinks.add(new DrinkRecipe("Cold Brew", temp));

		temp = new ArrayList<Ingredient>();
		temp.add(ingreidientsList.get("Milk"));
		temp.add(ingreidientsList.get("Sugar"));
		temp.add(ingreidientsList.get("Cinnamon"));
		temp.add(ingreidientsList.get("Amazon Beans"));
		drinks.add(new DrinkRecipe("Caramel Macchiato", temp));

		temp = new ArrayList<Ingredient>();
		temp.add(ingreidientsList.get("Milk"));
		temp.add(ingreidientsList.get("Sugar"));
		temp.add(ingreidientsList.get("Caramel"));
		temp.add(ingreidientsList.get("Amazon Beans"));
		drinks.add(new DrinkRecipe("Doice Skinny Latte", temp));

		return drinks;
	}

}
