package model.location.map;

import model.location.Location;

public class Colony extends Location {

	private static final int COLONY_ENTRANCE_SIZE = 1;
	private static final int MAX_SURVIVOR_FREE_PLACES_IN_THE_COLONY = 24;
	private int foodSupply;
	private int wastePileSize;
	
	
	public Colony() {
		super(COLONY_ENTRANCE_SIZE, "Colony", MAX_SURVIVOR_FREE_PLACES_IN_THE_COLONY);
		this.foodSupply = 0;
		this.wastePileSize = 0;
	}	
	
	
	// --------------------- GETTERS AND SETTERS --------------------- 
	public int getFoodSupply() {
		return foodSupply;
	}

	public void setFoodSupply(int foodSupply) {
		this.foodSupply = foodSupply;
	}

	public int getWastePileSize() {
		return wastePileSize;
	}

	public void setWastePileSize(int wastePile) {
		this.wastePileSize = wastePile;
	}
	
}
