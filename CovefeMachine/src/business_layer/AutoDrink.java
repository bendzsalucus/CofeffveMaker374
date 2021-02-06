package business_layer;

import java.util.ArrayList;

public class AutoDrink extends Drink{
	public AutoDrink(String drinkName, String description, ArrayList<Condiment> condiments, String drinkType ) {
		this.drinkName = drinkName;
		this.description = description;
		this.condiments = condiments;
		this.drinkType = drinkType;
	}
//	@Override
//	public String getCondimentsString() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	@Override
//	public String getReceipeString() {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
}
