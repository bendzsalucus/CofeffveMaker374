package business_layer;

public abstract class Ingredient {

	private String name;
	private String description;
	protected Ingredient wrappee;

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

	public abstract void nextIngredient(Ingredient i);

	public void getProcessString() {
		if (this.wrappee != null){
			System.out.println(this.wrappee.processName());
			}
		System.out.println(this.getName());

	}
	
//	 "command": {
//	    "controller_id": 2,
//	    "coffee_machine_id": 1,
//	    "orderID": 1,
//	    "DrinkName": "Large Latte",
//	    "Requesttype": "Programmable",
//	    "Options:": [
//	        {"Name": "hazelnut", "qty": 4}
//	    ]
//	    "Recipe": [
//	        {"commandstep": "steam", "object": "milk"},
//	        {"commandstep": "steam", "object": "milk"},
//	        {"commandstep": "add", "object": "expresso"},
//	        {"commandstep": "add", "object": "expresso"},
//	        {"commandstep": "mix"},
//	        {"commandstep": "top", "object": "whipped cream"}
//	    ]
//	}
	
	

	private String processName() {
		if (this.wrappee != null){
			return wrappee.processName() + this.getName();}
		return this.getName(); 
		
	}

	class Bark extends Ingredient {

		public Bark() {
			super("Bark", "Chocolate Goodness.");
		}

		@Override
		public void nextIngredient(Ingredient i) {
			super.wrappee = i;

		}

	}

	class Milk extends Ingredient {

		public Milk() {
			super("Milk", "Comes from a cow.");
		}

		@Override
		public void nextIngredient(Ingredient i) {
			super.wrappee = i;

		}

	}

	class Caramel extends Ingredient {

		public Caramel() {
			super("Caramel", "Sweet brown goodness.");
		}

		@Override
		public void nextIngredient(Ingredient i) {
			super.wrappee = i;

		}

	}

	class Cinnamon extends Ingredient {

		public Cinnamon() {
			super("Cinnamon", "Challenge stuff.");
		}

		@Override
		public void nextIngredient(Ingredient i) {
			super.wrappee = i;

		}

	}

	class Sugar extends Ingredient {

		public Sugar() {
			super("Sugar", "Sweeeeeeeet. Made from cane.");
		}

		@Override
		public void nextIngredient(Ingredient i) {
			super.wrappee = i;

		}

	}
}