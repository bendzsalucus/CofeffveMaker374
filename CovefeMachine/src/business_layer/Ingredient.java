package business_layer;

import java.util.ArrayList;

import jdk.jfr.Description;

public abstract class Ingredient extends Drink{
	protected String drinkName = "unknown drink";
	protected String objectName = "Unknown condiment";
	protected String description = "Unknown condiment";
	protected String commandStep = "Unknown commandStep";
	protected String drinkType = "Ingredient";
	protected ArrayList<Condiment> condiments;
	protected Drink wrappee;

	public String getObjectName() {
		return this.objectName;
	}
	
	public String getDrinkName() {
		return this.drinkName;
	}

	public String getDescription() {
		return this.description;
	}
	
	public String getCommandStep() {
		return this.commandStep;
	}
	
	public Drink getWrappee(){
		return this.wrappee;
	}
	
	public abstract Drink wrap(Drink drink);
	
}
