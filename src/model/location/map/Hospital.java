package model.location.map;

import model.location.NonColonyLocation;

public class Hospital extends NonColonyLocation {

	private static final int HOSPITAL_ENTRANCE_SIZE = 4;
	private static final int MAX_SURVIVOR_FREE_PLACES_IN_THE_HOSPITAL = 4;
	
	private static Hospital instance = null;
	
	public static Hospital getInstance(){
		if(instance == null)
			instance = new Hospital();
		return instance;
	}
	
	public Hospital() {
		super(HOSPITAL_ENTRANCE_SIZE, "Hospital", MAX_SURVIVOR_FREE_PLACES_IN_THE_HOSPITAL);
	}
	
}
