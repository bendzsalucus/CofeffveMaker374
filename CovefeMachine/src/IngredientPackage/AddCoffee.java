package IngredientPackage;
import business_layer.Drink;
import business_layer.Ingredient;

public class AddCoffee extends Ingredient {
	public AddCoffee(Drink drink) {
		wrappee = drink;
		drinkName = drink.getDrinkName();
		objectName ="coffee";
		commandStep = "add";
		description = "AddCoffee";
		condiments = drink.getCondiments();
	}
	
	public AddCoffee() {
		objectName ="coffee";
		commandStep = "add";
		description = "AddCoffee";
	}
	
	public Drink wrap(Drink drink) {
		return new AddCoffee(drink);
	}
	
}
