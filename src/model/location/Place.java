package model.location;

import model.interfaces.IOccupant;

public class Place {
	
	private IOccupant occupant;
	
	public IOccupant getOccupant() {
		return occupant;
	}
	
	public boolean isOccupied(){
		return occupant != null;
	}

	public void setOccupant(IOccupant occupant) {
		this.occupant = occupant;
	}
	
}
