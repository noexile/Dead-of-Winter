package model.location.map;

import model.location.NonColonyLocation;

public class Hospital extends NonColonyLocation {

	private static final int HOSPITAL_ENTRANCE_SIZE = 1;
	private static final int MAX_SURVIVOR_FREE_PLACES_IN_THE_HOSPITAL = 3;
	
	public Hospital() {
		super(HOSPITAL_ENTRANCE_SIZE, "Hospital");
	}
	
	@Override
	protected void generateItemsInLocation() {
		// TODO		
	}
	
}
