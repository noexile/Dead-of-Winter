package model.location.map;

import model.location.Location;

public class Colony extends Location {

	private static final int COLONY_ENTRANCE_SIZE = 18;
	private static final int MAX_SURVIVOR_FREE_PLACES_IN_THE_COLONY = 24;
	private int foodSupply;
	private int wastePileSize;
	private int crisisContributionCards;
	
	private static Colony instance = null;
	
	public static Colony getInstance(){
		if(instance == null)
			instance = new Colony();
		return instance;
	}
	
	private Colony() {
		super(COLONY_ENTRANCE_SIZE, "Colony", MAX_SURVIVOR_FREE_PLACES_IN_THE_COLONY);
		this.foodSupply = 0;
		this.wastePileSize = 0;
		this.crisisContributionCards = 0;
	}	
	
	
	// METHODS
	public void clearWastePile() {
		if (this.wastePileSize >= 3) {
			this.wastePileSize -= 3;
		} else {
			this.wastePileSize = 0;
		}
	}
	
	public void addCardToWastePile() {
		this.wastePileSize += 1;
	}
	
	public void resetCrisisCards() {
		this.crisisContributionCards = 0;
	}
	
	public void addFoodToColony() {
		this.foodSupply += 1;
	}
	
	public void resetCrisisContributionCards() {
		this.crisisContributionCards = 0;
	}
	
	public void resetWastePile() {
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
	
	public int getCrisisContributionCards() {
		return crisisContributionCards;
	}

	public void addCrisisContributionCard() {
		this.crisisContributionCards++;
	}
	
}
