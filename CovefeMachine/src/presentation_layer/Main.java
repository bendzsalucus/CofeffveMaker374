package presentation_layer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import business_layer.*;

public class Main {

	static ArrayList<Server> servers;
	static ArrayList<SimulatedMobileDevice> mobileApps;
	static boolean ordering;
	private static HashMap<String, Ingredient> ingreidientsList;
	private static ArrayList<DrinkRecipe> drinks;
	private static ArrayList<Ingredient> condiments;

	public static void main(String[] args) {
//		new Orderer();

		new Orderer(2, new ArrayList<Integer>() {
			{
				add(0);
				add(0);
				add(2);
			}
		});

	}
}