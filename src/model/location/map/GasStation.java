package model.location.map;

import model.location.NonColonyLocation;

public class GasStation extends NonColonyLocation {

	private static final int GAS_STATION_ENTRANCE_SIZE = 1;
	private static final int MAX_SURVIVOR_FREE_PLACES_IN_THE_GAS_STATION = 3;
	
	protected GasStation() {
		super(GAS_STATION_ENTRANCE_SIZE, "Gas Station");
	}
	
	@Override
	protected void generateItemsInLocation() {
		// TODO		
	}
	
}
