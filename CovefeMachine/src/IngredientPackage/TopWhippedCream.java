package IngredientPackage;
import business_layer.Drink;
import business_layer.Ingredient;

public class TopWhippedCream extends Ingredient {

	public TopWhippedCream(Drink drink) {
		wrappee = drink;
		drinkName = drink.getDrinkName();
		objectName ="whipped cream";
		commandStep = "top";
		description = "TopWhippedCream";
		condiments = drink.getCondiments();
	}
	
	public TopWhippedCream() {
		objectName ="whipped cream";
		commandStep = "top";
		description = "TopWhippedCream";
	}
	
	public Drink wrap(Drink drink) {
		return new TopWhippedCream(drink);
	}
}