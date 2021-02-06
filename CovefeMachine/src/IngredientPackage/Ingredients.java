package IngredientPackage;
import java.util.ArrayList;

import business_layer.Ingredient;

public class Ingredients {
	private static Ingredients uniqueInstance;
	ArrayList<Ingredient> ingredients;
	private Ingredients() {
		ingredients = new ArrayList<Ingredient>();
		ingredients.add(new AddCoffee());
		ingredients.add(new AddExpresso());
		ingredients.add(new AddMilk());
		ingredients.add(new AddPumpkinSpice());
		ingredients.add(new AddWater());
		ingredients.add(new Mix());
		ingredients.add(new SteamMilk());
		ingredients.add(new TopWhippedCream());
	}
	public static synchronized Ingredients getInstance() {
		if(uniqueInstance == null) {
			uniqueInstance = new Ingredients();
		}
		return uniqueInstance;
	}
	
	public ArrayList<Ingredient> getIngredientList() {
		return ingredients;
	}
}
