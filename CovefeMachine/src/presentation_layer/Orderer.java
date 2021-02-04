package presentation_layer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

import org.json.simple.parser.ParseException;

import business_layer.DrinkRecipe;
import business_layer.Drinks;
import business_layer.Ingredient;
import business_layer.Order;
import business_layer.ProgrammableFactory;
import business_layer.Server;

public class Orderer {

	static ArrayList<Server> servers;
	static ArrayList<SimulatedMobileDevice> mobileApps;
	boolean ordering;
	private ArrayList<Ingredient> ingreidientsList;
	private ArrayList<DrinkRecipe> drinks;
	private ArrayList<Ingredient> condiments;
	private Parsers parser;
	private ArrayList<Order> orders;
	private ProgrammableFactory programmablefactory;

	public Orderer() {
		init();
		handleOrdering(false, new Scanner(System.in));

	}

	public Orderer(String coffee, ArrayList<Integer> sentConds) {
		init();
		preBuiltOrder(coffee, sentConds);

	}

	public Orderer(String string) throws FileNotFoundException, IOException, ParseException, URISyntaxException {
		ArrayList<Server> servers = new ArrayList<Server>();
		Server server = new Server();
		servers.add(server);
		parser = new Parsers();
		if (string.equals("ParsingJSONFileOrder-inputJSON-test")) {
			orders = parser.parseOrderInput();
			for (Order order : orders) {
				servers.get(0).update(order);
			}
		}
	}

	private void preBuiltOrder(String chanelle, ArrayList<Integer> sentConds) {

		DrinkRecipe drinkRecipe = programmablefactory.coffeeRecipe(chanelle);
		Order order = new Order(3, "5500 WABASH AVE", 47803, drinkRecipe);

//		ArrayList<Ingredient> added = new ArrayList<Ingredient>();

//		for (int i = 0; i < sentConds.size(); i++) {
//			added.add(condiments.get(sentConds.get(i)));
//		}

//		drinkRecipe.addExtras(added);

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

		this.programmablefactory = new ProgrammableFactory();
		this.drinks = new Drinks().getDrinkList();
		this.ingreidientsList = new Drinks().getIngridients();
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
		int randomOrderID = r.nextInt() * 1000 * r.nextInt();
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

//	public void JSONSimulation() {
//		Server server = servers.get(0);
//		server.JSONSimulation();
//	}

}
