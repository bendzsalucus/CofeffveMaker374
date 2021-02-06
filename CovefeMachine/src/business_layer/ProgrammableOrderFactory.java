package business_layer;
import java.util.ArrayList;

import IngredientPackage.*;

public class ProgrammableOrderFactory implements AbstractOrderFactory {

	public ProgrammableOrderFactory() {
	}

	@Override
	public Order createOrder(int orderID, String street, int ZIP, String drinkName, ArrayList<Condiment> condiments) {
		if (drinkName.equals("Pumpkin Spice")) {
			Drink drink = new PumpkinSpice();
			drink = new AddCoffee(drink);
			drink = new AddPumpkinSpice(drink);
			drink.setCondiments(condiments);
			Order order = new ProgrammableOrder(orderID, street, ZIP, drink);
			return order;
		} else if (drinkName.equals("Large Latte")) {
			Drink drink = new LargeLatte();
			drink = new SteamMilk(drink);
			drink = new SteamMilk(drink);
			drink = new AddExpresso(drink);
			drink = new AddExpresso(drink);
			drink = new Mix(drink);
			drink = new TopWhippedCream(drink);
			drink.setCondiments(condiments);
			Order order = new ProgrammableOrder(orderID, street, ZIP, drink);
			return order;
		} else if (drinkName.equals("Regular Latte")) {
			Drink drink = new RegularLatte();
			drink.setCondiments(condiments);
			drink = new SteamMilk(drink);
			drink = new AddExpresso(drink);
			drink = new TopWhippedCream(drink);
			drink.setCondiments(condiments);
			Order order = new ProgrammableOrder(orderID, street, ZIP, drink);
			return order;
		} else {
			return null;
		}

	}
	
	@Override
	public Order createOrder(int orderID, String street, int ZIP, String drinkName, ArrayList<Condiment> condiments,
			Drink CustomizedDrink) {
		Drink drink = CustomizedDrink;
		drink.setCondiments(condiments);
		Order order = new ProgrammableOrder(orderID, street, ZIP, drink);
		return order;
	}


}
