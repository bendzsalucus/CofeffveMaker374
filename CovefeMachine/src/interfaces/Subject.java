package interfaces;

import business_layer.Order;

public interface Subject {
	
	public void registerObserver(Observer o);
	
	public void removeObserver(Observer o);
	
	public void notifyObservers();

	void notifyObservers(Order order);
}
