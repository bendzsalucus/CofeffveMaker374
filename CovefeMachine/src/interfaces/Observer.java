package interfaces;

import business_layer.Recipe;

public interface Observer {
	
	public void update(Recipe recipe);
	public void update(String instruction);
	
}
