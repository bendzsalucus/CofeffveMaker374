package business_layer;

import java.io.IOException;
import java.net.URISyntaxException;

import org.json.simple.parser.ParseException;

import interfaces.Observer;
import interfaces.Subject;
import presentation_layer.Parsers;
 

public class SimulatedCoffeeController implements Observer, Subject, Runnable {
	
	Observer server;
	Parsers parser;
	Order order;
	
	BrewBehavior behavior;
	String status;
	DrinkRecipe recipe; // Thread local variables? :(
	int id;
	
	public SimulatedCoffeeController(int id) {
		this.id = id;
		this.behavior = new SimpleBehavior(); // temporary
		
	}
	
	public void simulateControllerResponse() {
		try {
			parser.parseControllerResponse(server);
		} catch (IOException | ParseException | URISyntaxException e) {
			System.out.println("[JSONSimulation]  Controller Response Parsing falls");
			e.printStackTrace();
		}
	}

	public void run() { // Just simulates the creation of the coffee at a particular station, possibly including manual input
		status = "Order Started";
		coffeeControllerNotice("Started coffee: " + order.getDrinkName());
		behavior.brew(order);
		
		status = "Order Ready";
		coffeeControllerNotice("Dispersed coffee: " + order.getDrinkName());
		notifyObservers();
	}

	public void registerObserver(Observer o) {
		if(server != null) {
			coffeeControllerNotice("Tried to connect to multiple servers. :(");
		} else {
			server = o;
			coffeeControllerNotice("Connected to server!");
		}
		
	}

	public void removeObserver(Observer o) {
		server = null;
		
	}

	public void notifyObservers() {
		server.update(status+ " " + id);
	}
	
	public void update(String message) {}
	
	public void update(Order order) {
		this.order = order;
		this.recipe = order.getDrinkRecipe();
		specifyOrderRequestType(order);
        Thread t = new Thread(this);
        t.start();
	}
	
	private void specifyOrderRequestType(Order order) {
		if(order.getIngredients().size()>0) {
			order.setRequesttype("Automated");
		}else {
			order.setRequesttype("Simple");
		}
	}

	private void coffeeControllerNotice(String message) {
		System.out.println("\u001B[32mCoffee controller " + id + ": " + message + "\u001B[0m");
	}
	

}
