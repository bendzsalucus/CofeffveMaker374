package business_layer;

import java.util.ArrayList;

import presentation_layer.OrderConResponse;

public interface BrewBehavior {
	
	public ArrayList<OrderConResponse> brew(Order order);
}
