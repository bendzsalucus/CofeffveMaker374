package business_layer;

import java.util.ArrayList;

public interface AbstractOrderFactory {
	
	abstract Order createOrder(int orderID, String street, int ZIP, String drinkName, ArrayList<Condiment> condiments);
	abstract Order createOrder(int orderID, String street, int ZIP, String drinkName, ArrayList<Condiment> condiments, Drink drink);
}
