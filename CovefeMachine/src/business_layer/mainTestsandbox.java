package business_layer;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import presentation_layer.Parsers;

import java.io.Reader;

  
public class mainTestsandbox {

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException, URISyntaxException {
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
            	
            	//updateOrder triger the update method in server class with response from the controller 
            	Server.updateOrder(orderID, status, errordesc, errorcode);
            }
	}
        System.out.println("[order-input] Parsing Done");
   
	        
	}
}

