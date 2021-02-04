package business_layer;

import java.util.ArrayList;

public class DrinkRecipe {

	ArrayList<Ingredient> ingredients;
	String name;

	public DrinkRecipe(String name, ArrayList<Ingredient> ingrideints) {
		this.name = name;
		this.ingredients = ingrideints;
	}

	public String getName() {
		return this.name;
	}

	public ArrayList<Ingredient> getIngredients() {
		return this.ingredients;
	}

	public String getIngredientsString() {
		StringBuilder list = new StringBuilder();

		ingredients.forEach(e -> {
			list.append(e.getName());
			list.append(", ");
		});

		return list.substring(0, list.length() - 2);
	}

	public void addExtras(ArrayList<Ingredient> added) {
		ingredients.addAll(added);
	}

}

