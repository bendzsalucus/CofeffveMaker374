package business_layer;


public class Drinks {
	private Bark bark;
	private Milk milk;
	private Caramel caramel;
	private Cinnamon cinnamon;
	private Sugar sugar;

	public Drinks() {
		this.bark = new Bark();
		this.milk = new Milk();
		this.caramel = new Caramel();
		this.cinnamon = new Cinnamon();
		this.sugar = new Sugar();

	}
}





class ScarlettSurprise extends DrinkRecipe {

	public ScarlettSurprise() {
		super("Scarlett Surprise", ingrideints);
	}
	
	
}