package business_layer;

import java.util.ArrayList;
import java.util.Arrays;

public class Drinks {

	private ArrayList<DrinkRecipe> drinklist;
	private ArrayList<Ingredient> ingridients;

	public Drinks() {
		this.drinklist = new ArrayList<DrinkRecipe>();
		this.drinklist.add(new ScarlettSurprise());
		this.drinklist.add(new ColdBrew());
		this.drinklist.add(new Mocha());
		this.drinklist.add(new CaramelMacchiato());
		this.drinklist.add(new DoiceSkinnyLatte());
		this.drinklist.add(new AmericanBlack());
		this.drinklist.add(new RegularLatte());

		// MOVE ME INTO DRINKS. Sitting here cause modifications happening in drinks.
		this.ingridients = new ArrayList<Ingredient>();
		this.ingridients.add(new Milk());
		this.ingridients.add(new Bark());
		this.ingridients.add(new Caramel());
		this.ingridients.add(new Cinnamon());
		this.ingridients.add(new Sugar());

	}

	public ArrayList<DrinkRecipe> getDrinkList() {
		return this.drinklist;
	}

	public ArrayList<Ingredient> getIngridients() {
		return this.ingridients;
	}
}

class ScarlettSurprise extends DrinkRecipe {
	public ScarlettSurprise() {
		super("Scarlett Surprise", new ArrayList<Ingredient>(Arrays.asList(new Sugar(), new Milk(), new Bark())));
	}
}

class RegularLatte extends DrinkRecipe{
	public RegularLatte() {
		super("Regular Latte", null);
	}
}

class ColdBrew extends DrinkRecipe {
	public ColdBrew() {
		super("Cold Brew", new ArrayList<Ingredient>(Arrays.asList(new Milk(), new Sugar(), new Cinnamon())));
	}
}

class Mocha extends DrinkRecipe {
	public Mocha() {
		super("Mocha", new ArrayList<Ingredient>(Arrays.asList(new Sugar(), new Milk(), new Bark())));
	}
}

class CaramelMacchiato extends DrinkRecipe {
	public CaramelMacchiato() {
		super("Caramel Macchiato", new ArrayList<Ingredient>(Arrays.asList(new Milk(), new Caramel(), new Cinnamon())));
	}
}

class DoiceSkinnyLatte extends DrinkRecipe {
	public DoiceSkinnyLatte() {
		super("Doice Skinny Latte", new ArrayList<Ingredient>(Arrays.asList(new Milk(), new Sugar(), new Caramel())));
	}
}

class AmericanBlack extends DrinkRecipe {
	public AmericanBlack() {
		super("American Black", new ArrayList<Ingredient>());
	}
}