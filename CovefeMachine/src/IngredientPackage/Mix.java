package IngredientPackage;
import business_layer.Drink;
import business_layer.Ingredient;

public class Mix extends Ingredient {
	public Mix(Drink drink) {
		wrappee = drink;
		drinkName = drink.getDrinkName();
		objectName ="N/A";
		commandStep = "mix";
		description = "Mix";
		condiments = drink.getCondiments();
	}
	
	public Mix() {
		objectName ="N/A";
		commandStep = "mix";
		description = "Mix";
	}
	
	public Drink wrap(Drink drink) {
		return new Mix(drink);
	}
}
