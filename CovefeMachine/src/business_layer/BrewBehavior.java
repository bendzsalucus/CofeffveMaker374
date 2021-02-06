package business_layer;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import presentation_layer.OrderConResponse;

public interface BrewBehavior {
	
	abstract ArrayList<OrderConResponse> brew(Order order);
	abstract JSONArray writeCommandStreams(ArrayList<Order> orders);
	abstract JSONObject writeCommandStreams(Order order);
}
