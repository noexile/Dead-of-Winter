package model.location.map;

import model.location.NonColonyLocation;

public class GasStation extends NonColonyLocation {

	private static final int GAS_STATION_ENTRANCE_SIZE = 3;
	private static final int MAX_SURVIVOR_FREE_PLACES_IN_THE_GAS_STATION = 2;
	
	private static GasStation instance = null;
	
	public static GasStation getInstance(){
		if(instance == null)
			instance = new GasStation();
		return instance;
	}
	
	private GasStation() {
		super(GAS_STATION_ENTRANCE_SIZE, "Gas Station", MAX_SURVIVOR_FREE_PLACES_IN_THE_GAS_STATION);
	}
	
}
