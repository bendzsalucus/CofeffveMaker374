package business_layer;

import java.util.ArrayList;

public class DrinkRecipe {

	ArrayList<Ingredient> ingredient;
	String name;

	public DrinkRecipe(String name, ArrayList<Ingredient> ingrideints) {
		this.ingredient = ingrideints;
	}

}
