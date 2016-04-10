package model.location;

import java.util.ArrayList;
import java.util.List;

import model.interfaces.ISurvivalist;

public abstract class Location {
	
	private String locationName;
	private Entrance entrance;
	private List<ISurvivalist> survivors;
	private final int survivorsLimit;
	private final int zombieLimit;
	
	protected Location(int size, String locationName, int survivorsLimit) {
		this.entrance = new Entrance(size);
		this.locationName = locationName;
		this.survivors = new ArrayList<ISurvivalist>();
		this.survivorsLimit = survivorsLimit;
		this.zombieLimit = size;
	}
	
	
	// GETTERS AND SETTERS
	public List<ISurvivalist> getSurvivors() {
		return survivors;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public int getSurvivorsLimit() {
		return survivorsLimit;
	}
	
	public Entrance getEntrance() {
		return entrance;
	}
	
	public int getOcupiedPlaces(){
		return entrance.getOcupiedPlaces();
	}

	public int getZombieLimit() {
		return zombieLimit;
	}
	

}
