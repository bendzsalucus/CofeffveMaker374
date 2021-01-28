package business_layer;

import java.util.ArrayList;

import org.json.simple.JSONArray;

import presentation_layer.JSONWritter;
import presentation_layer.Parsers;

public class SimpleBehavior implements BrewBehavior {
	JSONWritter writer = new JSONWritter();
	Parsers parser = new Parsers();
	
	@Override
	public void brew(Order order) {
		try {
			ArrayList<Order> orders = new ArrayList<Order>();
			orders.add(order);
			JSONArray commandStreamsJSONFile= writer.writeCommandStreams(orders);
			System.out.println("[JSON-CommandStreams] " + commandStreamsJSONFile);
			Thread.sleep(4000);
//			JSONArray responseJSON = parser.parseControllerResponse(server);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
	
	

}
