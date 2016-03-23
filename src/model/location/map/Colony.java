package model.location.map;

import java.util.ArrayList;
import java.util.List;

import model.card.Item;
import model.interfaces.ISurvivalist;
import model.location.Location;

public class Colony extends Location {

	private static final int COLONY_ENTRANCE_SIZE = 6;
	private static final int MAX_SURVIVOR_FREE_PLACES_IN_THE_COLONY = 24;
	private ISurvivalist[] survivorsInColony;
	private int foodSupply;
	private List<Item> wastePile;
	
	
	public Colony() {
		super(COLONY_ENTRANCE_SIZE, "Colony");
		this.survivorsInColony = new ISurvivalist[MAX_SURVIVOR_FREE_PLACES_IN_THE_COLONY];
		this.foodSupply = 0;
		this.wastePile = new ArrayList<Item>();
	}

	
	// --------------------- METHODS --------------------- 
	public void survivorLeaveTheColony() {
		// TODO
	}

	public void survivorEnterTheColony(ISurvivalist survivor) {
		// TODO
	}
	
	
	// --------------------- GETTERS AND SETTERS --------------------- 
	public int getFoodSupply() {
		return foodSupply;
	}

	public void setFoodSupply(int foodSupply) {
		this.foodSupply = foodSupply;
	}
	
}
