package presentation_layer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import business_layer.*;

public class Main {
	
	static ArrayList<Server> servers;
	static ArrayList<SimulatedMobileDevice> mobileApps;

	public static void main(String[] args) {
		
		HashMap<String, Ingredient> ingreidientsList = setUpExtraIngridents();
		ArrayList<DrinkRecipe> drinks = setUpDrinks(ingreidientsList);		

		
		ArrayList<Ingredient> order = new ArrayList<Ingredient>();

		System.out.println("Menu:________________________________");
		
		drinks.forEach(e ->{
			System.out.println(e.getName() + " " + e.getIngredientsString());
			
		});
		
		
//		Scanner scanny = new Scanner(System.in); 
		
//		while(true) {
//			String option = scanny.next();
//			for(Ingredient i: options) {
//				if(i.toString().equals(option)) {
//					order.add(i);
//				}
//			}
//			if(option.equals("done")) {
//				break;
//			}
//		}
		
		
		
		//Controller.make(order);
		
		

	}

	private static HashMap<String, Ingredient> setUpExtraIngridents() {
		HashMap<String, Ingredient> temp = new HashMap<String, Ingredient>();
		temp.put("Milk" , (new Ingredient("Milk", "Cow stuff"))); 
		temp.put("Bark" , (new Ingredient("Bark", "Tree stuff"))); 
		temp.put("Caramel" , (new Ingredient("Caramel", "Sweet Brown Stuff"))); 
		temp.put("Cinnamon" , (new Ingredient("Cinnamon", "Challenge stuff"))); 
		temp.put("Sugar" , (new Ingredient("Sugar", "Cane stuff"))); 
		temp.put("American Beans" , (new Ingredient("American Beans", "Beans grown in America"))); 
		temp.put("Brazilian Beans" , (new Ingredient("Brazilian Beans", "Beans from Brazil"))); 
		temp.put("Amazon Beans" , (new Ingredient("Amazon Beans", "Prime Beans"))); 
		return temp;
	}

	private static ArrayList<DrinkRecipe> setUpDrinks(HashMap<String, Ingredient> ingreidientsList) {
		ArrayList<DrinkRecipe> drinks = new ArrayList<DrinkRecipe>();
		
		ArrayList<Ingredient> temp = new ArrayList<Ingredient>();
		temp.add(ingreidientsList.get("American Beans"));
		drinks.add(new DrinkRecipe("American Black Coffee", temp));

		temp.clear();
		temp.add(ingreidientsList.get("American Beans"));
		temp.add(ingreidientsList.get("Bark"));
		temp.add(ingreidientsList.get("Milk"));
		drinks.add(new DrinkRecipe("Mocha", temp));

		temp.clear();
		temp.add(ingreidientsList.get("American Beans"));
		temp.add(ingreidientsList.get("Sugar"));
		temp.add(ingreidientsList.get("Milk"));
		temp.add(ingreidientsList.get("Bark"));
		drinks.add(new DrinkRecipe("Scarlett Surprise", temp));
		
		temp.clear();
		temp.add(ingreidientsList.get("Milk"));
		temp.add(ingreidientsList.get("Sugar"));
		temp.add(ingreidientsList.get("Cinnamon"));
		drinks.add(new DrinkRecipe("Cold Brew", temp));
		
		temp.clear();
		temp.add(ingreidientsList.get("Milk"));
		temp.add(ingreidientsList.get("Sugar"));
		temp.add(ingreidientsList.get("Cinnamon"));
		temp.add(ingreidientsList.get("Amazon Beans"));
		drinks.add(new DrinkRecipe("Caramel Macchiato", temp));
		
		temp.clear();
		temp.add(ingreidientsList.get("Milk"));
		temp.add(ingreidientsList.get("Sugar"));
		temp.add(ingreidientsList.get("Caramel"));
		temp.add(ingreidientsList.get("Amazon Beans"));
		drinks.add(new DrinkRecipe("Doice Skinny Latte", temp));

		return drinks;
	}

}























