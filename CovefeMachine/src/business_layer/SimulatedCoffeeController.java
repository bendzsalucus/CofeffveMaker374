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
	
	BrewBehavior behavior;
	String status;
	DrinkRecipe recipe;
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
		coffeeControllerNotice("Started coffee: " + recipe.getName());
		behavior.brew();
		
		status = "Order Ready";
		coffeeControllerNotice("Dispersed coffee: " + recipe.getName());
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
	
	public void update(DrinkRecipe recipe) {
		this.recipe = recipe;
        Thread t = new Thread(this);
        t.start();
	}
	
	private void coffeeControllerNotice(String message) {
		System.out.println("\u001B[32mCoffee controller " + id + ": " + message + "\u001B[0m");
	}
	

}
