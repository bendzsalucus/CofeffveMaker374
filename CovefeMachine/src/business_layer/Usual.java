package business_layer;

import java.util.ArrayList;

import interfaces.UsualCommand;

public class Usual implements UsualCommand{
	private ArrayList<Order> usualOrders = new ArrayList<Order>();
	private String unsualName;
	private Server server;
	
	public Usual(ArrayList<Order> arraustinUsualOrders) {
		// TODO Auto-generated constructor stub.
		usualOrders = arraustinUsualOrders;
	}
	
	@Override
	public void execute() {
		for(Order currentOrder: usualOrders){
//			System.out.println(currentOrder.getDrinkName());
			server.update(currentOrder);
		}
	}

	public ArrayList<Order> getUsualOrders() {
		return usualOrders;
	}

	public void setUsualOrders(ArrayList<Order> usualOrders) {
		this.usualOrders = usualOrders;
	}
	
	public void setServer(Server server){
		this.server = server;
	}

	public void getOrderDrinkName() {
		for(Order currentOrder: usualOrders) {
			System.out.println("[Usual] " + currentOrder.getDrinkName());
		}
		
	}

}
