package business_layer;

import java.util.ArrayList;

import com.github.cliftonlabs.json_simple.*;


public class Order {
	
	int orderID;
	String street;
	int ZIP;
	String drinkName;
	ArrayList<Ingredient> ingredients;
	boolean completed;
	
	public Order(int orderID, String address, int ZIP, String drinkName, ArrayList<Ingredient> ingredients) {
		completed = false;
		this.orderID = orderID;
		this.street = street;
		this.ZIP = ZIP;
		this.drinkName = drinkName;
		this.ingredients = ingredients;
	} 
	
	public void setOrderCompleted() {
		completed = true;
	}
	
//	Method below is for parsing order for creating order class in server class; 
	
	public Order useOrderInput() {
		
	}
	

}
