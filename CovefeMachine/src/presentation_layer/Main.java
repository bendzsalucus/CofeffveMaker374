package presentation_layer;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.json.simple.parser.ParseException;

import business_layer.*;

public class Main {

	static ArrayList<Server> servers;
	static ArrayList<SimulatedMobileDevice> mobileApps;
	static boolean ordering;
	private static HashMap<String, Ingredient> ingreidientsList;
	private static ArrayList<DrinkRecipe> drinks;
	private static ArrayList<Ingredient> condiments;

	public static void main(String[] args) throws InterruptedException {
		new Orderer();

		new Orderer(2, new ArrayList<Integer>() {
			{
				add(0);
				add(0);
				add(2);
			}
		});
		
		TimeUnit.SECONDS.sleep(6);
		System.out.println();
		
		new Orderer(0, new ArrayList<Integer>() {
			{
			}
		});	
		TimeUnit.SECONDS.sleep(6);
		System.out.println();
		new Orderer(2, new ArrayList<Integer>() {
			{
				add(4);
				add(3);
			}
		});	
		
		TimeUnit.SECONDS.sleep(6);
		System.out.println();
		
		try {
			new Orderer("ParsingJSONFileOrder-inputJSON-test");
		} catch (IOException | ParseException | URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}