package business_layer;

public class Ingredient {

	private String name;
	private String description;
	private Ingredient wrappee; 

	public Ingredient(String name, String desciption) {
		this.name = name;
		this.description = desciption;
	}

	public String getName() {
		return this.name;
	}

	public String getDescription() {
		return this.description;
	}
}

class Bark extends Ingredient {

	public Bark() {
		super("Bark", "Chocolate Goodness.");
	}

}

class Milk extends Ingredient {

	public Milk() {
		super("Milk", "Comes from a cow.");
	}

}


class Caramel extends Ingredient {

	public Caramel() {
		super("Caramel", "Sweet brown goodness.");
	}

}

class Cinnamon extends Ingredient {

	public Cinnamon() {
		super("Cinnamon", "Challenge stuff.");
	}

}

class Sugar extends Ingredient {

	public Sugar() {
		super("Sugar", "Sweeeeeeeet. Made from cane.");
	}

}