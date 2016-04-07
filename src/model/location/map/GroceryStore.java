package model.location.map;

import model.location.NonColonyLocation;

public class GroceryStore extends NonColonyLocation {

	private static final int GROCERY_STORE_ENTRANCE_SIZE = 4;
	private static final int MAX_SURVIVOR_FREE_PLACES_IN_THE_GROCERY_STORE = 3;
	
	private static GroceryStore instance = null;
	
	public static GroceryStore getInstance(){
		if(instance == null)
			instance = new GroceryStore();
		return instance;
	}
	
	public GroceryStore() {
		super(GROCERY_STORE_ENTRANCE_SIZE, "Grocery Store", MAX_SURVIVOR_FREE_PLACES_IN_THE_GROCERY_STORE);
	}
	
}
