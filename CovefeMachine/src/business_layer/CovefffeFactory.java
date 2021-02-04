package business_layer;

public class CovefffeFactory {

	private DecafFactory decafFactory;
	private RegularFactory regularFactory;

	public CovefffeFactory() {
		decafFactory = new DecafFactory();
		regularFactory = new RegularFactory();
	}
	
	public DrinkRecipe CovefffeFactory(String chanelle) {
		if(chanelle.contains("decaf")) {
			return decafFactory.makeDrink(chanelle);
		}
		else {
			return regularFactory.makeDrink(chanelle);
		}
	}

}
