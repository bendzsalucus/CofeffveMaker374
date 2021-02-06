package business_layer;

import java.util.ArrayList;


public abstract class Order {
	
	int orderID = -999;
	String street = "Unknown street";
	int ZIP = -999;
	boolean completed = false;
	String errordesc = "Unknown error description";
	int errorcode = -999;
	int coffee_machine_id = -999;
	int controller_id = -999;
	String Requesttype = "Unknown type";
	Drink drink;


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

	public Drink getDrink() {
		return this.drink;
	}
	
	public String getDrinkName() {
		return drink.getDrinkName();
	}

	public void setIngredients(ArrayList<Condiment> ingredients) {
		this.drink.condiments = ingredients;
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

//	public void setRequesttype(String requesttype) {
//		Requesttype = requesttype;
//	}
	
	public int getStatus() {
		if(completed) {
			// 0 mean completed true;
			return 0;
		}else {
			return 1;
		}
	}
	public ArrayList<Condiment> getCondiments(){
		return this.drink.getCondiments();
	}
	

}
