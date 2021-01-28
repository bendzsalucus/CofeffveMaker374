package business_layer;

import java.util.ArrayList;

import org.json.simple.JSONArray;

import presentation_layer.JSONWritter;

public class SimpleBehavior implements BrewBehavior {
	JSONWritter writer = new JSONWritter();
	@Override
	public void brew(Order order) {
		try {
			ArrayList<Order> orders = new ArrayList<Order>();
			orders.add(order);
			JSONArray commandStreamsJSONFile= writer.writeCommandStreams(orders);
			System.out.println("[JSON-CommandStreams] " + commandStreamsJSONFile);
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
	
	

}
