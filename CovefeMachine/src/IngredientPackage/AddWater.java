package IngredientPackage;
import business_layer.Drink;
import business_layer.Ingredient;

public class AddWater extends Ingredient {
	public AddWater(Drink drink) {
		wrappee = drink;
		drinkName = drink.getDrinkName();
		objectName ="water";
		commandStep = "add";
		description = "AddWater";
		condiments = drink.getCondiments();
	}
	
	public AddWater() {
		objectName ="water";
		commandStep = "add";
		description = "AddWater";
	}
	
	public Drink wrap(Drink drink) {
		return new AddWater(drink);
	}
}
