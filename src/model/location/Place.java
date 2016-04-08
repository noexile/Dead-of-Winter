package model.location;

import model.interfaces.IOccupant;

public class Place {
	
	private IOccupant occupant;
	private final Entrance placeForEntrance;
	
	public Place(Entrance placeForEntrance) {
		this.placeForEntrance = placeForEntrance;
	}
	
	public IOccupant getOccupant() {
		return occupant;
	}
	
	public boolean isOccupied(){
		return occupant != null;
	}

	public void setOccupant(IOccupant occupant) {
		this.occupant = occupant;
	}
	
	public Entrance getPlaceForEntrance() {
		return placeForEntrance;
	}
	
}
