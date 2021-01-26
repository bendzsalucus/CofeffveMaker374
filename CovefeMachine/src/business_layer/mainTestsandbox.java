package business_layer;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;



  
public class mainTestsandbox {

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException, URISyntaxException {
		
			String jarLoc;
			String jsonFileName = "json_examples/order-input.json";
			jarLoc = new File(mainTestsandbox.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getPath();
			String[] path = jarLoc.split("\\\\");
			String containerLoc = "";
			for(int i =0; i < path.length -1; i++) {
				containerLoc += path[i];
				containerLoc += "\\";
			}
			
			String asLocation = containerLoc.concat(jsonFileName);
			File asFile = new File(asLocation);
			
		 	Object obj = new JSONParser().parse(new FileReader(asFile)); 
	        // typecasting obj to JSONObject 
	        JSONObject jo = (JSONObject) obj; 
	          
	        // getting firstName and lastName 
	        String orderID = (String) jo.get("orderID"); 
	        String address = (String) jo.get("address"); 
	        String street = (String) jo.get("street"); 
	        String ZIP = (String) jo.get("ZIP"); 
//	        String drink = (String) jo.get("drink"); 
//	        String address = (String) jo.get("condiments"); 
//	        
//	        System.out.println(firstName); 
//	        System.out.println(lastName); 
//	          
//	        // getting age 
//	        long age = (long) jo.get("age"); 
//	        System.out.println(age); 
//	          
//	        
//	        // getting address 
//	        Map address = ((Map)jo.get("address")); 
//	          
//	        // iterating address Map 
//	        Iterator<Map.Entry> itr1 = address.entrySet().iterator(); 
//	        while (itr1.hasNext()) { 
//	            Map.Entry pair = itr1.next(); 
//	            System.out.println(pair.getKey() + " : " + pair.getValue()); 
//	        } 
//	        
//	        
//	        
//	        // getting address 
//	        Map address = ((Map)jo.get("address")); 
//	          
//	        // iterating address Map 
//	        Iterator<Map.Entry> itr1 = address.entrySet().iterator(); 
//	        while (itr1.hasNext()) { 
//	            Map.Entry pair = itr1.next(); 
//	            System.out.println(pair.getKey() + " : " + pair.getValue()); 
//	        } 
//	          
//	        // getting phoneNumbers 
//	        JSONArray ja = (JSONArray) jo.get("phoneNumbers"); 
//	          
//	        // iterating phoneNumbers 
//	        Iterator itr2 = ja.iterator(); 
//	          
//	        while (itr2.hasNext())  
//	        { 
//	            itr1 = ((Map) itr2.next()).entrySet().iterator(); 
//	            while (itr1.hasNext()) { 
//	                Map.Entry pair = itr1.next(); 
//	                System.out.println(pair.getKey() + " : " + pair.getValue()); 
//	            } 
//	        } 

	}

}

