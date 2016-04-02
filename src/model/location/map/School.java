package model.location.map;

import model.location.NonColonyLocation;

public class School extends NonColonyLocation {

	private static final int SCHOOL_ENTRANCE_SIZE = 1;
	private static final int MAX_SURVIVOR_FREE_PLACES_IN_THE_SCHOOL = 4;
	
	public School() {
		super(SCHOOL_ENTRANCE_SIZE, "School");
	}
	
	@Override
	protected void generateItemsInLocation() {
		// TODO		
	}
	
}
