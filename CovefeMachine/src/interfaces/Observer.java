package interfaces;

import business_layer.Order;
import presentation_layer.OrderConResponse;

public interface Observer {
	
	public void update(Order order);
	public void update(String instruction);
	public void updateOrder(OrderConResponse response);
	
}
