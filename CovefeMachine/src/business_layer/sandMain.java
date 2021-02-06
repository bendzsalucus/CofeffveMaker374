package business_layer;

import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class sandMain {

	static String str = "[{\r\n" + "  \"order\": { \"orderID\": 5,\r\n" + "            \"address\": {\r\n"
			+ "                  \"street\": \"3 N. Walnut\",\r\n" + "                  \"ZIP\": 47801\r\n"
			+ "            },\r\n" + "            \"drink\": \"Recipe Drink\",\r\n"
			+ "            \"condiments\": [\r\n" + "                {\"name\": \"Hazelnut\", \"qty\": 2}\r\n"
			+ "            ]\r\n" + "            \"Recipe\": [\r\n"
			+ "				{\"commandstep\": \"add\", \"object\": \"expresso\"},\r\n"
			+ "				{\"commandstep\": \"add\", \"object\": \"expresso\"},\r\n"
			+ "				{\"commandstep\": \"add\", \"object\": \"expresso\"},\r\n"
			+ "				{\"commandstep\": \"add\", \"object\": \"water\"},\r\n"
			+ "				{\"commandstep\": \"mix\"}\r\n" + "			]\r\n" + "}]";

	public static void main(String[] args) throws ParseException {
		JSONParser parser = new JSONParser();

//		parser.parse("[\"order\": {\"orderID\": 5}]");
		System.out.println("[\"order\": {\"orderID\": 5}]");
////		Iterator i = jsonObject.iterator();
////         String name = (String) jsonObject.get(1);
//		while (i.hasNext()) {
//			JSONObject parsedOrder = (JSONObject) i.next();
////         	System.out.println(parsedOrder);
//			JSONObject orderDetail = (JSONObject) parsedOrder.get("order");
//			int orderID = ((Long) orderDetail.get("orderID")).intValue();
//
//			// address
//			JSONObject address = (JSONObject) orderDetail.get("address");
//			String street = (String) address.get("street");
//			int ZIP = ((Long) address.get("ZIP")).intValue();
//
//			// drink
//			String drinkName = (String) orderDetail.get("drink");
//
//			// condiments
//			JSONArray comdiments = (JSONArray) orderDetail.get("condiments");
//			ArrayList<Condiment> ingredients = new ArrayList<Condiment>();
//			if (comdiments != null) {
//				Iterator comdimentIterator = comdiments.iterator();
//				while (comdimentIterator.hasNext()) {
//					System.out.println("here");
//					JSONObject comdiment = (JSONObject) comdimentIterator.next();
//					int quantity = ((Long) comdiment.get("qty")).intValue();
//					String comdimentType = (String) comdiment.get("name");
//					for (int j = 0; j < quantity; j++) {
//					}
//				}
//				System.out.println(ingredients);
//				System.out.println();
//			}
//         	System.out.println(drinkName);
//         	System.out.println(orderDetail.get("condiments"));
//		}
//
//	}
	}
}
