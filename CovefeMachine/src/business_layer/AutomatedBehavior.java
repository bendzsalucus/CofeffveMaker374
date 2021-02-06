package business_layer;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import presentation_layer.OrderConResponse;
import presentation_layer.Parsers;

public class AutomatedBehavior implements BrewBehavior {
	Parsers parser = new Parsers();
	String controllerType = "Automated";

	public AutomatedBehavior() {
	}

	@Override
	public ArrayList<OrderConResponse> brew(Order order) {
		try {
			JSONObject commandStreamsJSONFile = writeCommandStreams(order);
			System.out.println("[AutomatedBehavior] " + commandStreamsJSONFile);
			Thread.sleep(4000);
			ArrayList<OrderConResponse> responses = null;
			try {
				responses = parser.parseControllerResponse();
			} catch (IOException | ParseException | URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return responses;
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public JSONObject writeCommandStreams(Order order) {
		int controller_id = order.getController_id();
		int coffee_machine_id = order.getCoffee_machine_id();
		int orderID = order.getOrderID();
		String DrinkName = order.getDrinkName();
		String Requesttype = order.getRequesttype();
		ArrayList<Condiment> condiments = order.getCondiments();
		JSONObject command = new JSONObject();
		JSONObject commandDetail = new JSONObject();
		commandDetail.put("controller_id", controller_id);
		commandDetail.put("coffee_machine_id", coffee_machine_id);
		commandDetail.put("orderID", orderID);
		System.out.println("[AutomatedBehavior] Sending Command for " + DrinkName + " OrderID: " + orderID);
		commandDetail.put("DrinkName", DrinkName);
		commandDetail.put("Requesttype", Requesttype);

		if (condiments.size() != 0) {
			JSONArray optionList = createOptionList(condiments);
			commandDetail.put("Options", optionList);
		}
		command.put("command", commandDetail);
		return command;
	}

	@SuppressWarnings("unchecked")
	public JSONArray writeCommandStreams(ArrayList<Order> orders) {
		JSONArray commandStreams = new JSONArray();
		for (Order order : orders) {
			JSONObject command = writeCommandStreams(order);
			commandStreams.add(command);
		}
//		System.out.println(commandStreams);
		return commandStreams;
	}

	private static JSONArray createOptionList(ArrayList<Condiment> ingredients) {
		ArrayList<String> strings = new ArrayList<String>();
		JSONArray options = new JSONArray();
		for (Condiment i : ingredients) {
			strings.add(i.getName());
		}
		Map dictionary = countsIngredient(strings);

		Iterator<Map.Entry<String, Integer>> itr = dictionary.entrySet().iterator();

		while (itr.hasNext()) {
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
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (String s : strings) {
			if (!map.containsKey(s)) { // first time we've seen this string
				map.put(s, 1);
			} else {
				int count = map.get(s);
				map.put(s, count + 1);
			}
		}
		return map;
	}

//	@SuppressWarnings("unchecked")
//	public JSONArray createAppResponseJSON(ArrayList<Order> orders) {
//		JSONArray appResponseStreams = new JSONArray();
//		for (Order order : orders) {
//
//			int orderID = order.getOrderID();
//			int coffee_machine_id = order.getCoffee_machine_id();
//			int status = order.getStatus();
//			JSONObject response = new JSONObject();
//			JSONObject responseDetail = new JSONObject();
//			String status_message = getStatus_message(status);
//			String error_message = order.getErrordesc();
//
//			responseDetail.put("orderID", orderID);
//			responseDetail.put("coffee_machine_id", coffee_machine_id);
//			responseDetail.put("status", status);
//			responseDetail.put("status-message", status_message);
//			if (status == 1) {
//				responseDetail.put("error-message", error_message);
//			}
//			response.put("user-response", responseDetail);
//			appResponseStreams.add(response);
//		}
//
//		System.out.println(appResponseStreams);
//		return appResponseStreams;
//	}
//
//	private static String getStatus_message(int status) {
//		if (status == 0) {
//			return "Your coffee has been prepared with your desired options.";
//		} else {
//			return "Your coffee order has been cancelled.";
//		}
//	}

}
