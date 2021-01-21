package business_layer;

public class SimpleBehavior implements BrewBehavior {

	@Override
	public void brew() {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {}
	}
	
	

}
