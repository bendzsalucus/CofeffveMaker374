package presentation_layer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;

import business_layer.Condiment;
import business_layer.Server;
import business_layer.Usual;

public class Main {

	static ArrayList<Server> servers;
	static ArrayList<SimulatedMobileDevice> mobileApps;
	static boolean ordering;
	private static HashMap<String, Condiment> ingreidientsList;
	private static ArrayList<Condiment> condiments;
	private static Reader UC4OrderInputJSONReader;
	public static Usual AustinUsualSlot; 

	public static void main(String[] args) throws InterruptedException, FileNotFoundException, URISyntaxException, IOException {
		init();
//		Orderer orderTakerMode = new Orderer("orderTakerMode");
//		orderTakerMode.inputOrderInputFromJSONString(UC4OrderInputJSONReader);
		
		Orderer currentOrderer = new Orderer();
		ArrayList<String> AustinUsualDrinks = new ArrayList<String>();
		AustinUsualDrinks.add("Large Latte");
		AustinUsualDrinks.add("Regular Latte");
		Usual AustinUsual =  currentOrderer.createUsual(AustinUsualDrinks, 123456, "5611 Hazen St", 77081);
		setCommand(AustinUsual);

//		new Orderer("Scarlett Surprise", new ArrayList<Integer>() {
//			{
//				add(0);
//				add(0);
//				add(2);
//			}
//		});
		

//		new Orderer("Large Latte", new ArrayList<Integer>() {
//			{
//				add(0);
//				add(0);
//				add(2);
//			}
//		});

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

	private static void setCommand(Usual AustinUsual) {
		// TODO Auto-generated method stub.
		AustinUsualSlot = AustinUsual; 
		
	}

	private static void init() throws URISyntaxException, FileNotFoundException, IOException {
		String jarLoc;
		String jsonFileName = "json_examples/UC4Testing.json";
		jarLoc = new File(ResponseProcessor.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getPath();
		String[] path = jarLoc.split("\\\\");
		String containerLoc = "";
		for(int i =0; i < path.length -1; i++) {
			containerLoc += path[i];
			containerLoc += "\\";
		}
		String asLocation = containerLoc.concat(jsonFileName);
        try (Reader reader = new FileReader(asLocation)) {
        	UC4OrderInputJSONReader = new FileReader(asLocation);
        }
	}
}