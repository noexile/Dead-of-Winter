package model.location.map;

import model.location.NonColonyLocation;

public class Library extends NonColonyLocation {

	private static final int LIBRARY_ENTRANCE_SIZE = 3;
	private static final int MAX_SURVIVOR_FREE_PLACES_IN_THE_LIBRARY = 3;
	
	private static Library instance = null;
	
	public static Library getInstance(){
		if(instance == null)
			instance = new Library();
		return instance;
	}
	
	public Library() {
		super(LIBRARY_ENTRANCE_SIZE, "Library", MAX_SURVIVOR_FREE_PLACES_IN_THE_LIBRARY);
	}
	
}
