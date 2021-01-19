import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<Ingredient> extrasList = setUpIngridents();		
		ArrayList<Ingredient> ingreidientsList = setUpExtraIngridents();

		
		ArrayList<Ingredient> order = new ArrayList<Ingredient>();

		System.out.println("New Order. Enter your option");
		Scanner scanny = new Scanner(System.in); 
		
		while(true) {
			String option = scanny.next();
			for(Ingredient i: options) {
				if(i.toString().equals(option)) {
					order.add(i);
				}
			}
			if(option.equals("done")) {
				break;
			}
		}
		
		
		
		//Controller.make(order);
		
		

	}

	private static ArrayList<Ingredient> setUpExtraIngridents() {
		ArrayList<Ingredient> temp = new ArrayList<Ingredient>();
		temp.add(new Ingredient("Milk", "Cow stuff"));
		temp.add(new Ingredient("Bark", "Tree stuff"));
		temp.add(new Ingredient("Cheese", "Goat stuff"));
		temp.add(new Ingredient("Cinnamon", "Challenge stuff"));
		temp.add(new Ingredient("Sugar", "Cane stuff"));

		return null;
	}

	private static ArrayList<Ingredient> setUpIngridents() {
		ArrayList<Ingredient> temp = new ArrayList<Ingredient>();
		temp.add(new Ingredient("Milk", "Cow stuff"));
		temp.add(new Ingredient("Sugar", "Cane stuff"));
		temp.add(new Ingredient("Cinnamon", "Challenge stuff"));
		temp.add(new Ingredient("Milk", "Cow stuff"));
		temp.add(new Ingredient("Milk", "Cow stuff"));

		return null;
	}

}
