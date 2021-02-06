package business_layer;

import java.util.ArrayList;

public abstract class Drink {
	String drinkName = "unknown drink";
	String description = "unknown description";
	String drinkType = "Ingredient";
	ArrayList<Condiment> condiments = new ArrayList<Condiment>();
	
	public String getDrinkName() {
		return this.drinkName;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public ArrayList<Condiment> getCondiments(){
		return this.condiments;
	}
	
	public void setCondiments(ArrayList<Condiment> condiments) {
		if(condiments!=null) {
			this.condiments = condiments;
		}
	}
	
	public void addMoreCondiments(ArrayList<Condiment> condiments) {
		if(condiments.size()!=0) {
			for(Condiment condiment: condiments) {
				this.condiments.add(condiment);
			}
		}	
	}
	public String getDrinkType() {
		return this.drinkType;
	}

//	public abstract String getCondimentsString();
//	public abstract String getReceipeString();
}