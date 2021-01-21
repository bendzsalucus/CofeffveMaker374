package business_layer;

import interfaces.Observer;
import interfaces.Subject;

public class SimulatedCoffeeController implements Observer, Subject, Runnable {
	
	Observer server;
	
	BrewBehavior behavior;
	String status;
	DrinkRecipe recipe;
	int id;
	
	public SimulatedCoffeeController(int id) {
		this.id = id;
		this.behavior = new SimpleBehavior(); // temporary
	}

	public void run() { // Just simulates the creation of the coffee at a particular station, possibly including manual input
		status = "Order Started";
		coffeeControllerNotice("Started coffee!");
		behavior.brew();
		status = "Order Ready";
		coffeeControllerNotice("Dispersed coffee!");
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
		server.update(status);
	}
	
	public void update(String message) {}
	
	public void update(DrinkRecipe recipe) {
		this.recipe = recipe;
        Thread t = new Thread(this);
        t.start();
	}
	
	private void coffeeControllerNotice(String message) {
		System.out.println("Coffee controller " + id + ": " + message);
	}
	

}
