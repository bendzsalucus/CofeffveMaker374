package presentation_layer;

import business_layer.Server;
import interfaces.*;

public class SimulatedMobileDevice implements Observer, Subject, Runnable {
	
	private Observer server;
	private int deviceNumber;
	private String order;

	public void run() {
		connectToServer();
	}

	private void connectToServer() {
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {}
		
		// Just connects to the first server for now
		for(Server s : Main.servers) {
			registerObserver(s);
			break;
		}
		
	}

	public void update(String message) {
		System.out.println("Mobile device " + deviceNumber + ": "+ message + "\n");
	}

	public void registerObserver(Observer o) {
		if(server != null) {
			System.out.println("Mobile device " + deviceNumber + ": This device tried to connect to multiple servers.\n");
		} else {
			server = o;
		}
	}

	public void removeObserver(Observer o) {
		server = null;
	}

	public void notifyObservers() {
		server.update(order);
	}

}
