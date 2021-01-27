package business_layer;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class mainSandBoxForJSONWriter {

	public static void main(String[] args) {
		
		int orderID = 2;
		int coffee_machine_id = 2;
		int status = 0;
		
		JSONArray appResponseStreams = new JSONArray();
		JSONObject response = new JSONObject();
		JSONObject responseDetail = new JSONObject();
		String status_message = getStatus_message(status);
		String error_message = null;
		
		responseDetail.put("orderID", orderID);
		responseDetail.put("coffee_machine_id", coffee_machine_id);
		responseDetail.put("status", status);
		responseDetail.put("status-message", status_message);
		if(status==1) {
			responseDetail.put("error-message", null);
		}
		
		response.put("user-response", responseDetail);
		appResponseStreams.add(response);
		System.out.println(appResponseStreams);

	}

	private static String getStatus_message(int status) {
		// TODO Auto-generated method stub
		return null;
	}

	private static JSONArray createOptionList(ArrayList<Ingredient> ingredients) {
		ArrayList strings = new ArrayList<String>();
		JSONArray options = new JSONArray();
		for(Ingredient i: ingredients) {
			strings.add(i.getName());
		}
		Map dictionary = countsIngredient(strings);
		
		Iterator<Map.Entry<String, Integer>> itr = dictionary.entrySet().iterator(); 
     
        while(itr.hasNext()) 
        { 
        	 JSONObject option = new JSONObject();
             Map.Entry<String, Integer> entry = itr.next(); 
//             System.out.println("Name = " + entry.getKey() +  
//                                 ", qty = " + entry.getValue()); 
             option.put("Name", entry.getKey());
             option.put("qty", entry.getValue());
             options.add(option);
        }
		return options;
	}

	public static Map countsIngredient(ArrayList<String> strings) {
		 Map<String, Integer> map = new HashMap<String, Integer> ();
		  for (String s:strings) {
		    if (!map.containsKey(s)) {  // first time we've seen this string
		      map.put(s, 1);
		    }
		    else {
		      int count = map.get(s);
		      map.put(s, count + 1);
		    }
		  }
		  return map;
	}
	
}
