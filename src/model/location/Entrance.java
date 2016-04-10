package model.location;

import java.util.ArrayList;
import java.util.List;

public class Entrance {
	
	public final int MAX_FREE_PLACES;
	private List<Place> places;
	private int freePlaces;
	
	
	public Entrance(int size) {
		this.MAX_FREE_PLACES = size;
		this.freePlaces = this.MAX_FREE_PLACES;
		this.places = new ArrayList<Place>();
		for(int i = 0; i < MAX_FREE_PLACES; i++){
			places.add(new Place(this));
		}
	}

	
	// METHODS
	public int getOcupiedPlaces(){
		int occupied = 0;
		for(Place p : places){
			if(p.isOccupied()){
				occupied++;
			}
		}
		return occupied;
	}
	
	public void removeOccupant(){
		for(int i = places.size()-1;i>=0;i--){
			if(places.get(i).isOccupied()){
				places.get(i).setOccupant(null);
				freePlaces++;
				break;
			}
		}
	}
	
	
	// GETTERS AND SETTERS
	public int getFreePlaces() {
		return freePlaces;
	}
	
	public void occupyPlace() {
		this.freePlaces--;
	}
	
	public int getMaxFreePlaces() {
		return MAX_FREE_PLACES;
	}

	public List<Place> getPlaces() {
		return places;
	}
	
}
