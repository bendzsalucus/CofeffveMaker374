package presentation_layer;

import java.io.Reader;
import java.util.ArrayList;

import business_layer.Condiment;
import business_layer.Drink;

public interface OrderInputParser {
	abstract void parse(Reader OrderInputJSONReader);
	abstract int getOrderID();
	abstract String getDrinkName();
	abstract String getStreet();
	abstract int getZIP();
	abstract ArrayList<Condiment> getCondiments();
	abstract Drink getRecipeWithIngredients();
	abstract Condiment createCondiment(String condimentName);
	abstract Drink createWrapee(String commandStep, String ingredientObject, Drink wrappee);
}
