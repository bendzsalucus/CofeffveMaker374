package business_layer;

public class AdvancedFactory extends AbstractFactory {

	@Override
	public DrinkRecipe coffeeRecipe(String chanelle) {
		if (chanelle.equals("ScarlettSurprise")) {
			return new ScarlettSurprise();
		} else if (chanelle.equals("ColdBrew")) {
			return new ColdBrew();
		} else if (chanelle.equals("CaramelMacciato")) {
			return new CaramelMacchiato();
		} else if (chanelle.equals("Mocha")) {
			return new Mocha();
		} else if (chanelle.equals("DoiceSkinnyLatte")) {
			return new DoiceSkinnyLatte();
		} else {
			return new AmericanBlack();
		}
	}

}
