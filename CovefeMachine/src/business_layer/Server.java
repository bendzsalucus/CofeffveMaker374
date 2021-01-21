package business_layer;

import java.util.ArrayList;
import java.util.HashMap;

import interfaces.*;

public class Server implements Observer, Subject {
	
	private HashMap<String, Object> entries;
	
	ArrayList<Observer> observers;

	public Server() {
		entries = new HashMap<String, Object>();
		observers = new ArrayList<Observer>();
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
			o.update(recipe);
			break;	// Just does the first controller for now
		}
	}

	public void update(String message) {
	}

	public void update(Recipe recipe) {}

}
