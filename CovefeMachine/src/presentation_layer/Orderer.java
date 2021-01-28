package presentation_layer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

import business_layer.DrinkRecipe;
import business_layer.Ingredient;
import business_layer.Order;
import business_layer.Server;

public class Orderer {

	static ArrayList<Server> servers;
	static ArrayList<SimulatedMobileDevice> mobileApps;
	boolean ordering;
	private HashMap<String, Ingredient> ingreidientsList;
	private ArrayList<DrinkRecipe> drinks;
	private ArrayList<Ingredient> condiments;

	public Orderer() {
		init();
		handleOrdering(false, new Scanner(System.in));

	}

	public Orderer(int coffee, ArrayList<Integer> sentConds) {
		init();
		preBuiltOrder(coffee, sentConds);

	}

	private void preBuiltOrder(int orderNum, ArrayList<Integer> sentConds) {

		DrinkRecipe drinkRecipe = drinks.get(orderNum);
//		System.out.println(drinkRecipe.getName());
		Order order = new Order(22, "5500 WABASH AVE", 47803, drinkRecipe);

		ArrayList<Ingredient> added = new ArrayList<Ingredient>();

		for (int i = 0; i < sentConds.size(); i++) {
			added.add(condiments.get(sentConds.get(i)));
//			System.out.println("here");
		}

		drinkRecipe.addExtras(added);

		System.out.println("You ordered: " + drinkRecipe.getName() + " with " + drinkRecipe.getIngredientsString());
//		System.out.println(order.getOrderID());
		servers.get(0).update(order);

		return;

	}

	private void init() {
		servers = new ArrayList<Server>();
		ordering = true;
		// Only one server for this demo
		servers.add(new Server());

		ingreidientsList = setUpIngridents();
		drinks = setUpDrinks(ingreidientsList);
		condiments = setupExtraIngriedents();

	}

	private void handleOrdering(boolean firstOrder, Scanner scanny) {

		if (firstOrder) {

			System.out.println("Menu:________________________________");

			for (int i = 0; i < drinks.size(); i++) {
				DrinkRecipe cur = drinks.get(i);
				System.out.println(i + ". " + cur.getName() + "   Ingridients:  " + cur.getIngredientsString());
			}
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

		if (orderNum > drinks.size()) {
			System.out.println("Invalid Drink Order");
		}
		DrinkRecipe drinkRecipe = drinks.get(orderNum);
		Random r = new Random();
		int randomOrderID = r.nextInt() *1000 * r.nextInt();
		Order order = new Order(randomOrderID, "5500 WABASH AVE", 47803, drinkRecipe);

		ArrayList<Ingredient> added = new ArrayList<Ingredient>();
		added = condimentOrder(scanny, condiments);
		System.out.println("I'm back");
		drinkRecipe.addExtras(added);

		System.out.println("You ordered: " + drinkRecipe.getName() + " with " + drinkRecipe.getIngredientsString());
		servers.get(0).update(order);
		scanny.close();

		return;

	}

	private ArrayList<Ingredient> condimentOrder(Scanner scanny, ArrayList<Ingredient> condiments) {
		ArrayList<Ingredient> added = new ArrayList<Ingredient>();
		boolean pre = false;
		while (ordering) {
			if (!pre) {
				System.out.println("Would you like any condiments with your order? Enter 404 to singal you are done.");
				System.out.println();
				for (int i = 0; i < condiments.size(); i++) {
					Ingredient cur = condiments.get(i);
					System.out.println(i + ". " + cur.getName());

				}

				pre = true;

			} else {
				System.out.println("Anything else?");
			}

			int scarlett = 0;
			try {
				scarlett = Integer.parseInt(scanny.nextLine());
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
				return added;
			}
		}
		ordering = true;// set the true for next ordering simulation
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

	private HashMap<String, Ingredient> setUpIngridents() {
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

	private ArrayList<Ingredient> setupExtraIngriedents() {
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

	private ArrayList<DrinkRecipe> setUpDrinks(HashMap<String, Ingredient> ingreidientsList) {
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

	public void JSONSimulation() {
		Server server = servers.get(0);
		server.JSONSimulation();
	}

}
