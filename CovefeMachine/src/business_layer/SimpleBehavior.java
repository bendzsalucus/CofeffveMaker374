package business_layer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;

import presentation_layer.JSONWritter;
import presentation_layer.OrderConResponse;
import presentation_layer.Parsers;

public class SimpleBehavior implements BrewBehavior {
	JSONWritter writer = new JSONWritter();
	Parsers parser = new Parsers();
	
	@Override
	public ArrayList<OrderConResponse> brew(Order order) {
		try {
			ArrayList<Order> orders = new ArrayList<Order>();
			orders.add(order);
			JSONArray commandStreamsJSONFile= writer.writeCommandStreams(orders);
			System.out.println("[JSON-CommandStreams] " + commandStreamsJSONFile);
			Thread.sleep(4000);
			ArrayList<OrderConResponse> responses = null;
			try {
				responses = parser.parseControllerResponse();
			} catch (IOException | ParseException | URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return responses;
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		return null;
	}
	
	

}
