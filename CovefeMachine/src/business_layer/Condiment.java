package business_layer;

import jdk.jfr.Description;

public abstract class Condiment {

	String condimentName = "Unknown condiment";
	String description = "Unknown condiment";


	public String getName() {
		return this.condimentName;
	}

	public String getDescription() {
		return this.description;
	}
	
	@Override
	public String toString() {
		return condimentName;
	}
}


class Bark extends Condiment {

	public Bark() {
		condimentName ="Bark";
		description = "Chocolate Goodness";

	}


}

class Milk extends Condiment {

	public Milk() {
		condimentName ="Milk";
		description = "Comes from a cow";
	}

}

class Caramel extends Condiment {

	public Caramel() {
		condimentName ="Caramel";
		description = "Sweet brown goodness.";
	}


}

class Cinnamon extends Condiment {

	public Cinnamon() {
		condimentName ="Cinnamon";
		description = "Challenge stuff.";
	}

}

class Sugar extends Condiment {

	public Sugar() {
		condimentName ="Sugar";
		description = "Sweeeeeeeet. Made from cane.";
	}


}

class Hazelnut extends Condiment {

	public Hazelnut() {
		condimentName ="Hazelnut";
		description = "Sweeeeeeeet. Made from cane.";
	}


}