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
import presentation_layer.ResponseProcessor;

public class ProgrammableBehavior implements BrewBehavior {
	ResponseProcessor parser = new ResponseProcessor();
	String controllerType = "Programmable";

	public ProgrammableBehavior() {
	}

	@Override
	public ArrayList<OrderConResponse> brew(Order order) {

		try {
			JSONObject commandStreamsJSONFile = writeCommandStreams(order);
			System.out.println("[ProgrammableBehavior] " + commandStreamsJSONFile);
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
	public JSONArray writeCommandStreams(ArrayList<Order> orders) {

		JSONArray commandStreams = new JSONArray();
		for (Order order : orders) {
			JSONObject command = writeCommandStreams(order);
			commandStreams.add(command);
		}
//		System.out.println(commandStreams);
		return commandStreams;
	
	}

	@SuppressWarnings("unchecked")
	private JSONArray createCommandStepList(Order order) {
		JSONArray recipe = new JSONArray(); //"Recipe": [{}{}]
		ArrayList<JSONObject> stepsTemp = new ArrayList<JSONObject>();
		Drink drink = order.getDrink();
//		System.out.println(drink.getDrinkType());
		while(drink.getDrinkType().equals("Ingredient")) {
			JSONObject step = new JSONObject(); //{"commandstep": "steam", "object": "milk"}
			Ingredient ingredient = (Ingredient)drink;
			String commandStep = ingredient.getCommandStep();
			String objectName = ingredient.getObjectName();
			step.put("commandstep", commandStep);
			if(!objectName.equals("N/A")) {
				step.put("object", objectName);
			}
			stepsTemp.add(step);
			drink = ingredient.getWrappee();
//			System.out.println(drink.getDrinkType());
		}
		for(int i = 0; i < stepsTemp.size();i++) {
			recipe.add(stepsTemp.get(stepsTemp.size()-i-1));
		}
		return recipe;
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
		System.out.println("[ProgrammableBehavior] Sending Command for " + DrinkName + " OrderID: " + orderID);
		commandDetail.put("DrinkName", DrinkName);
		commandDetail.put("Requesttype", Requesttype);
		System.out.println(condiments);
		if (condiments.size() != 0) {
			JSONArray optionList = createOptionList(condiments);
			commandDetail.put("Options", optionList);
		}
		JSONArray commandSteps = createCommandStepList(order);
		commandDetail.put("Recipe", commandSteps);
		command.put("command", commandDetail);
		
		return command;
	}

	
	@SuppressWarnings("unchecked")
	private static JSONArray createOptionList(ArrayList<Condiment> condiments) {
		ArrayList<String> strings = new ArrayList<String>();
		JSONArray options = new JSONArray();
		for (Condiment i : condiments) {
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
}
