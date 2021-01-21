package interfaces;

import business_layer.DrinkRecipe;

public interface Observer {
	
	public void update(DrinkRecipe recipe);
	public void update(String instruction);
	
}
