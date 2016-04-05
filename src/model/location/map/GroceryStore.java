package model.location.map;

import model.location.NonColonyLocation;

public class GroceryStore extends NonColonyLocation {

	private static final int GROCERY_STORE_ENTRANCE_SIZE = 4;
	private static final int MAX_SURVIVOR_FREE_PLACES_IN_THE_GROCERY_STORE = 3;
	
	public GroceryStore() {
		super(GROCERY_STORE_ENTRANCE_SIZE, "Grocery Store", MAX_SURVIVOR_FREE_PLACES_IN_THE_GROCERY_STORE);
	}
	
}
