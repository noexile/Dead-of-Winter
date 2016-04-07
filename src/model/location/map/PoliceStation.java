package model.location.map;

import model.location.NonColonyLocation;

public class PoliceStation extends NonColonyLocation {
	
	private static final int POLICE_STATION_ENTRANCE_SIZE = 4;
	private static final int MAX_SURVIVOR_FREE_PLACES_IN_THE_POLICE_STATION = 3;
	
	private static PoliceStation instance = null;
	
	public static PoliceStation getInstance(){
		if(instance == null)
			instance = new PoliceStation();
		return instance;
	}
	
	public PoliceStation() {
		super(POLICE_STATION_ENTRANCE_SIZE, "Police Station", MAX_SURVIVOR_FREE_PLACES_IN_THE_POLICE_STATION);
	}

}
