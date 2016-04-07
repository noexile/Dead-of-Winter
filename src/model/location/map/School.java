package model.location.map;

import model.location.NonColonyLocation;

public class School extends NonColonyLocation {

	private static final int SCHOOL_ENTRANCE_SIZE = 4;
	private static final int MAX_SURVIVOR_FREE_PLACES_IN_THE_SCHOOL = 4;
	
	private static School instance = null;
	
	public static School getInstance(){
		if(instance == null)
			instance = new School();
		return instance;
	}
	
	public School() {
		super(SCHOOL_ENTRANCE_SIZE, "School", MAX_SURVIVOR_FREE_PLACES_IN_THE_SCHOOL);
	}
	
}
