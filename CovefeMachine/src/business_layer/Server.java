package business_layer;

import java.util.ArrayList;
import java.util.HashMap;

import interfaces.*;

public class Server implements Observer, Subject {
	
	private HashMap<String, Object> entries;
	
	ArrayList<Observer> observers;
	
	DrinkRecipe processingRecipe;

	public Server() {
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
			o.update(processingRecipe);
			break;	// Just does the first controller for now
		}
	}

	public void update(String message) {
		String[] messageParts = message.split(" ");
		serverNotice(messageParts[0] + " " + messageParts[1] + " from coffee controller with id " + messageParts[2]);
	}

	public void update(DrinkRecipe recipe) {
		this.processingRecipe = recipe;
		serverNotice("Processing recipe " + recipe.getName());
		notifyObservers();
	}
	
	private void serverNotice(String message) {
		System.out.println("\u001B[33mServer: " + message + "\u001B[0m");
	}

}
