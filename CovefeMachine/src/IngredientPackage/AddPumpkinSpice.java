package IngredientPackage;
import business_layer.Drink;
import business_layer.Ingredient;

public class AddPumpkinSpice extends Ingredient {

	public AddPumpkinSpice(Drink drink) {
		wrappee = drink;
		drinkName = drink.getDrinkName();
		objectName ="pumpkin spice";
		commandStep = "add";
		description = "AddPumpkinSpice";
		condiments = drink.getCondiments();
	}
	
	public AddPumpkinSpice() {
		objectName ="pumpkin spice";
		commandStep = "add";
		description = "AddPumpkinSpice";
	}
	
	public Drink wrap(Drink drink) {
		return new AddPumpkinSpice(drink);
	}
}
