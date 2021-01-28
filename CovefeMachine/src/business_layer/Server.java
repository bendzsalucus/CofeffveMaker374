package business_layer;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.simple.parser.ParseException;

import interfaces.*;
import presentation_layer.*;

public class Server implements Observer, Subject {
	
	private HashMap<String, Object> entries;
	Parsers parser;
	ArrayList<Observer> observers;
	ArrayList<Order> orders;
	
	DrinkRecipe processingRecipe;
	Order processingOrder;

	public Server() {
		parser = new Parsers();
		entries = new HashMap<String, Object>();
		observers = new ArrayList<Observer>();
		// Temp
		SimulatedCoffeeController c0 = new SimulatedCoffeeController(0);
		SimulatedCoffeeController c1 = new SimulatedCoffeeController(1);
		c0.registerObserver(this);
		c1.registerObserver(this);
		registerObserver(c0);
		registerObserver(c1);
	}

	public void addDataseItem(String makeNewList, ArrayList<Object> items) {
		
	}
	
	public void registerObserver(Observer o) {
		observers.add(o);
	}

	public void removeObserver(Observer o) {
		observers.remove(o);
	}

	public void notifyObservers() {
		for(Observer o: observers) {
			o.update(processingOrder);
			break;	// Just does the first controller for now
		}
	}

	public void update(String message) {
		String[] messageParts = message.split(" ");
		serverNotice(messageParts[0] + " " + messageParts[1] + " from coffee controller with id " + messageParts[2]);
		Orderer.update(messageParts[1]);
	}

	public void update(Order order) {
		DrinkRecipe recipe = order.getDrinkRecipe();
		this.processingOrder = order;
		this.processingRecipe = recipe;
		serverNotice("Processing recipe " + recipe.getName());
		notifyObservers();
	}
	
	private void serverNotice(String message) {
		System.out.println("\u001B[33mServer: " + message + "\u001B[0m");
	}

	public void updateOrder(OrderConResponse response) {
    	//updateOrder updates the order with response from the controllers.
		for(Order currentOrder: orders) {
			if(currentOrder.getOrderID() == response.getOrderID()) {
				if(response.getOrderID() == 0) {
					//status 0 means done
					currentOrder.setOrderCompleted();
					System.out.println("[JSONSimulation-Controller] OrderID: "+response.getOrderID()+ "is ready. Errorcode: "+response.getErrorcode() +" Error describtion: "+response.getErrordesc());
					//TODO sendUserResonse with JSON
				}else {
					//status 1 
					currentOrder.setErrorcode(response.getErrorcode());
					currentOrder.setErrordesc(response.getErrordesc());
					System.out.println("[JSONSimulation-Controller] OrderID: "+response.getOrderID()+ "fail to brew. Errorcode: "+response.getErrorcode() +" Error describtion: "+response.getErrordesc());
					//TODO sendUserResonse with JSON
//					e.g. 
//					"user-response": {
//					    "orderID": 1,
//					    "coffee_machine_id": 1,
//					    "status": 0,
//					    "status-message": "Your coffee has been prepared with your desired options."
//					  }
					
				}
			}
		}

		
	}

	public void JSONSimulation() {
		ArrayList<Order> JSONOrders = new ArrayList<Order>();
		//simulating receiving the order from Mobile phone with a JSON order file sending in
		//Generate a list of order
		try {
			JSONOrders = parser.parseOrderInput();
		} catch (IOException | ParseException | URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("[JSONSimulation] Bad parsing");
		}
		
		for(Order order : JSONOrders) {
			orders.add(order);
			System.out.println("[JSONSimulation] Order Recieve. OrderID: " + order.getOrderID());
		}
		
		//TODO orders are bunch of orders need to send to controller to brew
		// Order has a lot of info including drinkName, e.g. Americano, comdiments - ArrayList<Ingredient>
	}

	public void brewWithAnotherMachine(Order order) {
		changeCoffeeMachineID(order);
	}

	private void changeCoffeeMachineID(Order order) {
		int new_coffee_machine_id = order.getCoffee_machine_id()+1;
		order.setCoffee_machine_id(new_coffee_machine_id);
	}

}
