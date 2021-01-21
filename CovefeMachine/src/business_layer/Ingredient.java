package business_layer;

import java.util.ArrayList;

public class Ingredient {
	
	private String name;
	private String description; 
	
	public Ingredient(String name, String desciption)
	{	
		this.name = name;
		this.description = desciption;
	}
	
	public String getName() {
		return this.name;
	}
	public String getDescription() {
		return this.description;
	}
}
