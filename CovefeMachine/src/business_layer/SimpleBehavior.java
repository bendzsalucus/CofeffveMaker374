package business_layer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import presentation_layer.OrderConResponse;
import presentation_layer.Parsers;

public class SimpleBehavior implements BrewBehavior {
	String controllerType = "Simple";
	Parsers parser = new Parsers();
	public SimpleBehavior() {}
	@Override
	public ArrayList<OrderConResponse> brew(Order order) {
		try {
			JSONObject commandStreamsJSONFile= writeCommandStreams(order);
			System.out.println("[SimpleBehavior] " + commandStreamsJSONFile);
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
		System.out.println("[SimpleBehavior] Sending Command for " + DrinkName + " OrderID: " + orderID);
		commandDetail.put("DrinkName", DrinkName);
		commandDetail.put("Requesttype", Requesttype);

		command.put("command", commandDetail);
		return command;
	}
	

}
