package model.location.map;

import model.location.NonColonyLocation;

public class Library extends NonColonyLocation {

	private static final int LIBRARY_ENTRANCE_SIZE = 1;
	private static final int MAX_SURVIVOR_FREE_PLACES_IN_THE_LIBRARY = 3;
	
	public Library() {
		super(LIBRARY_ENTRANCE_SIZE, "Library", MAX_SURVIVOR_FREE_PLACES_IN_THE_LIBRARY);
	}
	
}
