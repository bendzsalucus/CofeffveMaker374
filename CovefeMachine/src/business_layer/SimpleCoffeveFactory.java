package business_layer;

public class SimpleCoffeveFactory extends AbstractFactory {

	public DrinkRecipe coffeeRecipe(String chanelle) {

		return new AmericanBlack();
	}

}
