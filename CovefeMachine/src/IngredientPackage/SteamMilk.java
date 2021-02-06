package IngredientPackage;
import business_layer.Drink;
import business_layer.Ingredient;

public class SteamMilk extends Ingredient {

	public SteamMilk(Drink drink) {
		wrappee = drink;
		drinkName = drink.getDrinkName();
		objectName ="milk";
		commandStep = "steam";
		description = "SteamMilk";
		condiments = drink.getCondiments();
	}
	
	public SteamMilk() {
		objectName ="milk";
		commandStep = "steam";
		description = "SteamMilk";
	}
	
	public Drink wrap(Drink drink) {
		return new SteamMilk(drink);
	}
}