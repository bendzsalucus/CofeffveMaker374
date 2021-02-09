package business_layer;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

import org.json.simple.parser.ParseException;

import interfaces.Observer;
import interfaces.Subject;
import presentation_layer.OrderConResponse;
import presentation_layer.Parsers;
 

public class SimulatedCoffeeController implements Observer, Subject, Runnable {
	
	Observer server;
	Parsers parser;
	Order order;
	
	BrewBehavior behavior;
	String status;
	Drink drink; // Thread local variables? :(
	int id;
	
	public SimulatedCoffeeController(int id) {
		this.id = id;
		this.behavior = new SimpleBehavior(); // temporary
		
	}

	public void run() { // Just simulates the creation of the coffee at a particular station, possibly including manual input
		System.out.println();
		System.out.print("[Controller] Brewbehavior Selecting for Controller Type: ");
		this.behavior = selectingBrewBehavior(order);
		System.out.println(behavior);
		status = "Order Started";
		coffeeControllerNotice("Started coffee: " + order.getDrinkName());
		ArrayList<OrderConResponse> responses = behavior.brew(order);
		System.out.println();
		for(OrderConResponse response: responses) {
			server.updateOrder(response);
		}
		
		if(order.getStatus()==0) {
			System.out.println("[Controller Response] Brewed");
			status = "Coffee Ready "+ order.getCoffee_machine_id();
		}else {
			if(order.getErrorcode()==26) {
				((Server) server).brewWithAnotherMachine(order);
				System.out.println("[Controller Response] Brewing with another machine...");
//				behavior.brew(order);
			}
//		coffeeControllerNotice("Dispersed coffee: " + order.getDrinkName());
		notifyObservers();
		}
	}

	private BrewBehavior selectingBrewBehavior(Order processingOrder) {
		if(processingOrder.getRequesttype().equals("Simple")) {
			return new SimpleBehavior();
		}else if(processingOrder.getRequesttype().equals("Automated")){
			return new AutomatedBehavior();
		}else if(processingOrder.getRequesttype().equals("Programmable")) {
			return new ProgrammableBehavior();
		}
		System.out.println("[Controller] Failing to select a brewBehavior");
		return null;
	}

	public void registerObserver(Observer o) {
		if(server != null) {
			coffeeControllerNotice("[Controller] Tried to connect to multiple servers. :(");
		} else {
			server = o;
			coffeeControllerNotice("[Controller] Connected to server!");
		}
		
	}

	public void removeObserver(Observer o) {
		server = null;
		
	}

	public void notifyObservers() {
		server.update(status+ " " + id);
	}
	
	public void update(String message) {}
	
	public synchronized void update(Order order) {
		this.order = order;
		this.drink = order.getDrink();
//        Thread t = new Thread(this);
//        t.start();
		this.run();
	}


	private void coffeeControllerNotice(String message) {
		System.out.println("[Controller] \u001B[32mCoffee controller " + id + ": " + message + "\u001B[0m");
	}

	@Override
	public void updateOrder(OrderConResponse response) {
		//this is just method for not making the subject and observer more specific for the different sevreSubject or controllerSubjet
		//all methods are in the same interface for convince.
		
	}

	@Override
	public void notifyObservers(Order order) {
		// TODO Auto-generated method stub
		
	}
	
//	public void simulateControllerResponse() {
//	try {
//		parser.parseControllerResponse();
//	} catch (IOException | ParseException | URISyntaxException e) {
//		System.out.println("[JSONSimulation]  Controller Response Parsing falls");
//		e.printStackTrace();
//	}
//}


	

}
