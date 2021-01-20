package business_layer;

import java.util.ArrayList;
import java.util.HashMap;

import interfaces.*;

public class Server implements Observer, Subject, Runnable {

	private HashMap<String, Object> entires;

	public Server() {
		HashMap entries = new HashMap<String, Object>();
	}

	public void addDataseItem(String makeNewList, ArrayList<Object> items) {
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void registerObserver(Observer o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeObserver(Observer o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(String message) {
		// TODO Auto-generated method stub
		
	}

}
