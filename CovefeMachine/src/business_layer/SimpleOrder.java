package business_layer;

public class SimpleOrder extends Order{

	public SimpleOrder(int orderID, String street, int ZIP, Drink drink) {	
		this.orderID = orderID;
		this.street = street;
		this.ZIP = ZIP;
		this.drink = drink;			
		this.Requesttype = "Simple";
	}

}

//
//public Order(int orderID, String street, int ZIP, Drink drink) {
//	setCompleted(false);
//	this.setOrderID(orderID);
//	this.setStreet(street);
//	this.setZIP(ZIP);
//	this.drink = drink;
//} 