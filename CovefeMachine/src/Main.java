import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<Ingredient> options;
		ArrayList<Ingredient> order;

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

}
