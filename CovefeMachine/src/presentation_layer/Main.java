package presentation_layer;

import java.util.ArrayList;
import java.util.HashMap;

import business_layer.DrinkRecipe;
import business_layer.Ingredient;
import business_layer.Server;

public class Main {

	static ArrayList<Server> servers;
	static ArrayList<SimulatedMobileDevice> mobileApps;
	static boolean ordering;
	private static HashMap<String, Ingredient> ingreidientsList;
	private static ArrayList<DrinkRecipe> drinks;
	private static ArrayList<Ingredient> condiments;

	public static void main(String[] args) throws InterruptedException {
//		new Orderer();

		new Orderer("ScarlettSurprise", new ArrayList<Integer>() {
			{
				add(0);
				add(0);
				add(2);
			}
		});

//		TimeUnit.SECONDS.sleep(6);
//		System.out.println();
//		
//		new Orderer(0, new ArrayList<Integer>() {
//			{
//			}
//		});	
//		TimeUnit.SECONDS.sleep(6);
//		System.out.println();
//		new Orderer(2, new ArrayList<Integer>() {
//			{
//				add(4);
//				add(3);
//			}
//		});	
//		
//		TimeUnit.SECONDS.sleep(6);
//		System.out.println();

//		try {
//			new Orderer("ParsingJSONFileOrder-inputJSON-test");
//		} catch (IOException | ParseException | URISyntaxException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
	}

}