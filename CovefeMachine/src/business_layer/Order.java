package business_layer;

import java.util.ArrayList;


public class Order {
	
	private int orderID;
	private String street;
	private int ZIP;
	private String drinkName;
	private ArrayList<Ingredient> ingredients;
	private boolean completed;
	private int status;
	private String errordesc;
	private int errorcode;
	private int coffee_machine_id;
	private int controller_id;
	private String Requesttype;
	private DrinkRecipe drinkRecipe;
	
	public Order(int orderID, String street, int ZIP, String drinkName, ArrayList<Ingredient> ingredients) {
		setCompleted(false);
		this.setOrderID(orderID);
		this.setStreet(street);
		this.setZIP(ZIP);
		this.drinkRecipe = new DrinkRecipe(drinkName, ingredients);
//		this.setDrinkName(drinkName);
//		this.setIngredients(ingredients);
	} 
	
	
	public void setOrderCompleted() {
		setCompleted(true);
	}

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getZIP() {
		return ZIP;
	}

	public void setZIP(int zIP) {
		ZIP = zIP;
	}

	public DrinkRecipe getDrinkRecipe() {
		return this.drinkRecipe;
	}
	
	public String getDrinkName() {
		return drinkRecipe.getName();
	}

	public void setDrinkName(String drinkName) {
		this.drinkRecipe.name = drinkName;
	}

	public ArrayList<Ingredient> getIngredients() {
		return this.drinkRecipe.getIngredients();
	}

	public void setIngredients(ArrayList<Ingredient> ingredients) {
		this.drinkRecipe.ingredients = ingredients;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
	
	public void setCompleted() {
		this.completed = true;
	}

	public String getErrordesc() {
		return errordesc;
	}

	public void setErrordesc(String errordesc) {
		this.errordesc = errordesc;
	}

	public int getErrorcode() {
		return errorcode;
	}

	public void setErrorcode(int errorcode) {
		this.errorcode = errorcode;
	}

	public int getCoffee_machine_id() {
		return coffee_machine_id;
	}

	public void setCoffee_machine_id(int coffee_machine_id) {
		this.coffee_machine_id = coffee_machine_id;
	}

	public int getController_id() {
		return controller_id;
	}

	public void setController_id(int controller_id) {
		this.controller_id = controller_id;
	}

	public String getRequesttype() {
		return Requesttype;
	}

	public void setRequesttype(String requesttype) {
		Requesttype = requesttype;
	}

	public int getStatus() {
		if(completed) {
			// 0 mean completed true;
			return 0;
		}else {
			return 1;
		}
	}
	

}
