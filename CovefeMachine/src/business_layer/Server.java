package business_layer;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.simple.parser.ParseException;

import interfaces.*;
import presentation_layer.*;

public class Server implements Observer, Subject {

	ResponseProcessor parser;
	ArrayList<Observer> controllerObservers;
	ArrayList<Order> orders;
	ArrayList<Orderer> orderers;

	Drink processingDrink;
	Order processingOrder;

	public Server() {
		init();
	}

	public void registerObserver(Observer controller) {
		controllerObservers.add(controller);
	}

	public void removeObserver(Observer controller) {
		controllerObservers.remove(controller);
	}

	public void notifyObservers() {
		for (Observer currentControllerObserver : controllerObservers) {
			currentControllerObserver.update(processingOrder);
			break; // Just does the first controller for now
		}
	}

	public void update(String message) {
		String[] messageParts = message.split(" ");
		serverNotice(messageParts[0] + " " + messageParts[1] + " from coffee controller with id " + messageParts[2]);
		orderers.get(0).update(messageParts[1]);
	}

	public void update(Order order) {
		Drink drink = order.getDrink();
		orders.add(order);
		this.processingOrder = order;
		this.processingDrink = drink;
		serverNotice("[Server] Processing recipe " + drink.getDrinkName());
		notifyObservers();
	}

	private void serverNotice(String message) {
		System.out.println("[Server] \u001B[33mServer: " + message + "\u001B[0m");
	}

	public void updateOrder(OrderConResponse response) {
		// updateOrder updates the order with response from the controllers.
		for (Order currentOrder : orders) {
			if (currentOrder.getOrderID() == response.getOrderID()) {
				if (response.getOrderID() == 0) {
					// status 0 means done
					currentOrder.setOrderCompleted();
					System.out.println(
							"[Server - ControllerResponse] OrderID: " + response.getOrderID() + " is ready. Errorcode: "
									+ response.getErrorcode() + " Error describtion: " + response.getErrordesc());
					// TODO sendUserResonse with JSON
				} else {
					// status 1
					currentOrder.setErrorcode(response.getErrorcode());
					currentOrder.setErrordesc(response.getErrordesc());
					System.out.println("[Server - ControllerResponse] OrderID: " + response.getOrderID()
							+ " fail to brew. Errorcode: " + response.getErrorcode() + " Error describtion: "
							+ response.getErrordesc());
				}
			}
		}

	}

	public void brewWithAnotherMachine(Order order) {
		changeCoffeeMachineID(order);
	}

	private void changeCoffeeMachineID(Order order) {
		int new_coffee_machine_id = order.getCoffee_machine_id() + 1;
		order.setCoffee_machine_id(new_coffee_machine_id);
	}

	@Override
	public void notifyObservers(Order order) {}
	
	public void registerOrderer(Orderer RegisteringOrderer) {
		orderers.add(RegisteringOrderer);
		System.out.println("[Server] Registered Orderer to Server");
	}
	
	private void init() {
		parser = new ResponseProcessor();
		controllerObservers = new ArrayList<Observer>();
		orders = new ArrayList<Order>();
		orderers = new ArrayList<Orderer>();
		// Temp
		SimulatedCoffeeController c0 = new SimulatedCoffeeController(0);
		SimulatedCoffeeController c1 = new SimulatedCoffeeController(1);
		c0.registerObserver(this);
		c1.registerObserver(this);
		registerObserver(c0);
		registerObserver(c1);
	}

}
