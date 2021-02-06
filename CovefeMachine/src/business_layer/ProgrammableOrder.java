package business_layer;

import java.util.ArrayList;

public class ProgrammableOrder extends Order{
	
	public ProgrammableOrder(int orderID, String street, int ZIP, Drink drink) {	
		this.orderID = orderID;
		this.street = street;
		this.ZIP = ZIP;
		this.drink = drink;			
		this.Requesttype = "Programmable";
	}

}
