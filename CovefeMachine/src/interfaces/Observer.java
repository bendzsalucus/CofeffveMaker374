package interfaces;

import business_layer.DrinkRecipe;
import business_layer.Order;

public interface Observer {
	
	public void update(Order order);
	public void update(String instruction);
	
}
