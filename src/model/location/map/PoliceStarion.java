package model.location.map;

import model.location.NonColonyLocation;

public class PoliceStarion extends NonColonyLocation {
	
	private static final int POLICE_STATION_ENTRANCE_SIZE = 1;
	private static final int MAX_SURVIVOR_FREE_PLACES_IN_THE_POLICE_STATION = 4;
	
	protected PoliceStarion() {
		super(POLICE_STATION_ENTRANCE_SIZE, "Police Station", MAX_SURVIVOR_FREE_PLACES_IN_THE_POLICE_STATION);
	}

}
