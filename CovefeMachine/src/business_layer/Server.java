package business_layer;

import java.util.ArrayList;
import java.util.HashMap;

import interfaces.*;

public class Server implements Observer, Subject {

	private HashMap<String, Object> entires;

	public Server() {
		HashMap entries = new HashMap<String, Object>();
	}

	public void addDataseItem(String makeNewList, ArrayList<Object> items) {
		
	}
	
	public void registerObserver(Observer o) {
		// TODO Auto-generated method stub
		
	}

	public void removeObserver(Observer o) {
		// TODO Auto-generated method stub
		
	}

	public void notifyObservers() {
		// TODO Auto-generated method stub
		
	}

	public void update(String message) {
		// TODO Auto-generated method stub
		
	}

}
