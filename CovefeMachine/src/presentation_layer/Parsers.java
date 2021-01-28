package presentation_layer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import business_layer.Ingredient;
import business_layer.Order;
import business_layer.Server;
import business_layer.mainTestsandbox;
import interfaces.Observer;

public class Parsers {

	public Parsers() {
		
	}
	
	
	public ArrayList<Order> parseOrderInput() throws FileNotFoundException, IOException, ParseException, URISyntaxException{
		String jarLoc;
		String jsonFileName = "json_examples/order-input.json";
		jarLoc = new File(Parsers.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getPath();
		String[] path = jarLoc.split("\\\\");
		String containerLoc = "";
		for(int i =0; i < path.length -1; i++) {
			containerLoc += path[i];
			containerLoc += "\\";
		}
		
		String asLocation = containerLoc.concat(jsonFileName);
//		File asFile = new File(asLocation);
        JSONParser parser = new JSONParser();
        ArrayList<Order> newOrders = new ArrayList<Order>();

        try (Reader reader = new FileReader(asLocation)) {
        	System.out.println("[order-input] Parsing Starts");
            JSONArray jsonObject = (JSONArray) parser.parse(reader);
            Iterator i = jsonObject.iterator();
//            String name = (String) jsonObject.get(1);
            while(i.hasNext()) {
            	JSONObject parsedOrder = (JSONObject) i.next();
//            	System.out.println(parsedOrder);
            	JSONObject orderDetail = (JSONObject) parsedOrder.get("order");
            	int orderID = ((Long) orderDetail.get("orderID")).intValue();
            	
            	//address
            	JSONObject address = (JSONObject) orderDetail.get("address");
            	String street = (String) address.get("street");
            	int ZIP = ((Long) address.get("ZIP")).intValue();
            	
            	//drink
            	String drinkName = (String) orderDetail.get("drink");
            	
            	//condiments
            	JSONArray comdiments = (JSONArray) orderDetail.get("condiments");
            	ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
            	if(comdiments!=null) {
            		Iterator comdimentIterator = comdiments.iterator();
	            	while(comdimentIterator.hasNext()) {
	            		System.out.println("here");
	            		JSONObject comdiment = (JSONObject) comdimentIterator.next();
		            	int quantity = ((Long) comdiment.get("qty")).intValue();
		            	String comdimentType = (String) comdiment.get("name");
		            	for(int j = 0; j <quantity; j++) {
			            	ingredients.add(new Ingredient(comdimentType, null));
		            	}
	            	}
            		System.out.println(ingredients);
	            	System.out.println();
            	}
            	Order newOrder = new Order(orderID, street, ZIP, drinkName, ingredients);
            	newOrders.add(newOrder);
//            	System.out.println(drinkName);
//            	System.out.println(orderDetail.get("condiments"));
            }
	}
        System.out.println("[order-input] Parsing Done");
		return newOrders;
}
	
	public ArrayList<OrderConResponse> parseControllerResponse() throws FileNotFoundException, IOException, ParseException, URISyntaxException{

		int errorcode = -99;
		String jarLoc;
		String jsonFileName = "json_examples/controller-response.json";
		jarLoc = new File(Parsers.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getPath();
		String[] path = jarLoc.split("\\\\");
		String containerLoc = "";
		for(int i =0; i < path.length -1; i++) {
			containerLoc += path[i];
			containerLoc += "\\";
		}
		ArrayList<OrderConResponse> responses = new ArrayList<OrderConResponse>();
		String asLocation = containerLoc.concat(jsonFileName);
//		File asFile = new File(asLocation);
        JSONParser parser = new JSONParser();
        try (Reader reader = new FileReader(asLocation)) {
        	System.out.println("[controller response] Parsing Starts");
            JSONArray jsonObject = (JSONArray) parser.parse(reader);
            Iterator i = jsonObject.iterator();
//            String name = (String) jsonObject.get(1);
            while(i.hasNext()) {
            	JSONObject parsedOrder = (JSONObject) i.next();
//            	System.out.println(parsedOrder);
            	JSONObject controllerResponse = (JSONObject) parsedOrder.get("drinkresponse");
            	int orderID = ((Long) controllerResponse.get("orderID")).intValue();
            	int status = ((Long) controllerResponse.get("status")).intValue();
            	String errordesc = (String) controllerResponse.get("errordesc");
            	if((Long) controllerResponse.get("errorcode")!= null) {
                	errorcode = ((Long) controllerResponse.get("errorcode")).intValue();
            	}
            	System.out.println(orderID+" "+ status +" "+ errordesc +" "+ errorcode);
            	
            	//updateOrder trigger the update method in server class with response from the controller 
            	//return int, int, string, int; last two could be null
            	OrderConResponse orderResposne = new OrderConResponse(orderID, status, errordesc, errorcode);
            	responses.add(orderResposne);
//            	((Server) server).updateOrder(orderID, status, errordesc, errorcode);
            }
	}
        System.out.println("[order-input] Parsing Done");
        return responses;
}
	
	
}
