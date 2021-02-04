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

	public abstract void setWrappee(Ingredient i);

	public void initialPrint() {
		if (this.wrappee != null){
			System.out.println(this.wrappee.doThisPrint());
			}
		System.out.println(this.getName());

	}

	private String doThisPrint() {
		if (this.wrappee != null){
			return wrappee.getName();}
		return null; 
		
	}

	class Bark extends Ingredient {

		public Bark() {
			super("Bark", "Chocolate Goodness.");
		}

		@Override
		public void setWrappee(Ingredient i) {
			super.wrappee = i;

		}

	}

	class Milk extends Ingredient {

		public Milk() {
			super("Milk", "Comes from a cow.");
		}

		@Override
		public void setWrappee(Ingredient i) {
			super.wrappee = i;

		}

	}

	class Caramel extends Ingredient {

		public Caramel() {
			super("Caramel", "Sweet brown goodness.");
		}

		@Override
		public void setWrappee(Ingredient i) {
			super.wrappee = i;

		}

	}

	class Cinnamon extends Ingredient {

		public Cinnamon() {
			super("Cinnamon", "Challenge stuff.");
		}

		@Override
		public void setWrappee(Ingredient i) {
			super.wrappee = i;

		}

	}

	class Sugar extends Ingredient {

		public Sugar() {
			super("Sugar", "Sweeeeeeeet. Made from cane.");
		}

		@Override
		public void setWrappee(Ingredient i) {
			super.wrappee = i;

		}

	}
}