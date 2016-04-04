package model.location;

import java.util.ArrayList;
import java.util.List;

public class Entrance {
	
	public final int MAX_FREE_PLACES;
	private List<Place> places;
	private int freePlaces;
	
	
	public Entrance(int size) {
		this.places = new ArrayList<Place>();
		this.MAX_FREE_PLACES = size;
		this.freePlaces = this.MAX_FREE_PLACES;
	}
	
	
	// GETTERS AND SETTERS
	public int getFreePlaces() {
		return freePlaces;
	}
	
	public int getMaxFreePlaces() {
		return MAX_FREE_PLACES;
	}

	public List<Place> getPlaces() {
		return places;
	}

}
