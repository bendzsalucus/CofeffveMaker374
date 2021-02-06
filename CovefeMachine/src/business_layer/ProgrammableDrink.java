package business_layer;

import java.util.ArrayList;

public class ProgrammableDrink extends Drink{
	
	public ProgrammableDrink(String drinkName, String description, ArrayList<Condiment> condiments, String drinkType) {
		this.drinkName = drinkName;
		this.description = description;
		this.condiments = condiments;
		this.drinkType = drinkType;
	}
	

}
