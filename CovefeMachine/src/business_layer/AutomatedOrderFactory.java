package business_layer;

import java.util.ArrayList;

public class AutomatedOrderFactory implements AbstractOrderFactory {
	Drinks drinks = new Drinks(); // TODO use singleton pattern here
	ArrayList<Drink> autoDrinks = drinks.getAutoDrinks();

	@Override
	public Order createOrder(int orderID, String street, int ZIP, String drinkName, ArrayList<Condiment> condiments) {
		// TODO Auto-generated method stub
		for(Drink currentDrink: autoDrinks) {
			if(currentDrink.getDrinkName().equals(drinkName)) {
				Drink drink = currentDrink;
				drink.addMoreCondiments(condiments);
				Order order = new AutoOrder(orderID, street, ZIP, drink);
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
