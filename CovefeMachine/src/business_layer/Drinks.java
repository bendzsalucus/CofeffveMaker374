package business_layer;

import java.util.ArrayList;
import java.util.Arrays;

public class Drinks {

	private ArrayList<Drink> drinklist;
	private ArrayList<Condiment> condiments;

	public Drinks() {
		this.drinklist = new ArrayList<Drink>();
		this.drinklist.add(new ScarlettSurprise());
		this.drinklist.add(new ColdBrew());
		this.drinklist.add(new Mocha());
		this.drinklist.add(new CaramelMacchiato());
		this.drinklist.add(new DoiceSkinny());
		this.drinklist.add(new Americano());
		this.drinklist.add(new RegularLatte());
		this.drinklist.add(new LargeLatte());
		this.drinklist.add(new PumpkinSpice());
		this.drinklist.add(new Expresso());



		// MOVE ME INTO DRINKS. Sitting here cause modifications happening in drinks.
		this.condiments = new ArrayList<Condiment>();
		this.condiments.add(new Milk());
		this.condiments.add(new Bark());
		this.condiments.add(new Caramel());
		this.condiments.add(new Cinnamon());
		this.condiments.add(new Sugar());
		this.condiments.add(new Hazelnut());
		
	}
	
	public Drink getRecipeDrink() {
		return new RecipeDrink();
	}

	public ArrayList<Drink> getDrinkList() {
		return this.drinklist;
	}

	public ArrayList<Condiment> getCondiments() {
		return this.condiments;
	}

	public ArrayList<Drink> getSimpleDrinks() {
		ArrayList<Drink> drinks = new ArrayList<Drink>();
		for(Drink currentDrink: drinklist) {
			if(currentDrink.getDrinkType().equals("Simple")) {
				drinks.add(currentDrink);
			}
		}
		return drinks;
	}

	public ArrayList<Drink> getAutoDrinks() {
		ArrayList<Drink> drinks = new ArrayList<Drink>();
		for(Drink currentDrink: drinklist) {
			if(currentDrink.getDrinkType().equals("Automated")) {
				drinks.add(currentDrink);
			}
		}
		return drinks;
	}

	public ArrayList<Drink> getProgrammableDrinks() {
		ArrayList<Drink> drinks = new ArrayList<Drink>();
		for(Drink currentDrink: drinklist) {
			if(currentDrink.getDrinkType().equals("Programmable")) {
				drinks.add(currentDrink);
			}
		}
		return drinks;
	}
}

class ScarlettSurprise extends AutoDrink {
	public ScarlettSurprise() {
		super("Scarlett Surprise", "Scarlett Surprise Auto describtion",
				new ArrayList<Condiment>(Arrays.asList(new Sugar(), new Milk(), new Bark()))
				,"Automated");
	}
}

class RegularLatte extends ProgrammableDrink {
	public RegularLatte() {
		super("Regular Latte", "Regular Latte Description", new ArrayList<Condiment>(), "Programmable");
	}
}

class LargeLatte extends ProgrammableDrink {
	public LargeLatte() {
		super("Large Latte", "Large Latte Description", new ArrayList<Condiment>(), "Programmable");
	}
}

class PumpkinSpice extends ProgrammableDrink {
	public PumpkinSpice() {
		super("Pumpkin Spice", "programmable description", new ArrayList<Condiment>(), "Programmable");
	}
}

class RecipeDrink extends ProgrammableDrink {
	public RecipeDrink() {
		super("Recipe Drink", "programmable description", new ArrayList<Condiment>(), "Programmable");
	}
}

class ColdBrew extends AutoDrink {
	public ColdBrew() {
		super("Cold Brew", "Auto description",
				new ArrayList<Condiment>(Arrays.asList(new Milk(), new Sugar(), new Cinnamon())),"Automated");
	}
}

class Mocha extends AutoDrink {
	public Mocha() {
		super("Mocha", "Auto description",
				new ArrayList<Condiment>(Arrays.asList(new Sugar(), new Milk(), new Bark())),"Automated");
	}
}

class CaramelMacchiato extends AutoDrink {
	public CaramelMacchiato() {
		super("Caramel Macchiato", "Caramel Macchiato Auto Description",
				new ArrayList<Condiment>(Arrays.asList(new Milk(), new Caramel(), new Cinnamon())),"Automated");
	}
}

class DoiceSkinny extends AutoDrink {
	public DoiceSkinny() {
		super("Doice Skinny", "Doice Skinny Auto Description",
				new ArrayList<Condiment>(Arrays.asList(new Milk(), new Sugar(), new Caramel())),"Automated");
	}
}

class Americano extends SimpleDrink {
	public Americano() {
		super("Americano", "This is Americano description", "Simple");
	}
}

class Expresso extends SimpleDrink {
	public Expresso() {
		super("Expresso", "Expresso describtion", "Simple");
	}
}