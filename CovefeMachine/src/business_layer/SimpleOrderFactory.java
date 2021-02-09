package business_layer;

import java.util.ArrayList;

public class SimpleOrderFactory implements AbstractOrderFactory {
	Drinks drinks = new Drinks(); // TODO use singleton pattern here
	ArrayList<Drink> simpleDrinks = drinks.getSimpleDrinks();
	
	@Override
	public Order createOrder(int orderID, String street, int ZIP, String drinkName, ArrayList<Condiment> condiments) {
		// Not supporting Condiments
		for(Drink currentDrink: simpleDrinks) {
			if(currentDrink.getDrinkName().equals(drinkName)) {
				Drink drink = currentDrink;
				Order order = new SimpleOrder(orderID, street, ZIP, drink);
				return order;
			}
		}
		return null;
	}

	@Override
	public Order createOrder(int orderID, String street, int ZIP, String drinkName, ArrayList<Condiment> condiments,
			Drink drink) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
