package IngredientPackage;
import business_layer.Drink;
import business_layer.Ingredient;

public class AddMilk extends Ingredient {

	public AddMilk(Drink drink) {
		wrappee = drink;
		drinkName = drink.getDrinkName();
		objectName ="milk";
		commandStep = "add";
		description = "AddMilk";
		condiments = drink.getCondiments();
	}
	
	public AddMilk() {
		objectName ="milk";
		commandStep = "add";
		description = "AddMilk";
	}
	
	public Drink wrap(Drink drink) {
		return new AddMilk(drink);
	}

}
