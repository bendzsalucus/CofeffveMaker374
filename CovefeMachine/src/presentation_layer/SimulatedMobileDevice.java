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
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		
		// Just connects to the first server for now
		for(Server s : Main.servers) {
			registerObserver(s);
			break;
		}
		
	}

	public void update(String message) {
		simulateDeviceDisplay(message);
	}

	public void registerObserver(Observer o) {
		if(server != null) {
			simulateDeviceDisplay("Tried to connect to multiple servers at the same time.");
		} else {
			server = o;
			simulateDeviceDisplay("Connected to server");
		}
	}

	public void removeObserver(Observer o) {
		server = null;
	}

	public void notifyObservers() {
		server.update(order);
	}
	
	private void simulateDeviceDisplay(String message) {
		System.out.println("Mobile device " + deviceNumber + ": " + message + "\n");
	}

}
