package model.location;

import java.util.ArrayList;
import java.util.List;

import model.character.Survivor;
import model.interfaces.ISurvivalist;

public abstract class Location implements ISurvivalist{
	
	private String locationName;
	private Entrance[] entrances;
	private List<ISurvivalist> survivors;
	private final int survivorsLimit;
	
	protected Location(int size, String locationName, int survivorsLimit) {
		this.entrances = new Entrance[size];
		this.locationName = locationName;
		this.survivors = new ArrayList<ISurvivalist>();
		this.survivorsLimit = survivorsLimit;
	}

	
	// GETTERS AND SETTERS
	public Entrance[] getEntrances() {
		return entrances;
	}

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
	
}
