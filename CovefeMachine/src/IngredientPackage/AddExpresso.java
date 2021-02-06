package IngredientPackage;
import business_layer.Drink;
import business_layer.Ingredient;

public class AddExpresso extends Ingredient {

	public AddExpresso(Drink drink) {
		wrappee = drink;
		drinkName = drink.getDrinkName();
		objectName ="expresso";
		commandStep = "add";
		description = "AddExpresso";
		condiments = drink.getCondiments();
	}

	public AddExpresso() {
		objectName ="expresso";
		commandStep = "add";
		description = "AddExpresso";
	}
	
	public Drink wrap(Drink drink) {
		return new AddExpresso(drink);
	}
}
