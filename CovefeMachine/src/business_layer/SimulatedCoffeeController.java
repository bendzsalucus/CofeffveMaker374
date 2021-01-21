package business_layer;

import interfaces.Observer;
import interfaces.Subject;

public class SimulatedCoffeeController implements Observer, Subject, Runnable {
	
	Observer server;
	
	String status;
	Recipe recipe;
	int id;
	
	public SimulatedCoffeeController(int id) {
		this.id = id;
	}

	public void run() { // Just simulates the creation of the coffee at a particular station, possibly including manual input
		status = "Order Started";
		coffeeControllerNotice("Started coffee!");
		try {
			Thread.sleep(7200000);
		} catch (InterruptedException e) {}
		status = "Order Ready";
		coffeeControllerNotice("Finished coffee!");
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
	
	private void coffeeControllerNotice(String message) {
		System.out.println("Coffee controller " + id + ": " + message);
	}
	
	public void update(Recipe recipe) {
		this.recipe = recipe;
        Thread t = new Thread(this);
        t.start();
	}
	

}
