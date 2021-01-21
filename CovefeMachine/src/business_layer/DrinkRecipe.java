package business_layer;

import java.util.ArrayList;

public class DrinkRecipe {

	ArrayList<Ingredient> ingredient;
	String name;

	public DrinkRecipe(String name, ArrayList<Ingredient> ingrideints) {
		this.name = name;
		this.ingredient = ingrideints;
	}

	public String getName() {
		return this.name;
	}

	public ArrayList<Ingredient> getIngredients() {
		return this.ingredient;
	}

	public String getIngredientsString() {
		StringBuilder list = new StringBuilder();

		ingredient.forEach(e -> {
			list.append(e.getName());
			list.append(", ");
		});
		
		return list.substring(0, list.length() -2);
	}

}
