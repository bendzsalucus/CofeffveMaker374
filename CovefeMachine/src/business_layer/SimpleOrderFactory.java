package business_layer;

public class SimpleOrderFactory extends AbstractFactory {

	public DrinkRecipe coffeeRecipe(String chanelle) {

		return new AmericanBlack();
	}

}
