package presentation_layer;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import IngredientPackage.Ingredients;
import business_layer.AbstractOrderFactory;
import business_layer.AutomatedOrderFactory;
import business_layer.Condiment;
import business_layer.Drink;
//import business_layer.DrinkRecipe;
import business_layer.Drinks;
import business_layer.Ingredient;
import business_layer.Order;
import business_layer.ProgrammableOrderFactory;
import business_layer.Server;
import business_layer.SimpleOrderFactory;
import business_layer.Usual;
import interfaces.Observer;
import interfaces.Subject;

public class Orderer implements Observer, Subject, OrderInputParser {

	static ArrayList<Observer> servers;
	static ArrayList<SimulatedMobileDevice> mobileApps;
	private boolean ordering;
	private Drinks drinksClass;
	private ArrayList<Condiment> condimentList;
	private ArrayList<Drink> drinkList;
	private ArrayList<Order> orders;
	private AbstractOrderFactory programmableOrderFactory;
	private AbstractOrderFactory simpleOrderFactory;
	private AbstractOrderFactory automatedOrderFactory;
	private ArrayList<AbstractOrderFactory> factories;
	private JSONObject parsedJSON;
	private Ingredients ingredients = Ingredients.getInstance();
	private Usual Usual1;
	
	public Orderer() {
		init();
		handleOrdering(false, new Scanner(System.in));

	}

	public Orderer(String mode) {
		// This initiation makes orderer take in string for order-input in JSON format
		if (mode.equals("orderTakerMode")) {
			init();
		}else if (mode.equals("GUI Command")){
			init();
		}
	}

	public Orderer(String drinkname, ArrayList<Integer> sentConds) {
		init();
		preBuiltOrder(drinkname, sentConds);
	}

	private void preBuiltOrder(String chanelle, ArrayList<Integer> sentConds) {
		ArrayList<Condiment> condiments = getCondimentsFromIntegers(sentConds);
		Order order = createOrderFromFactory(1, "5500 WABASH AVE", 47803, chanelle, condiments);
		printOrderedStatus(order); // e.x. "[preBuiltOrder] You ordered: Regular Latte with Sugar"
		servers.get(0).update(order);
	}

	private void handleOrdering(boolean firstOrder, Scanner scanny) {

		if (!firstOrder) {

			System.out.println("Menu:________________________________");

			for (int i = 0; i < drinkList.size(); i++) {
				Drink cur = drinkList.get(i);
				if (cur.getCondiments().size() == 0) {
					System.out.println(i + ". " + cur.getDrinkName());
				} else {
					System.out.println(i + ". " + cur.getDrinkName() + "  " + cur.getCondiments());
				}
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

		if (orderNum > drinkList.size()) {
			System.out.println("Invalid Drink Order");
		}
		Drink drink = drinkList.get(orderNum);
		Random r = new Random();
		int randomOrderID = r.nextInt() * 1000 * r.nextInt();
		ArrayList<Condiment> added = new ArrayList<Condiment>();
		added = condimentOrder(scanny, condimentList);
		Order order = createOrderFromFactory(randomOrderID, "5500 WABASH AVE", 47803, drink.getDrinkName(), added);
//		System.out.println("I'm back");

		System.out.println("[Orderer] You ordered: " + order.getDrinkName() + " with " + order.getCondiments());
		notifyObservers(order);
		scanny.close();

		return;

	}

	private ArrayList<Condiment> condimentOrder(Scanner scanny, ArrayList<Condiment> condiments) {
		ArrayList<Condiment> added = new ArrayList<Condiment>();
		boolean pre = false;
		while (ordering) {
			if (!pre) {
				System.out.println("Would you like any condiments with your order? Enter 404 to singal you are done.");
				System.out.println();
				for (int i = 0; i < condiments.size(); i++) {
					Condiment cur = condiments.get(i);
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
					System.out.println("[Orderer] Current Condiments in List: " + added);
				}
			}

			if (scarlett == 404) {
				System.out.println("404 HELP");
				ordering = false;
//				System.out.println(added.toString());
				return added;
			}
		}
		ordering = true;// set the true for next ordering simulation
		return added;
	}

	@Override
	public void update(Order order) {
	}

	@Override
	public void update(String message) {
		if (message.equals("Ready")) {
			System.out.println("[Orderer - Customer Notification] Your Order is Ready!");
		} else {
			System.out.println("[Orderer - Customer Notification] Your Order wasn't processed properly.");
		}

	}

	@Override
	public void updateOrder(OrderConResponse response) {
		// TODO Auto-generated method stub

	}

	@Override
	public void registerObserver(Observer server) {
		registerOrdererToServer(server);
		servers.add(server);
	}

	private void registerOrdererToServer(Observer server) {
		Server registeringOrderer = (Server) server;
		registeringOrderer.registerOrderer(this);
	}

	@Override
	public void removeObserver(Observer server) {
		servers.remove(server);
	}

	@Override
	public void notifyObservers(Order order) {
		for (Observer server : servers) {
			server.update(order);
		}
	}

	private void printOrderedStatus(Order order) {
		if (order != null) {
			System.out.println("[Orderer - preBuiltOrder] You ordered: " + order.getDrinkName() + " with "
					+ order.getCondiments());
		} else {
			System.out.println("[Orderer - preBuiltOrder] You order fails");
		}
	}

	private void init() {
		servers = new ArrayList<Observer>();
		ordering = true;
		// Only one server for this demo
		registerObserver(new Server());
		this.programmableOrderFactory = new ProgrammableOrderFactory();
		this.simpleOrderFactory = new SimpleOrderFactory();
		this.automatedOrderFactory = new AutomatedOrderFactory();
		this.factories = new ArrayList<AbstractOrderFactory>();
		factories.add(programmableOrderFactory);
		factories.add(automatedOrderFactory);
		factories.add(simpleOrderFactory);
		System.out.println("[Orderer] Done initiating factories");
		drinksClass = new Drinks();
		this.drinkList = drinksClass.getDrinkList();
		this.condimentList = drinksClass.getCondiments();
	}

	private Order createOrderFromFactory(int orderID, String street, int ZIP, String drinkName,
			ArrayList<Condiment> condiments) {
		Order order = null;
		for (AbstractOrderFactory currentFactory : factories) {
			if (order == null) {
				order = currentFactory.createOrder(orderID, street, ZIP, drinkName, condiments);
			}
		}
		// Testing lines for printing out the order from one of the factories
		if (order != null) {
			System.out.println("[Factory] Order created. OrderID: " + order.getOrderID() + " DrinkName: "
					+ order.getDrinkName() + "Drink Type: " + order.getRequesttype());
		} else {
			System.out.println("[Factory] Machine does not have this drink - " + drinkName);
		}
		return order;
	}
	
	

	public ArrayList<Condiment> getCondimentsFromIntegers(ArrayList<Integer> sentConds) {
		ArrayList<Condiment> condiments = new ArrayList<Condiment>();
		for (int i = 0; i < sentConds.size(); i++) {
			condiments.add(condimentList.get(sentConds.get(i)));
		}
		return condiments;
	}

	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub

	}

	public void inputOrderInputFromJSONString(Reader OrderInputJSONReader) {
		parse(OrderInputJSONReader);
		Drink drink = getRecipeWithIngredients();
		System.out.println(getCondiments());
		Order order = programmableOrderFactory.createOrder(getOrderID(), getStreet(), getZIP(),getDrinkName(),getCondiments(), getRecipeWithIngredients());
		printOrderedStatus(order); 
		servers.get(0).update(order);
	}

	@Override
	public int getOrderID() {
		int orderID = ((Long) parsedJSON.get("orderID")).intValue();
		return orderID;
	}

	@Override
	public String getDrinkName() {
		String drinkName = (String) parsedJSON.get("drink");
		return drinkName;
	}

	@Override
	public String getStreet() {
		JSONObject address = (JSONObject) parsedJSON.get("address");
		String street = (String) address.get("street");
		return street;
	}

	@Override
	public int getZIP() {
		JSONObject address = (JSONObject) parsedJSON.get("address");
		int ZIP = ((Long) address.get("ZIP")).intValue();
		return ZIP;
	}

	@Override
	public ArrayList<Condiment> getCondiments() {
		ArrayList<Condiment> condimentsRequest = new ArrayList<Condiment>();
		JSONArray comdiments = (JSONArray) parsedJSON.get("condiments");
		// counting quatity and add classes
		if (comdiments != null) {
			Iterator comdimentIterator = comdiments.iterator();
			while (comdimentIterator.hasNext()) {
				JSONObject comdiment = (JSONObject) comdimentIterator.next();
				int quantity = ((Long) comdiment.get("qty")).intValue();
				String condimentName = (String) comdiment.get("name");
				for (int j = 0; j < quantity; j++) {
					Condiment tempCondiment = createCondiment(condimentName);
					if (tempCondiment != null)
						condimentsRequest.add(tempCondiment);
				}
			}
			System.out.println(condimentsRequest);
		} else {
			System.out.println("[Orderer] No condiments received");
		}
		return condimentsRequest;
	}

	@Override
	public Drink getRecipeWithIngredients() {
		// TODO Auto-generated method stub
		ArrayList<Condiment> recipesRequest = new ArrayList<Condiment>();
		ArrayList<Drink> drinkWrapees = new ArrayList<Drink>(); 
		JSONArray recipes = (JSONArray) parsedJSON.get("Recipe");
	    Drink currentWrapee = drinksClass.getRecipeDrink();
		// counting Ingredient and add classes
		if (recipes != null) {
			Iterator recipesIterator = recipes.iterator();
			while (recipesIterator.hasNext()) {
				JSONObject step = (JSONObject) recipesIterator.next();
				String commandStep = (String) step.get("commandstep");
				String ingredientObject = (String) step.get("object");
				if(ingredientObject==null) ingredientObject = "N/A";
				currentWrapee = createWrapee(commandStep, ingredientObject, currentWrapee);
			}
			System.out.println(recipesRequest);
		} else {
			System.out.println("[Orderer] No Recipe received for Customized Drink");
		}
		return currentWrapee;
	}
	
	@Override
	public Drink createWrapee(String commandStep, String ingredientObject, Drink wrappee) {
		ArrayList<Ingredient> stepList = ingredients.getIngredientList();
		for(Ingredient currentStep : stepList) {//finding the right step to wrapee
			if(commandStep.equals(currentStep.getCommandStep())) {
				if(ingredientObject.equals("N/A")) {
					return currentStep.wrap(wrappee);
				}else {
					if(ingredientObject.equals(currentStep.getObjectName())) {
						return currentStep.wrap(wrappee);
					}
				}
			}
		}
		System.out.println("[Orderer] Unknown Recipe in JSON Request");
		return null;
	}

	@Override
	public void parse(Reader OrderInputJSONReader) {
		// TODO Auto-generated method stub
		JSONParser parser = new JSONParser();
		try {
			try {
				parsedJSON = (JSONObject) ((JSONObject) parser.parse(OrderInputJSONReader)).get("order");
			} catch (IOException e) {
				System.out.println("Error Within OrderInputJSON");
				e.printStackTrace();
			}
			System.out.println("[Orderer] Parsing order input json successed");
		} catch (ParseException e) {
			System.out.println("Error Within OrderInputJSON");
			e.printStackTrace();
		}
	} 

	@Override
	public Condiment createCondiment(String condimentName) {
		// TODO Auto-generated method stub
		for (Condiment currentCondiment : condimentList) {
			if (currentCondiment.getName().equals(condimentName)) {
				return currentCondiment;
			}
		}
		System.out.println("[Orderer] Unknown Condiment in JSON request");
		return null;
	}

	public Usual createUsual(ArrayList<String> austinUsualDrinks, int orderID, String street, int ZIP ) {
		ArrayList<Order> ArraustinUsualOrders = new ArrayList<>(); 
		for(String currentDrink: austinUsualDrinks){
			Order currentOrder= createOrderFromFactory(orderID, street, ZIP, currentDrink, new ArrayList<Condiment>());
			ArraustinUsualOrders.add(currentOrder);
		}
		Usual createdUsual = new Usual(ArraustinUsualOrders);
		createdUsual.setServer((Server)servers.get(0));
		return createdUsual;
	}

}
